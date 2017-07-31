package com.zdf.servlet;
import com.zdf.servlet.ServletUsers;
import com.zdj.dao.UsersDao;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zdf.dao.impl.UsersDaoImpl;  
import com.zdf.entity.Users; 
public class main {

	
	  public static void main(String[] args) {
	 
		// TODO Auto-generated method stub
		 UsersDao ud = new UsersDaoImpl(); 
		 List<Users> ulist = null;
			try {
				ulist = ud.getAllUsers();
				System.out.println(ulist);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	}

	 
	//ServletUsers testone =new  ServletUsers();
	
			
}
