package com.transaction.processor;

import javax.ejb.Stateless;
import javax.jws.WebService;

import com.entity.processor.Transaction;

@WebService(
		portName = "TPPort",
		serviceName = "TPService",
		targetNamespace = "http://susp.transaction.processor.com/wsdl",
		name = "TP"
		)

@Stateless
public class TransactionProcessorImpl implements TransactionProcessor{
	
	

	@Override
	public void processSuspisiousTransaction(Transaction tx) {
		System.out.println("Processing Trancaktion:" + tx);
		
	}

}
