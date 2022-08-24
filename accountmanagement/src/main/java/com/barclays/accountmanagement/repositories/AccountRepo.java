package com.barclays.accountmanagement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.accountmanagement.entity.Account;

/**
 * 
 * @author Nishad
 *
 */
public interface AccountRepo extends JpaRepository<Account, Long>{

}
