package com.prs.business;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
public class Request {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;
	private String description;
	private String justification;
	private int dateNeeded;
	private String deliveryMode;
	private String status;
	private double total;
	private int submittedDate;
	private String reasonForRejection;
	
	public Request() {
		super();
	}

	public Request(int id, int userId, String description, String justification, int dateNeeded, String deliveryMode,
			String status, double total, int submittedDate, String reasonForRejection) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.justification = justification;
		this.dateNeeded = dateNeeded;
		this.deliveryMode = deliveryMode;
		this.status = status;
		this.total = total;
		this.submittedDate = submittedDate;
		this.reasonForRejection = reasonForRejection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public int getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(int dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(int submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getReasonForRejection() {
		return reasonForRejection;
	}

	public void setReasonForRejection(String reasonForRejection) {
		this.reasonForRejection = reasonForRejection;
	}

	public void setSubmittedDate(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
