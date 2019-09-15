package com.nku.herb_chain.dao;
import com.nku.herb_chain.domain.User;
public class UserDao {
	private User user;
	
	public UserDao(User user) {
		super();
		this.user = user;
	}
	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User FindUserByName(String name){
		user=new User();
		user.setUsername(name);
		user.setPassword("123456");
		
		return user;
	}
	public User Registration(String name,String password){
		return null;
	}
}
