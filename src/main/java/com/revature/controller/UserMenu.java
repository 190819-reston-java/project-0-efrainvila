/* include scanner, sysout statements and switches here
*
*/

package com.revature.controller;

import java.util.Scanner;

import com.revature.model.Customer;
import com.revature.repository.JavaSpringDAO;
import com.revature.repository.JavaSpringJDBC;
import com.revature.service.BalanceManipulation;
import org.apache.log4j.Logger;


public class UserMenu {
	
	public static Logger logger = Logger.getLogger(UserMenu.class);
	protected static Scanner userinput = new Scanner(System.in); // can be used every method inside the class as static
	protected BalanceManipulation balancemanipulator = new BalanceManipulation();
	protected static JavaSpringDAO javaSpringDAO = new JavaSpringJDBC();
	
	private static int invalidSelectorCounter = 0;
	private static int invalidLoginCounter = 0;
	
	public static void userMenu() {
		
		// Main User Menu
		logger.debug("System Start");
		System.out.println("Welcome to the JavaSpring QuickTeller Banking System." + System.lineSeparator());
		System.out.println("Please make a selection from the options below.");
		System.out.println("===============================================" + System.lineSeparator());
		System.out.println("1" + " --> " + "Current Customer" + System.lineSeparator());
		System.out.println("3" + " --> " + "Help" + System.lineSeparator());
		System.out.println("5" + " --> " + "Exit System");
		
		String userSelection = userinput.nextLine();
		logger.info("Selection : " + userSelection);
		
		switch(userSelection) {
			case "1":
				currentcustomer(); // method is below
				break;			
	
			case "3":
				helpusermenu(); //method is below
				break;
				
			case "5":
				System.out.println("Thank You for using our App. Exiting System."); //system exits
				System.exit(0);
				
			default:
				System.out.println("Invalid Selection, Please Select Again."); // tries again
				invalidSelectorCounter++;
				logger.info(invalidSelectorCounter + " attempts made." + System.lineSeparator());
				logger.debug("After " + invalidSelectorCounter + " reaches 3 attempts, program will exit." + System.lineSeparator());
				
					if (invalidSelectorCounter >= 3) {
						logger.fatal("Failed Selection after 3 times. Forcing System Exit.");
						System.exit(1);
					}
				
				break;
		}
		userMenu();
	}
		
	// method for login check	
	private static void currentcustomer() {
		System.out.println("Please Enter Your User Name");
		
		// receives user name input from user
		String userName = userinput.nextLine();
		
		// receives pass word input from user		
		System.out.println("Please Enter Your Password");
		String userPassword = userinput.nextLine();
		
		// Customer object
			Customer cun = javaSpringDAO.getUserandPass(userName, userPassword);
				//System.out.println(cun);
		//login logic  .. should be in another method
			if (cun != null) {
				validlogin(cun);
			} else {
				invalidlogin();
			}throw new NullPointerException();
		
		// Account object
		//Account abalc = javaSpringDAO.getbalance(cun.getCustomerId()); <--
				//System.out.println(abalc);
			
//		old login logic
//			
//		JavaSpringDAO javaSpringDAO = new JavaSpringJDBC();
//		if (javaSpringDAO.getUserandPass(userName, userPassword) != null) {
//			System.out.println("User found sleeping");
//		}else {
//			System.out.println("nope!");
//		}
			
//			if (operationsCenter.logincheck(userName, userPassword)) {
//				validlogin(cun);
//			} else {
//					invalidlogin();
//				};
	}

	
	// method for valid login to sub menu
	public static void validlogin(Customer cun) {
		
		System.out.println("Welcome " + cun.getFirstname() +" "+ cun.getLastname() + System.lineSeparator());
		SubMenu.subMenu(cun);
	}

	// method for invalid login will return to main menu
	public static void invalidlogin() {
		System.out.println(" That is not a registered Customer User Name or Password."+ System.lineSeparator());
		
		invalidLoginCounter++;
		logger.info(invalidLoginCounter + " failed login attempts.");
		logger.debug("After 5 Login attempts, system will exit.");
			if(invalidLoginCounter >= 5) {
				logger.fatal("Failed 5 Login Attempts. Forcing System Exit.");
				System.exit(1);
			}else {	
				logger.info(" ... Returning to the Main Menu" + System.lineSeparator());
				userMenu();
			}
	}

	// just help text
	private static void helpusermenu() {
		System.out.println("For help, please visit with one of our JavaSpring Banking Representatives.");
		
	}

	
//class closed	
}
