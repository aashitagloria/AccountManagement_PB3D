package com.barclays.accountmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.accountmanagement.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
