package com.sightzgo.dao;

import com.sightzgo.entity.User;


import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	    public int addUser(User u);  
	    public int delUser(int id);  //ʲô����»���ɾ������
	    public int updateUser(int id);//��ɾ����״̬��Ϊ0
	    public int findUserId(String loginname,String password);//ͨ���û������ʺ��ҵ�ID
	    public User findUserById(int id);  
	    public List<User> getAllUsers() throws SQLException; //���User�������û���Ϊʲô������Ҫ�׳��쳣������

}
