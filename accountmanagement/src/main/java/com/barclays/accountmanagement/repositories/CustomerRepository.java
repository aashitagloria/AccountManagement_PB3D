package com.barclays.accountmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.accountmanagement.entity.Customer;


/**
 * interface provides the mechanism for storage, retrieval, search, update and 
 * delete operation
 * @author Suchitra
 *
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findCustomerByPanCard(String panCardNumber);

}
