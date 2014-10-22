package com.transaction.processor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.entity.processor.Transaction;
import com.processor.dao.TransactionDAO;

@WebService(
		portName = "TPPort",
		serviceName = "TPService",
		targetNamespace = "http://susp.transaction.processor.com/wsdl",
		name = "TP"
		)

@Stateless
public class TransactionProcessorImpl implements TransactionProcessor{
	
	@EJB
	private TransactionDAO dao;
	

	@Override
	public void processSuspisiousTransaction(Transaction tx) {
		System.out.println("Processing Trancaktion:" + tx);
		
		Transaction persisted = dao.persistTransaction(tx);
		
		System.out.println("Saved Transaction" + persisted);
		
	}

}
