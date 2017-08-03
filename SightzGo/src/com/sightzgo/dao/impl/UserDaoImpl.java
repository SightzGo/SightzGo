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
	public int findUserId(String name, String password) {
		// TODO Auto-generated method stub
		return 0;
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
	
	
    
   
    

}
