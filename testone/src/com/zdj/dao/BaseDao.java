package com.zdj.dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 

public class BaseDao {
	public static final String DRIVER = "com.mysql.jdbc.Driver";  
    public static final String URL = "jdbc:mysql://localhost:3306/zdf"; //�ɶ�̬�޸������ӵ����ݿ� 
    public static final String USER = "root";  
    public static final String PASSWORD = "GNzhengxun11";  
  
    Connection conn = null;  
    PreparedStatement pstmt = null;  
    ResultSet rs = null;  
  
    //�������ݿ⺯��
    public void getConnection() {  
        try {  
            Class.forName(DRIVER); //ע�����ݿ����� 
            conn = DriverManager.getConnection(URL, USER, PASSWORD); //�������ݿ� 
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  //�쳣������ʾ�켣
        }  
    }  
  
    //�������ݿ⺯����sqlΪ��ѯ��䣬objΪ��ѯ�����Ҫ�ŵĲ���
    public int executeUpdate(String sql, Object... obj) {  
        int num = 0;  
        getConnection();  //ÿ�θ���ǰ��Ҫ������һ�����ݿ⣿����
        try {  
            pstmt = conn.prepareStatement(sql);  
            for (int i = 0; i < obj.length; i++) {  
                pstmt.setObject(i + 1, obj[i]);  //��i��λ�÷�obj[i]
            }  
            num = pstmt.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            closeAll();  
        }  
        return num;  //���²�����1��0�����Ƿ���³ɹ�
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
        return rs;  //��ѯ���������ز�ѯ�Ľ����
    }  
  
    
    //�ر�ResultSet��Ķ���,�ر�prepareStatement��Ķ��󣬹ر�Connection��Ķ���ͨ��������������ĺ���
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
