package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.Vendor;
import com.prs.db.VendorRepo;

@CrossOrigin
@RestController
@RequestMapping("/vendors")
public class VendorController {
	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * Insert 4) PUT - Update 5) DELETE - delete
	 */

	@Autowired
	private VendorRepo vendorRepo;

	@GetMapping("/")
	public List<Vendor> getAll() {
		return vendorRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Vendor> getById(@PathVariable int id) {
		return vendorRepo.findById(id);
	}

	// Add a vendor
	@PostMapping("/")
	public Vendor addVendor(@RequestBody Vendor u) {
		u = vendorRepo.save(u);
		return u;
	}

	// Update a vendor
	@PutMapping("/")
	public Vendor updateVendor(@RequestBody Vendor u) {
		u = vendorRepo.save(u);
		return u;
	}

	// Delete a vendor
	@DeleteMapping("/{id}")
	public Vendor deleteVendor(@PathVariable int id) {
		// Optional type will wrap a vendor
		Optional<Vendor> u = vendorRepo.findById(id);
		// isPresent() will return true if a vendor was found
		if (u.isPresent()) {
			vendorRepo.deleteById(id);
		} else {
			System.out.println("Error - vendor not found for id " + id);
		}
		return u.get();

	}

	
	}

