package com.sightzgo.dao;

import com.sightzgo.entity.User;


import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	    public int addUser(User u);  
	    public int delUser(int id);  //假删，把状态设为0
	    public int updateUser(int id);
	    public int findUserId(String loginname,String password);//通过用户名和帐号找到ID
	    public int findUserName(String loginname);
	    public int findUserPassword(String loginname);
	    public User findUserById(int id);  
	    public List<User> getAllUsers() throws SQLException; //获得User表所有用户，为什么在这里要抛出异常？？？

}
