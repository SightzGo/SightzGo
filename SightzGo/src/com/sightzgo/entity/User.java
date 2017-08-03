package com.sightzgo.entity;

//user实体类，包括id,name,password,type四个字段
public class User {

	private int id;
	private String loginname;
	private String password;
	private String type;
	private String status;
	private String date;
	

	public User(int id, String loginname, String password, String type,String status,String date) {
		this.id = id;
		this.loginname = loginname;
		this.password = password;
		this.type = type;
		this.status=status;
		this.date=date;
	}

	public User() {
	};
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getLoginname(){
		return loginname;
	}
	
	public void setLoginname(String username){
		this.loginname=username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
    }
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
		this.status=status;
	}

	public String getDate(){
		return date;
	}
	
	public void setDate(String date){
		this.date=date;
    }
	
}
