package com.transaction.processor;

import javax.ejb.Stateless;

import com.entity.processor.Transaction;

@Stateless
public class TransactionProcessorImpl implements TransactionProcessor{
	
	

	@Override
	public void processSuspisiousTransaction(Transaction tx) {
		// Persist transaction to the DB.
		
	}

}
