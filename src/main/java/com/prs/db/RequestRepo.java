package com.prs.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.business.Request;

public interface RequestRepo extends JpaRepository<Request, Integer> {
	
	Optional<Request> findByUserIdNotAndStatus(int id, String status);
	

}
