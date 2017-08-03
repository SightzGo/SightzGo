package com.sightzgo.dao;

import com.sightzgo.entity.User;


import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	    public int addUser(User u);  
	    public int delUser(int id);  //什么情况下会真删？？？
	    public int updateUser(int id);//假删，把状态设为0
	    public int findUserId(String loginname,String password);//通过用户名和帐号找到ID
	    public User findUserById(int id);  
	    public List<User> getAllUsers() throws SQLException; //获得User表所有用户，为什么在这里要抛出异常？？？

}
