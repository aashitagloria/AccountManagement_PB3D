package com.barclays.accountmanagement.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.accountmanagement.entity.Transaction;
import com.barclays.accountmanagement.services.TransactionService;


/**
 * 
 * @author Jaypal
 *
 */
@RestController
public class TransactionController {
	
	/**
	 * transactionService (Contains details related to transaction table)
	 */
	@Autowired
	TransactionService transactionService;

	/**
	 * returns current balance of a particular customer
	 * @param id
	 * @return
	 */
	@RequestMapping("api/transaction/getCurrentBalance/{id}")
	public  ResponseEntity<Object> getCurrentBalance(@PathVariable long id) {
		HashMap<String, Long> resultSet = new HashMap<String, Long>();
		Long currentBalance = transactionService.getCurrentBalance(id);
		resultSet.put("Current Balance", currentBalance);
		return new ResponseEntity<>(resultSet, HttpStatus.OK);
	    //return currentBalance; 
	}
	
	/**
	 * performs withdraw transaction
	 * @param id
	 * @param amount
	 * @return
	 */
	@GetMapping("api/transaction/withdraw/{id}/{amount}")
	public ResponseEntity<Object> updateCurrentBalance(@PathVariable long id, @PathVariable long amount) {
		
		Long currentBalance = transactionService.DeductMoney(id,amount);
		HashMap<String, Long> resultSet = new HashMap<String, Long>();
		
		resultSet.put("Current Balance", currentBalance);
		return new ResponseEntity<>(resultSet, HttpStatus.OK);
	   // return currentBalance;
	}
	

	/**
	 * performs deposit transaction
	 * @param depositID
	 * @param amount
	 * @return
	 */
	@PostMapping("api/transaction/deposit/{depositID}/{amount}")
	public ResponseEntity<Object> DepositMoney(@PathVariable long depositID,@PathVariable double amount)
	{
		
        HashMap<String, String> resultSet = new HashMap<String, String>();
		
		resultSet.put("Current Balance",  transactionService.Deposit(depositID,amount));
		return new ResponseEntity<>(resultSet, HttpStatus.OK);
	}
	
	
	/**
	 * Transfer money from one user to another user
	 * @param transferData
	 * @return
	 */
	@PostMapping(value = "api/transaction/transfer")
	public ResponseEntity<Object> transferMoney(@RequestParam(value = "senderId") Integer SenderId,@RequestParam(value = "receiverId") Integer ReceiverId, 
			@RequestParam(value = "amount") Integer amount )
	{	
		  HashMap<String, String> resultSet = new HashMap<String, String>();
			
			resultSet.put("Current Balance",  transactionService.Transfer(SenderId,amount,ReceiverId));
			return new ResponseEntity<>(resultSet, HttpStatus.OK);
		
	}
	
	/**
	 * Gets the recent transaction history
	 * @param accountNum
	 * @return
	 */
	@GetMapping("api/transaction/recent/{accountNum}")
	public List<Transaction> checkHistory(@PathVariable long accountNum)
	{
		return transactionService.checkHistory(accountNum);
	}
	

	
	
}
