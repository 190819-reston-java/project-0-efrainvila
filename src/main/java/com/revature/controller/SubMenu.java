package com.revature.controller;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.service.BalanceManipulation;

public class SubMenu extends UserMenu {
	
	 	// sub menu for account balance, withdraw and deposit for normal users
		public static void subMenu(Customer cun) {
			Customer customerinfo = cun;
			
			Account abalc = javaSpringDAO.getbalance(customerinfo.getCustomerId());
			
			
			System.out.println("What would you like to do?");
			System.out.println("==========================");
			System.out.println("1" + " --> " + "View Current Balance");
			System.out.println("2" + " --> " + "Make a Withdraw");
			System.out.println("3" + " --> " + "Add a Deposit");
			System.out.println("5" + " --> " + "Exit System");
			
			String customerchoice = userinput.nextLine();
						
				switch(customerchoice) {
						case "1": // get account Balance  .. works!
							System.out.println("Current Balance is "+ abalc.getAccountbalance() + " Coins"+ System.lineSeparator());
							subMenu(cun);
							
							break;
						
						case "2": // goes to service .. working !
							System.out.println("How much will you like to withdraw?");
								int withdrawAmount = userinput.nextInt();
								userinput.nextLine();
								BalanceManipulation.fundWithdraw(abalc, withdrawAmount);
								if(BalanceManipulation.fundWithdraw(abalc, withdrawAmount)) {
									System.out.println("Successful !");
									// System.out.println("New Balance is : " + abalc.getAccountbalance() + " Coins"+ System.lineSeparator());
									
								}else{
									System.out.println("Can not withdraw more than in balance");
									// System.out.println("Current Balance is  :" + abalc.getAccountbalance() + " Coins"+ System.lineSeparator()); 
								}
								
							
							subMenu(cun);
							
							break;
							
						case "3": // goes to service .. working !!
							System.out.println("Please enter the Deposit Amount.");
								int depositAmount = userinput.nextInt();
								userinput.nextLine();
								BalanceManipulation.fundDeposit(abalc, depositAmount);
								System.out.println("Successful !");
								//System.out.println("New Balance is : " + abalc.getAccountbalance() + " Coins"+ System.lineSeparator());
							
							subMenu(cun);
						
							break;
							
						case "5":
							System.out.println("Thank You, exiting System.");
							System.exit(0);
						
						break;
							
						default:
							System.out.println("Invalid Selection, Please Select Again.");
							break;
				}
		
				return;
				
			}
		
		
		// method to display insufficient funds
		public static void insufficientFunds() {
			System.out.println("Insufficient Funds");
			
			
		}


}
