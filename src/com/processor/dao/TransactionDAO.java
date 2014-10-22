package com.processor.dao;

import java.util.List;

import javax.ejb.Local;

import com.entity.processor.Transaction;

@Local
public interface TransactionDAO {
	public Transaction persistTransaction(Transaction tx);

	public List<Transaction> retrieveTransactions();

}
