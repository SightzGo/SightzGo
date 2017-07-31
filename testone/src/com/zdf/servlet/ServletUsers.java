
package com.zdf.servlet;  
  
import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
import com.zdj.dao.UsersDao;  
import com.zdf.dao.impl.UsersDaoImpl;  
import com.zdf.entity.Users; 
/**
 * Servlet implementation class ServletUsers
 */

public class ServletUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletUsers() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request, response);
	}//doget用dopos的方法

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    response.setContentType("text/html;charset=utf-8");  
	        request.setCharacterEncoding("utf-8");  
	        HttpSession session = request.getSession(); 
	        PrintWriter out = response.getWriter();  //服务器响应，输出流
	  
	        UsersDao ud = new UsersDaoImpl();  //u是user类，ud是操作user类
	  
	        String dos = request.getParameter("do");  //dos获取客户传递过来的的参数值
	        if (dos == null || dos.equals("")) {  
	            dos = "index";  
	        }  
	        // 主页  
	        if (dos.equals("index")) {  
	            List<Users> ulist = null;
				try {
					ulist = ud.getAllUsers();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	            session.setAttribute("ulist", ulist);  
	            response.sendRedirect("index.jsp");  //返回这个页面
	           return;  
	        }  
	        if (dos.equals("add")) {  
	        	
	        
	            String name = request.getParameter("name");  
	            String ages = request.getParameter("age");  
	            int age = Integer.parseInt(ages);  
	            Users u = new Users(0, name, age);  //id为0，在操作数据库时ID会增
	            ud.addUser(u);  
	            out.print("<script>alert('新增成功！');window.location='ServletUsers?do=index';</script>");  
	        }  
	        if (dos.equals("del")) {  
	            String ids = request.getParameter("id");  
	            int id = Integer.parseInt(ids);  
	            ud.delUser(id);  
	            out.print("<script>alert('删除成功！');window.location='ServletUsers?do=index';</script>");  
	            return;  
	        }  
	        if (dos.equals("editbefore")) {  
	            String ids = request.getParameter("id");  
	            int id = Integer.parseInt(ids);  
	           Users u=ud.findUserById(id);  
	           session.setAttribute("edituser", u);  //edituser储存要删除id的user的全部信息
	           response.sendRedirect("edit.jsp"); //跳转到修改页面	          
	            return;  
	        }  
	        if (dos.equals("edit")) {  
	            String ids=request.getParameter("id");  //修改的话，原来的id信息要删除吗？???
	            int id=Integer.parseInt(ids);  
	            String name = request.getParameter("name");  
	            String ages = request.getParameter("age");  
	            int age = Integer.parseInt(ages);  
	            Users u = new Users(id, name, age);  
	            ud.updateUser(u);  
	            out.print("<script>alert('修改成功！');window.location='ServletUsers?do=index';</script>");  
	            return;  
	        }
	}

}
