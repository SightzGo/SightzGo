package com.zdj.dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 

public class BaseDao {
	public static final String DRIVER = "com.mysql.jdbc.Driver";  
    public static final String URL = "jdbc:mysql://localhost:3306/zdf"; //可动态修改想连接的数据库 
    public static final String USER = "root";  
    public static final String PASSWORD = "GNzhengxun11";  
  
    Connection conn = null;  
    PreparedStatement pstmt = null;  
    ResultSet rs = null;  
  
    //连接数据库函数
    public void getConnection() {  
        try {  
            Class.forName(DRIVER); //注册数据库驱动 
            conn = DriverManager.getConnection(URL, USER, PASSWORD); //连接数据库 
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  //异常处理，显示轨迹
        }  
    }  
  
    //更新数据库函数，sql为查询语句，obj为查询语句需要放的参数
    public int executeUpdate(String sql, Object... obj) {  
        int num = 0;  
        getConnection();  //每次更新前都要先连接一次数据库？？？
        try {  
            pstmt = conn.prepareStatement(sql);  
            for (int i = 0; i < obj.length; i++) {  
                pstmt.setObject(i + 1, obj[i]);  //第i个位置放obj[i]
            }  
            num = pstmt.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            closeAll();  
        }  
        return num;  //更新操作，1，0返回是否更新成功
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
        return rs;  //查询操作，返回查询的结果集
    }  
  
    
    //关闭ResultSet类的对象,关闭prepareStatement类的对象，关闭Connection类的对象；通过对象来调用类的函数
    public void closeAll() {  
        try {  
            rs.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        try {  
            pstmt.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        try {  
            conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}
