package com.transaction.processor;

import javax.ejb.Local;
import javax.jws.WebService;

import com.entity.processor.Transaction;

@WebService(
		endpointInterface = "com.transaction.processor.TransactionProcessor",
		portName = "TPPort",
		serviceName = "TPService",
		targetNamespace = "http://susp.transaction.processor.com/wsdl",
		name = "TP"
		)

@Local
public interface TransactionProcessor {
	public void processSuspisiousTransaction(Transaction tx);

}
