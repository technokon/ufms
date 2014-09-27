package com.transaction.manager;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.entity.processor.Credentials;
import com.entity.processor.User;

@SessionScoped
@Model
public class Login implements Serializable {
	private static final long serialVersionUID = 7563920137272795705L;
	
	@Inject
	private Credentials credentials;
	
	private User user;
	 
	public void login() {
		if (credentials.getUsername().equalsIgnoreCase("Admin")
				&& credentials.getPassword().equals("passvord")){
			user = new User();
			user.setUserName(credentials.getUsername());
			user.setPassword(credentials.getPassword());
		}
	}
	
	public void logout() {
		user = null;
	}
	
	@Produces
	User getCurrentUser() throws Exception {
		if (user == null) {
			throw new Exception("Not logged in");
		}else {
			return user;
		}
	}
	
	

}
