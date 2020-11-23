package com.prs.business;

public class LineItem {

	private int id;
	private int requestId;
	private int productID;
	private int quantity;
	
	public LineItem() {
		super();
	}

	public LineItem(int id, int requestId, int productID, int quantity) {
		super();
		this.id = id;
		this.requestId = requestId;
		this.productID = productID;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
