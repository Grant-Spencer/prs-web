package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prs.business.LineItem;
import com.prs.business.Product;
import com.prs.business.Request;
import com.prs.db.LineItemRepo;
import com.prs.db.RequestRepo;

@CrossOrigin
@RestController
@RequestMapping("/lineItems")
public class LineItemController {
	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * Insert 4) PUT - Update 5) DELETE - delete
	 */

	@Autowired
	private LineItemRepo lineItemRepo;
	
	@Autowired
	private RequestRepo requestRepo;

	@GetMapping("/")
	public List<LineItem> getAll() {
		return lineItemRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<LineItem> getById(@PathVariable int id) {
		return lineItemRepo.findById(id);
	}

	// Add alineItem
	@PostMapping("/")
	public LineItem addLineItem(@RequestBody LineItem u) {
		u = lineItemRepo.save(u);
		recalculateTotal(u);
		return u;
	}

	// Update alineItem
	@PutMapping("/")
	public LineItem updateLineItem(@RequestBody LineItem u) {
		u = lineItemRepo.save(u);
		return u;
	}

	// Delete alineItem
	@DeleteMapping("/{id}")
	public LineItem deleteLineItem(@PathVariable int id) {
		// Optional type will wrap alineItem
		Optional<LineItem> u = lineItemRepo.findById(id);
		// isPresent() will return true if a lineItem was found
		if (u.isPresent()) {
			lineItemRepo.deleteById(id);
		} else {
			System.out.println("Error -lineItem not found for id " + id);
		}
		return u.get();

	}
	@GetMapping("/lines-for-pr/{id}")
	public List<LineItem> getLineItembyPr(@PathVariable int id) {
		return lineItemRepo.findByRequestId(id);
	}
	
	// loop and total new sum
		public void recalculateTotal(LineItem u) {	
			List<LineItem> lineItems = lineItemRepo.findByRequestId(u.getRequest().getId());
			
			double total = 0.0;
			for(LineItem lineItem : lineItems) {
				Product p = lineItem.getProduct();
				total += (p.getPrice() * lineItem.getQuantity());
			}
			
			Request request = u.getRequest();
			request.setTotal(total);
			requestRepo.save(request);
}
}
