package com.transaction.processor;

import javax.ejb.Local;

import com.entity.processor.Transaction;

@Local
public interface TransactionProcessor {
	public void processSuspisiousTransaction(Transaction tx);

}
