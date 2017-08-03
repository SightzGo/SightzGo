package com.sightzgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sightzgo.dao.UserDao;
import com.sightzgo.dao.impl.UserDaoImpl;
import com.sightzgo.entity.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DelUser
 */
@WebServlet("/DelUser")
public class DelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try{String ids = request.getParameter("id"); //表单数据只能为字符型
		int id = Integer.parseInt(ids);
		UserDao ud = new UserDaoImpl();
		int success=ud.delUser(id);		
		JSONObject jsonObj=new JSONObject();
        jsonObj.accumulate("success", success);
        PrintWriter out = response.getWriter();
        out.println(jsonObj.toString());}
		catch(Exception e) {  
            e.printStackTrace();  
        }  		
		
		
	}

}
