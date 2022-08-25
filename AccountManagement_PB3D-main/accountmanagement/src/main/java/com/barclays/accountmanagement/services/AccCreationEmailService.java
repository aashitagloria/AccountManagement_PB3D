package com.barclays.accountmanagement.services;

public interface AccCreationEmailService {
	
	public void sendEmail(String emailUserName, String emailPassword, String customerEmail);

}
