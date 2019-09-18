/** Project 0 : Banking App Project @author Efrain Vila
 * 
 * JavaSpring Banking Application
 * ==============================
 * 
 * Package and Class Listing 
 * -------------------------
 * 	
 * src/main/java
 * -------------
 * 	com.revature
 * 		Main.java						- This file to run JavaSpring Banking Application.
 * 
 * 	com.revature.controller
 * 		UserMenu.java					- The main User Menu class for logging in.
 * 		SubMenu.java					- The Sub Menu to access account information.
 * 	
 * 	com.revature.exception
 * 		NegativeBalanceException.java	- An exception to handle negative balance request upon withdrawal.
 * 		NegativeDepositException.java	- An exception to handle a negative deposit amount.
 * 
 * 	com.revature.model
 * 		Account.java					- Objects based on the Account Table.
 * 		Customer.java					- Objects based on the Customer Table.
 * 
 * 	com.revature.repository
 * 		JavaSpringDAO.java				- Data Access Objects, retrieves and stores data on objects.
 * 		JavaSpringJDBC.java				- Java Data Base Connector to gather data from the JavaSpring Database.
 * 
 * 	com.revature.service
 * 		BalanceManipulator.java			- The class which holds both withdraw and deposit methods.
 * 
 * 	com.revature.tools
 * 		ConnectionUtil.java				- The encapsulation of logic needed to connect to the database.
 * 		StreamCloser.java				- The class to close the connection to the database to prevent memory leaks.
 * 
 * src/test.java
 * 	com.revature.Mimic
 * 		BalanceManipulationTest.java	- JUnit Unit Testing based on methods in BalanceManipulation.java file.
 * 		DBTableTest.java				- Checking the connection and response from JavaSpring Database.
 * 		JavaSpringDaoMimic.java			- Mocking the JavaSpringDao.java file. (future implementation)
 * 
 * SQL script
 * 	project 0 sql script.sql			- The SQL script to create and populate both the Customer and Account Tables with values and several queries that were used in JavaSpringJDBC.java file.
 * 
 * 
 * 
 */

package com.revature;

import com.revature.controller.UserMenu;

public class Main {

	public static void main(String[] args) {
		
		
		//method to begin functionality
		UserMenu.userMenu();
		
	}

	
//class closed
}
