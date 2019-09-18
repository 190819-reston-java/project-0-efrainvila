package com.revature.service;

import com.revature.controller.SubMenu;
import com.revature.exception.NegativeBalanceException;
import com.revature.exception.NegativeDepositException;
import com.revature.model.Account;

	public class BalanceManipulation extends SubMenu{
	
		// method to withdraw funds
		public static boolean fundWithdraw(Account abalc, double withdrawAmount) throws NegativeBalanceException {	
				
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
		public static void fundDeposit(Account abalc, double depositAmount) throws NegativeDepositException {	
			if( depositAmount < 0) {
				throw new NegativeDepositException();
			}else {
			double newBal = abalc.getAccountbalance() + depositAmount; 
			javaSpringDAO.updateAccount(abalc.getAccountnumber(), newBal);
		}
	}
	
		
//class closed		
}
	