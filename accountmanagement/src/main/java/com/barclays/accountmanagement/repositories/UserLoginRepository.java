package com.barclays.accountmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.accountmanagement.entity.User;


/**
 * interface provides the mechanism for storage, retrieval, search, update and 
 * delete operation
 * @author 
 *
 */

@Repository
public interface UserLoginRepository extends JpaRepository<User, Integer> {

	User findUserByUserIdAndPassword(String userId, String password);
	User findUserByUserIdAndRoleRoleId(String userId, int roleId);
	User findUserByUserId(String userId);
}
