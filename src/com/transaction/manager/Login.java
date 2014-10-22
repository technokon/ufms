package com.transaction.manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.entity.processor.Credentials;
import com.entity.processor.Transaction;
import com.entity.processor.User;
import com.processor.dao.TransactionDAO;
import com.processor.dao.UserDao;
import com.processor.utils.PasswordHasher;

@SessionScoped
@Model
public class Login implements Serializable {
	private static final long serialVersionUID = -7665912439280494601L;

	@Inject
	private Credentials credentials;

	@EJB
	private TransactionDAO dao;

	@EJB
	private UserDao userDao;

	private User user;

	private List<Transaction> transactions;

	public String login() {
		// DB
		FacesContext fContext = FacesContext.getCurrentInstance();

		if (checkCredentials()) {
			// Get user from DB
			User user = userDao.getUser(credentials.getUsername());
			if (user == null) {
				// Add error message - invalid credentials
				fContext.addMessage(null, new FacesMessage(
						"Invalid Credentials"));
				return null;
			}
			// Check password.
			PasswordHasher ph = new PasswordHasher();
			if (ph.isEqual(credentials.getPassword(), user.getSalt(),
					user.getHashedPassword())) {
				// Retrieve transaction
				transactions = dao.retrieveTransactions();
				System.out.println(transactions);
				return "transactions";
			}

		}
		// Add error message
		fContext.addMessage(null, new FacesMessage("Invalid Credentials"));
		return null;
	}

	public String register() {
		FacesContext fContext = FacesContext.getCurrentInstance();
		if (checkCredentialsForRegistration()) {
			// Get user from DB
			if (userDao.getUser(credentials.getUsername()) != null) {
				fContext.addMessage(null,
						FacesMessage("Username taken! Choose anothe one."));
				return null;
			}
			// Persist User
			User user = new User();
			user.setUsername(credentials.getUsername());
			// Hash password
			PasswordHasher ph = new PasswordHasher();
			String[] hashes = ph.hash(credentials.getPassword());
			user.setHashedPassword(hashes[0]);
			user.setSalt(hashes[1]);
			user.setFirstName(credentials.getFirstName());
			user.setLastName(credentials.getLastName());
			user = userDao.makePersistent(user);

			if (user != null) {
				return "login";
			}

		}
		// Add error message
		fContext.addMessage(null, new FacesMessage("Invalid Credentials"));
		return null;

	}

	private FacesMessage FacesMessage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkCredentials() {
		if (credentials.getUsername() != null
				&& credentials.getUsername().length() > 0
				&& credentials.getPassword() != null
				&& credentials.getPassword().length() > 0) {
			return true;

		}
		return false;

	}

	private boolean checkCredentialsForRegistration() {

		if (credentials.getUsername() != null
				&& credentials.getUsername().length() > 0
				&& credentials.getPassword() != null
				&& credentials.getPassword().length() > 0
				&& credentials.getConfirmPassword() != null
				&& credentials.getConfirmPassword().length() > 0
				&& credentials.getPassword().equals(
						credentials.getConfirmPassword())) {
			return true;
		}
		return false;

	}

	public void logout() {
		user = null;
	}

	public boolean isLoggedIn() {
		return user != null;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

}
