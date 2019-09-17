package com.revature.repository;

import com.revature.model.Account;
import com.revature.model.Customer;

/**
 * DAO	: Data Access Objects 
 * 		- Retrieves and stores data about objects
 */

public interface JavaSpringDAO {

	Customer getUserandPass(String customerusername, String customerpassword);
	
	Account getbalance(int id);
	
	boolean updateAccount(String accountnumber, double Accountbalance);
	
	
	//	Customer getCustomerUserName(String customerusername);
	
	//	String getCustomerPassWord(String customerpassword);
	
	//	double getAccountBalance(double accountbalance);
	
	//	String getAccountNumber(String accountnumber);
	
	//	String getCustomerFirstName(String firstname);
	
	//	String getCustomerLastName(String lastname);

	//	String getAccountType(String accounttype);

	
	
	
	
	
}
