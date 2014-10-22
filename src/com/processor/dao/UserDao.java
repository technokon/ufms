package com.processor.dao;

import java.util.List;

import com.entity.processor.User;

public interface UserDao {
	
	public User makePersistent(User user);
	
	public User getUser(String username);
	
	public List<User> getAllUsers();

}
