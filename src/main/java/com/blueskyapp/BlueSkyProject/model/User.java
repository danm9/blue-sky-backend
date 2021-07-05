package com.blueskyapp.BlueSkyProject.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private int accountNumber;
	private String accountType;
	
    public User() {
    }
    
	public User(int id, String email, String firstName, String lastName, String password, int accountNumber, String accountType) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public String getEmail() {
		return email;
	}
        
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
