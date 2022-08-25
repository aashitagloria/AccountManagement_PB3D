package com.barclays.accountmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.accountmanagement.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findById(int id);

}
