package com.revature.controller;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.service.BalanceManipulation;

public class SubMenu extends UserMenu {
	
	 	// sub menu for account balance, withdraw and deposit for normal users
		public static void subMenu(Customer cun) throws NullPointerException {
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
						case "1": // get account Balance here
							System.out.println("Current Balance is "+ abalc.getAccountbalance() + " Coins"+ System.lineSeparator());
							subMenu(cun);
							
							break;
						
						case "2": // goes to service/balance manipulation
							System.out.println("How much will you like to withdraw?");
								double withdrawAmount = userinput.nextDouble();
								userinput.nextLine();
								BalanceManipulation.fundWithdraw(abalc, withdrawAmount);
								if(BalanceManipulation.fundWithdraw(abalc, withdrawAmount)) {
									System.out.println("Successfully withdrawn !" + System.lineSeparator());
														
								}else{
									System.out.println("Can not withdraw more than in balance");
								}
												
							subMenu(cun);
							
							break;
							
						case "3": // goes to service/balance manipulation 
							System.out.println("Please enter the Deposit Amount.");
								double depositAmount = userinput.nextDouble();
								userinput.nextLine();
								BalanceManipulation.fundDeposit(abalc, depositAmount);
								System.out.println("Successfully deposited !" + System.lineSeparator());
													
							subMenu(cun);
						
							break;
							
						case "5":
							System.out.println("Thank You, exiting System.");
							System.exit(0);
						
						break;
							
						default:
							System.out.println("Invalid Selection, Please Select Again.");
							subMenu(cun);
							break;
				}
					return;
		}
		
//class closed		
}
