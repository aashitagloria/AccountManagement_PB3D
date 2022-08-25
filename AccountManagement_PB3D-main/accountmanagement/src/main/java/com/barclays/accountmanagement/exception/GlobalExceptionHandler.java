package com.barclays.accountmanagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.barclays.accountmanagement.utility.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	  @ExceptionHandler(value = InsufficientBalanceException.class)
	   public ResponseEntity<Object> handleInsufficientBalanceexception(InsufficientBalanceException exception,WebRequest request) {
		  ErrorDetails errorDetails=new ErrorDetails(new Date(),"Cannot make the transaction ! Insufficient balance !",request.getDescription(false));
	      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	   }
	  
	  @ExceptionHandler(value = AccountsNotFoundException.class)
	   public ResponseEntity<Object> handleCustomerNotFoundexception(AccountsNotFoundException exception,WebRequest request) {
		  ErrorDetails errorDetails=new ErrorDetails(new Date(),"Accounts Not Found With Given Customer_Id!",request.getDescription(false));
	      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	   }
	  @ExceptionHandler(value = MaxWithdrawalLimitExceededException.class)
	   public ResponseEntity<Object> handleMaxWithdrawLimitexception(MaxWithdrawalLimitExceededException exception,WebRequest request) {
		  ErrorDetails errorDetails=new ErrorDetails(new Date(),"Transactionf failed! Maximum withdrawal limit ($10000) for 24 hours exceeded. ",request.getDescription(false));
	      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	   }
		@ExceptionHandler(Exception.class)
		public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
			ErrorDetails errorDetails = 
					new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}


}
