package com.barclays.accountmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	public Long getCurrentBalance(@PathVariable long id) {
		
		Long currentBalance = transactionService.getCurrentBalance(id);
	    return currentBalance; 
	}
	
	/**
	 * performs withdraw transaction
	 * @param id
	 * @param amount
	 * @return
	 */
	@GetMapping("api/transaction/withdraw/{id}/{amount}")
	public Long updateCurrentBalance(@PathVariable long id, @PathVariable long amount) {
		
		Long currentBalance = transactionService.DeductMoney(id,amount);
	    return currentBalance;
	}
	

	/**
	 * performs deposit transaction
	 * @param depositID
	 * @param amount
	 * @return
	 */
	@PostMapping("api/transaction/deposit/{depositID}/{amount}")
	public String DepositMoney(@PathVariable long depositID,@PathVariable double amount)
	{
		return transactionService.Deposit(depositID,amount);
	}
	
	
	/**
	 * Transfer money from one user to another user
	 * @param transferData
	 * @return
	 */
	@PostMapping(value = "api/transaction/transfer")
	public String transferMoney(@RequestParam(value = "senderId") Integer SenderId,@RequestParam(value = "receiverId") Integer ReceiverId, 
			@RequestParam(value = "amount") Integer amount )
	{	
		return transactionService.Transfer(SenderId,amount,ReceiverId);
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
