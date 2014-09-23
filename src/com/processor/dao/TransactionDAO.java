package com.processor.dao;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TransactionDAO<T> {
	public T persistTransaction(T tx);

	public List<T> retrieveTransactions();

}
