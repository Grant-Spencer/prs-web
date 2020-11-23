package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.Request;
import com.prs.db.RequestRepo;

@CrossOrigin
@RestController
@RequestMapping("/requests")
public class RequestController {
	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * Insert 4) PUT - Update 5) DELETE - delete
	 */

	@Autowired
	private RequestRepo requestRepo;

	@GetMapping("/")
	public List<Request> getAll() {
		return requestRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Request> getById(@PathVariable int id) {
		return requestRepo.findById(id);
	}

	// Add a request
	@PostMapping("/")
	public Request addRequest(@RequestBody Request u) {
		u = requestRepo.save(u);
		return u;
	}

	// Update a request
	@PutMapping("/")
	public Request updateRequest(@RequestBody Request u) {
		u = requestRepo.save(u);
		return u;
	}

	// Delete a request
	@DeleteMapping("/{id}")
	public Request deleteRequest(@PathVariable int id) {
		// Optional type will wrap a request
		Optional<Request> u = requestRepo.findById(id);
		// isPresent() will return true if a request was found
		if (u.isPresent()) {
			requestRepo.deleteById(id);
		} else {
			System.out.println("Error - request not found for id " + id);
		}
		return u.get();

	}

	
	}

