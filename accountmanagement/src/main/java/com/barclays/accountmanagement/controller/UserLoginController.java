package com.barclays.accountmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.accountmanagement.constants.SystemConstants;
import com.barclays.accountmanagement.services.UserLoginService;

/**
 * UserLoginController contains all api endpoints for user functionalities.
 * @author Anshika
 */

@RestController
public class UserLoginController {

	@Autowired
	UserLoginService userLoginService;
	
	
	/**
	 * create a new user login for customer
	 * 
	 * @param userId
	 * @param password
	 * @param roleId
	 * @return Valid User or not
	 */
	@PostMapping(SystemConstants.VERIFY_USER_CREDENTIAL)
	public ResponseEntity<Object> verifyUserCredential(@RequestParam(required = true) String userId, @RequestParam(required = true) String password, @RequestParam (required = true)int roleId )
	{
		return userLoginService.verifyUserCredential(userId, password, roleId);
	}
	
	@PutMapping(SystemConstants.UPDATE_USER_CREDENTIALS)
	public ResponseEntity<Object> updateUserCredential(@RequestParam(required = true) String userId,@RequestParam(required = true) String password)
	{
		return userLoginService.updateUserCredential(userId, password);
	}
}
