package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.Product;
import com.prs.db.ProductRepo;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * Insert 4) PUT - Update 5) DELETE - delete
	 */

	@Autowired
	private ProductRepo productRepo;

	@GetMapping("/")
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Product> getById(@PathVariable int id) {
		return productRepo.findById(id);
	}

	// Add a product
	@PostMapping("/")
	public Product addProduct(@RequestBody Product u) {
		u = productRepo.save(u);
		return u;
	}

	// Update a product
	@PutMapping("/")
	public Product updateProduct(@RequestBody Product u) {
		u = productRepo.save(u);
		return u;
	}

	// Delete a product
	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable int id) {
		// Optional type will wrap a product
		Optional<Product> u = productRepo.findById(id);
		// isPresent() will return true if a product was found
		if (u.isPresent()) {
			productRepo.deleteById(id);
		} else {
			System.out.println("Error - product not found for id " + id);
		}
		return u.get();

	}

	
	}

