package com.sightzgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sightzgo.dao.UserDao;
import com.sightzgo.dao.impl.UserDaoImpl;
import com.sightzgo.entity.User;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getAllUsers
 */
@WebServlet("/getAllUsers")
public class GetAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllUsers() {
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
		response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");
		  
        List<User> userlist=new ArrayList<User>();                       
        try {
        	UserDao ud = new UserDaoImpl(); 
			userlist=ud.getAllUsers();	 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        JSONArray jsonarray = new JSONArray();                   
        jsonarray=JSONArray.fromObject(userlist); 
 
        
        PrintWriter out = response.getWriter();  
        out.write(jsonarray.toString()); 
	}

}
