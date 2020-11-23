package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.User;
import com.prs.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * Insert 4) PUT - Update 5) DELETE - delete
	 */

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/")
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable int id) {
		return userRepo.findById(id);
	}

	// Add a user
	@PostMapping("/")
	public User addUser(@RequestBody User u) {
		u = userRepo.save(u);
		return u;
	}

	// Update a user
	@PutMapping("/")
	public User updateUser(@RequestBody User u) {
		u = userRepo.save(u);
		return u;
	}

	// Delete a user
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable int id) {
		// Optional type will wrap a user
		Optional<User> u = userRepo.findById(id);
		// isPresent() will return true if a user was found
		if (u.isPresent()) {
			userRepo.deleteById(id);
		} else {
			System.out.println("Error - user not found for id " + id);
		}
		return u.get();

	}

	// Post Mapping - Get User by User name and Password
	@PostMapping("/login")
	public Optional<User> login(@RequestBody User u) {
		Optional<User> user = userRepo.findByUsernameAndPassword(u.getUsername(), u.getPassword());
		if (user.isPresent()) {
			return user;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}

	}
}
