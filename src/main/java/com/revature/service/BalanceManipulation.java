package com.revature.service;

import com.revature.controller.SubMenu;
import com.revature.exception.NegativeBalanceException;
import com.revature.model.Account;
import com.revature.model.Customer;

	public class BalanceManipulation extends SubMenu{
	
		// need to find a way to bring account type for methods below
		
		
		// method to withdraw funds
		public static boolean fundWithdraw(Account abalc, int withdrawAmount) throws NegativeBalanceException {	// gather user input amount and subtracts from available_funds
		
			
		if(abalc.getAccountbalance() <= 0) {
			throw new NegativeBalanceException(); // custom exception here 
		} else {
			if (withdrawAmount > abalc.getAccountbalance()) {
				return false;
			} else {
				double newBal = abalc.getAccountbalance() - withdrawAmount; 
				//System.out.println(newBal);
			javaSpringDAO.updateAccount(abalc.getAccountnumber(), newBal);
				}
			}
		return true;
	}
	
		
		
		// method to deposit funds
		public static void fundDeposit(Account abalc, int depositAmount) {	// gather user input amount and add to avaiable_funds
			
			double newBal = abalc.getAccountbalance() + depositAmount; 
			javaSpringDAO.updateAccount(abalc.getAccountnumber(), newBal);
			
		}
		
	}
	//static Account abal = javaSpringDAO.getbalance(cun.getCustomerId());
	
	//	private static Customer cuna; // npE
	//BalanceManipulation(abalc);
				
	//	logic to try to call account/customer
	//	public static void setcun (Customer cun) {
	//		cuna = cun;
	//	}
	//	
	//	public static Customer retrievecun() {
	//		return cuna;
	//	}