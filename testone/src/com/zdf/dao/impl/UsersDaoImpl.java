    package com.zdf.dao.impl;  
      
    import java.sql.Connection;  
    import java.sql.PreparedStatement;  
    import java.sql.ResultSet;  
    import java.sql.SQLException;  
    import java.util.ArrayList;  
    import java.util.List;  
    
    
      
    import com.zdj.dao.BaseDao;  
    import com.zdj.dao.UsersDao;  
    import com.zdf.entity.Users;  
      
    public class UsersDaoImpl extends BaseDao implements UsersDao {  
      
        Connection conn = null;  
        PreparedStatement pstmt = null;  
        ResultSet rs = null;  
      
        @Override  
        public int addUser(Users u) {  
            int num = 0;  
            String sql = "insert into user(name,age) values(?,?)";  
            try {  
                num = executeUpdate(sql, u.getName(), u.getAge());  //u是user类的实例对象，
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            return num;  
        }  
      
        @Override  
        public int delUser(int id) {  
            int num = 0;  
            String sql = "delete from user where id=?";  
            try {  
                num = executeUpdate(sql, id);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            return num;  
        }  
      
        @Override  
        public int updateUser(Users u) {  
            int num = 0;  
            String sql = "update user set name=?,age=? where id=?";  
            try {  
                num = executeUpdate(sql, u.getName(), u.getAge(), u.getId());  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            return num;  
        }  
      
        @Override  
        public Users findUserById(int id) {  
            Users u = null;  
            String sql = "select * from user where id=?";  
            rs = executeQuery(sql, id);  
            try {  
                if (rs.next()) {  
                    u = new Users(rs.getInt(1), rs.getString(2), rs.getInt(3));  //rs.get类型(i),得到第几列
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
            return u;  
        }  
      
        @Override  
        public List<Users> getAllUsers() throws SQLException {  
            List<Users> ulist = new ArrayList<Users>();  //user类实例的数组
            String sql = "select * from user";  
            rs = executeQuery(sql);  
            try {  
                while (rs.next()) {  
                    Users u = new Users(rs.getInt(1), rs.getString(2), rs.getInt(3));  
                    ulist.add(u);  //把每一行的user存到数组
                   
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
            
            return ulist;  
        }  
      
    }  
