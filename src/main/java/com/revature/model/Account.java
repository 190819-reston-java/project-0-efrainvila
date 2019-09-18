package com.revature.model;

public class Account {

	private int accountid;
	private String accountnumber;
	private String accounttype;
	private double accountbalance;
	
	// generated by Source Menu - Constructor
	public Account(int accountid, String accountnumber, String accounttype, double accountbalance) {
		super();
		this.accountid = accountid;
		this.accountnumber = accountnumber;
		this.accounttype = accounttype;
		this.accountbalance = accountbalance;
	}
	
	// generated by Source Menu - Getters and Setters	
	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public double getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	
	// generated by Source Menu - toString
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountnumber=" + accountnumber + ", accounttype=" + accounttype
				+ ", accountbalance=" + accountbalance + "]";
	}
	
	
	
//class closed	
}
