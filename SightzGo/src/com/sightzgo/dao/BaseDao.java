package com.sightzgo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	public static final String DRIVER = "com.mysql.jdbc.Driver";  
    public static final String URL = "jdbc:mysql://localhost:3306/sighzgo"; 
    public static final String USER = "root";  
    public static final String PASSWORD = "GNzhengxun11";  
  
    Connection conn = null;  
    PreparedStatement pstmt = null;  
    ResultSet rs = null;  
  
 
    public void getConnection() {  
        try {  
            Class.forName(DRIVER); 
            conn = DriverManager.getConnection(URL, USER, PASSWORD); 
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace(); 
        }  
    }  
  

    public int executeUpdate(String sql, Object... obj) {  
        int num = 0;  
        getConnection();  
        try {  
        	
            pstmt = conn.prepareStatement(sql);  
            for ( int i=0; i < obj.length; i++) {  
                pstmt.setObject(i + 1, obj[i]);  //第i个位置放obj[i];
            }  
            num = pstmt.executeUpdate();          
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
        	
            closeAll();  
        }
		return num;  
      
    }  
    
    
    public ResultSet executeQuery(String sql, Object... obj) {  
        getConnection();  
        try {  
            pstmt = conn.prepareStatement(sql);  
            for (int i = 0; i < obj.length; i++) {  
                pstmt.setObject(i + 1, obj[i]);  
            }  
            rs = pstmt.executeQuery();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rs;  
    }  
  
    
    public void closeAll() {  
        try {  
        	if(rs!=null)
            rs.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        try {  
        	if(pstmt!=null)
            pstmt.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        try {  
        	if(pstmt!=null)
            conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}
