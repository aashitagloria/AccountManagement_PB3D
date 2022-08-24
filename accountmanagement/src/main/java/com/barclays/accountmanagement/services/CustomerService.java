package com.barclays.accountmanagement.services;

import java.util.HashMap;
import java.util.Set;

public interface CustomerService {

	Set<HashMap<String,String>> getAccountDetailsByCustomerId(int customerId);
}
