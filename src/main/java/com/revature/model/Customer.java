package com.revature.model;

public class Customer {

	private int customerId;
	private String lastname;
	private String firstname;
	private String customerusername;
	private String customerpassword;
		
	public Customer(int id, String lastname, String firstname, String customerusername, String customerpassword)  { 
		super();
		this.customerId = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.customerusername = customerusername;
		this.customerpassword = customerpassword;
		
	}

	// generated by Source Menu - Getters and Setters
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int id) {
		this.customerId = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getCustomerusername() {
		return customerusername;
	}

	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}

	public String getCustomerpassword() {
		return customerpassword;
	}

	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}

	public Customer() {
		
	}

	// generated by Source Menu - toString
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", lastname=" + lastname + ", firstname=" + firstname
				+ ", customerusername=" + customerusername + ", customerpassword=" + customerpassword + "]";
	}
	
	
//class closed	
}
