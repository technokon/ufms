package com.processor.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entity.processor.User;

@Stateless
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User makePersistent(User user) {
		em.persist(user);
		return user;
	}
	@Override
	public User getUser(String username) {
		User u = null;
		
		try{
			u = em.createQuery(
					"select u from User u where u.username = :username",
					User.class).setParameter("username", username)
					.getSingleResult();
		}catch (NoResultException e) {
			e.printStackTrace();
		}catch (NonUniqueResultException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	
	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> q = em.createQuery(
				"select u from User u", User.class);
		return q.getResultList();
	}

}
