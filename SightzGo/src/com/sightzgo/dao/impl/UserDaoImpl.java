package com.sightzgo.dao.impl;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sightzgo.dao.BaseDao;  
import com.sightzgo.dao.UserDao;  
import com.sightzgo.entity.User;



public class UserDaoImpl extends BaseDao  implements  UserDao {
    Connection conn = null;  
    PreparedStatement pstmt = null;  
    ResultSet rs = null;
    
    
    
	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		int success=0;
		 String sql = "insert into user(loginname,password,type,status,logindate) values(?,?,?,?,?)";  
         try {  
        	 success = executeUpdate(sql, u.getLoginname(), u.getPassword(),u.getType(),u.getStatus(),u.getDate()); 
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
         return success;  
	}



	@Override
	public int delUser(int id) {
		// TODO Auto-generated method stub
		int success=0;
		String sql="update user set status=0 where id=?";
		try{
			success=executeUpdate(sql, id);
		}catch (Exception e) {  
            e.printStackTrace();  
        }  		
		return success;
	}



	@Override
	public int updateUser(int id) {
		// TODO Auto-generated method stub

		return 0;
	}



	@Override
	public int findUserId(String loginname, String password) {
		// TODO Auto-generated method stub
		int id=0;//=0时不存在该用户
		String sql="select id from user where loginname=? and password=? ";
		try{
			rs=executeQuery(sql,loginname,password);
			if (rs.next())
			{id=rs.getInt(1);}
		}catch (Exception e) {  
            e.printStackTrace();  
        }  		
		return id;
	}



	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<User> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		 List<User> userlist = new ArrayList<User>();  
		 String sql = "select * from user";  
         rs = executeQuery(sql);  
         try {  
             while (rs.next()) {  
                 User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));  
                 userlist.add(u);                 
             }  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
         
         return userlist;  
	}



	@Override
	public int findUserName(String loginname) {
		// TODO Auto-generated method stub
		int success=0;//=0时不存在该用户
		String sql="select id from user where loginname=? ";
		try{
			rs=executeQuery(sql,loginname);
			if (rs.next())
			{success=1;}
		}catch (Exception e) {  
            e.printStackTrace();  
        }  		
		return success;
	}



	@Override
	public int findUserPassword(String loginname) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
    
   
    

}
