package com.barclays.accountmanagement.services;

import org.springframework.http.ResponseEntity;

import com.barclays.accountmanagement.entity.User;


public interface UserLoginService {

	public User createNewUserCredentials();
	public ResponseEntity<Object> verifyUserCredential(String userId, String password, int roleId);
	public ResponseEntity<Object> updateUserCredential(String userId, String password);

}
