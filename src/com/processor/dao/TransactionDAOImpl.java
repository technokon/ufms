package com.processor.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entity.processor.Transaction;

@Stateless
public class TransactionDAOImpl implements TransactionDAO<Transaction>{
	 
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Transaction persistTransaction(Transaction tx) {
		em.persist(tx);
		return tx;
		
	}
	
	@Override
	public List<Transaction> retrieveTransactions() {
		TypedQuery<Transaction> q = em.createQuery("from Transaction", Transaction.class);
		return q.getResultList();
	}

}
