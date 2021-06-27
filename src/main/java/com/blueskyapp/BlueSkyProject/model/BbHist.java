package com.blueskyapp.BlueSkyProject.model;

import javax.persistence.*;

@Entity
@Table(name = "bb_hist")
public class BbHist {
	private int blueBucksId;
	private String email;
	private String transaction_type;
	private int amount;
	private String date;


	public BbHist() {
	}

	public BbHist(int blueBucksId, String email, String transaction_type, int amount, String date) {
		this.blueBucksId = blueBucksId;
		this.email = email;
		this.transaction_type = transaction_type;
		this.amount = amount;
		this.date = date;
	}

	/**
	 * @return the blueBucksId
	 */
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getBlueBucksId() {
		return blueBucksId;
	}

	/**
	 * @param blueBucksId the blueBucksId to set
	 */
	public void setBlueBucksId(int blueBucksId) {
		this.blueBucksId = blueBucksId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the transaction_type
	 */
	public String getTransaction_type() {
		return transaction_type;
	}

	/**
	 * @param transaction_type the transaction_type to set
	 */
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
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
	
}