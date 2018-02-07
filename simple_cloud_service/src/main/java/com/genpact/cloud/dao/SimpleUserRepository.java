package com.genpact.cloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genpact.cloud.model.SimpleUser;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, Long>{
	SimpleUser findByUsername(String username);
}
