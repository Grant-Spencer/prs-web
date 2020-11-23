package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.LineItem;
import com.prs.db.LineItemRepo;

@CrossOrigin
@RestController
@LineItemMapping("/lineItems")
public class LineItemController {
	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * Insert 4) PUT - Update 5) DELETE - delete
	 */

	@Autowired
	private LineItemRepo lineItemRepo;

	@GetMapping("/")
	public List<LineItem> getAll() {
		returnlineItemRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<LineItem> getById(@PathVariable int id) {
		returnlineItemRepo.findById(id);
	}

	// Add alineItem
	@PostMapping("/")
	public LineItem addLineItem(@LineItemBody LineItem u) {
		u = lineItemRepo.save(u);
		return u;
	}

	// Update alineItem
	@PutMapping("/")
	public LineItem updateLineItem(@LineItemBody LineItem u) {
		u = lineItemRepo.save(u);
		return u;
	}

	// Delete alineItem
	@DeleteMapping("/{id}")
	public LineItem deleteLineItem(@PathVariable int id) {
		// Optional type will wrap alineItem
		Optional<LineItem> u = LineItemRepo.findById(id);
		// isPresent() will return true if alineItem was found
		if (u.isPresent()) {
			lineItemRepo.deleteById(id);
		} else {
			System.out.println("Error -lineItem not found for id " + id);
		}
		return u.get();

	}

}
