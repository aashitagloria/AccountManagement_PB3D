package com.barclays.accountmanagement;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



import com.barclays.accountmanagement.controller.TransactionController;
import com.barclays.accountmanagement.entity.Transaction;
import com.barclays.accountmanagement.serviceimpls.TransactionServiceImpl;


@SpringBootTest
public class TransactionControllerTest {
	private MockMvc mockMvc;
	@Mock
	TransactionServiceImpl service;

//	@Mock
//	CustomerService service1;

	@InjectMocks
	TransactionController controller;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
   @Test
	public void getCurrentBalanceTest() throws Exception
	{
		Long currentBalance = (long) 8999;
		
		
		doReturn(currentBalance).when(service).getCurrentBalance(100002);
	

		mockMvc.perform(MockMvcRequestBuilders.get("/api/transaction/getCurrentBalance/{id}", 100002)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		
	}
   @Test
	public void depositMoneyTest() throws Exception
	{
	
		mockMvc.perform(MockMvcRequestBuilders.post("/api/transaction/deposit/{depositID}/{amount}", 100002,540)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		
	}
   @Test
	public void withdrawlMoneyTest() throws Exception
	{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/transaction/withdraw/{id}/{amount}", 100002,540)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		
	}
   @Test
	public void getTransactionsTest() throws Exception
	{
	   List<Transaction>list=new ArrayList<>();
	   Transaction t1=new Transaction();
	   t1.setTransactionAmount(400.0);
	   t1.setSubType("Deposit");
	   t1.setTransactionType("Credit");
	   t1.setTransactionId(20);
	   t1.setTransactionRefNum("T21-22");
	   list.add(t1);
	   doReturn(list).when(service).checkHistory(100002);
	   
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/transaction/recent/{accountNum}", 100002)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		
	}

}
