package com.barclays.accountmanagement.services;

import java.util.List;

import com.barclays.accountmanagement.entity.Transaction;


public interface TransactionStatementService {
	
	 
	List<Transaction> findTransactionList(long accountNumber);
	List<Transaction> listAll(long accountNumber, String date);
	List<Transaction> findTransactionListDate(long accountNumber,String date);
	
	
}
