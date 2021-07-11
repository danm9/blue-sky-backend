package com.blueskyapp.BlueSkyProject.model;

import javax.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoices {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceId;
	private int userId;
	private String date;
	private double amount;

	public Invoices() {
	}
	 
	public Invoices(int invoiceId, int userId, String date, double amount) {
		this.invoiceId = invoiceId;
		this.userId = userId;
		this.date = date;
		this.amount = amount;
	}
	/**
	 * @return the invoiceId
	 */
	public int getInvoiceId() {
		return invoiceId;
	}
	/**
	 * @param invoiceId the invoiceId to set
	 */
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
