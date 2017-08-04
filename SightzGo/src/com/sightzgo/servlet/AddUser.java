package com.sightzgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import net.sf.json.JSONObject;
//import java.rmi.RemoteException;
import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
import net.sf.json.JSONObject;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;  

import com.sightzgo.dao.UserDao;  
import com.sightzgo.dao.impl.UserDaoImpl;  
import com.sightzgo.entity.User;

/**
 * Servlet implementation class AddUserServlet
 */
//@WebServlet("/AddUserServlet") web.xml和注解只能二选一，不然会冲突
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
        
//得到数据
        int success=0;
        
        
  /*    String loginname = request.getParameter("loginname"); 
        if(loginname==null) success=2;    
        String password = request.getParameter("password"); 
        if(password==null) success=3;     
        String type=request.getParameter("type");   
        if(type==null) success=4;
        */
      
        String loginname = request.getParameter("loginname"); 
        if(loginname=="") success=2;    
        String password =request.getParameter("password"); 
        if(password=="") success=3;     
        String type=request.getParameter("type");   
        if(type=="") success=4;
        
        Date currentdate = new Date();  
        String date = new SimpleDateFormat("yyyy-MM-dd").format(currentdate);
        
//执行操作   
        if(success==0)
        {
        User u=new User(0,loginname,password,type,"1",date);
        UserDao ud = new UserDaoImpl(); 
        success=ud.addUser(u);
        }
     
        JSONObject jsonObj=new JSONObject();
        jsonObj.accumulate("success", success);
        PrintWriter out = response.getWriter();
        out.print(jsonObj);
        

	}

}
