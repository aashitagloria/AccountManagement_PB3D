package com.barclays.accountmanagement.services;

import org.springframework.http.ResponseEntity;

import com.barclays.accountmanagement.entity.Account;
import com.barclays.accountmanagement.entity.Customer;

/**
 * 
 * @author Tanvi
 *
 */
public interface ManagerService {
	Customer createNewCustomer(Customer customer) throws Exception;
	Account createNewAccount(int customerId) throws Exception;
	public ResponseEntity<Object> verifyPanCard(String panCardNumber);
}
