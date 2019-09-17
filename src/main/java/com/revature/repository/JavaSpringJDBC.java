package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.tools.ConnectionUtil;
import com.revature.tools.StreamCloser;

public class JavaSpringJDBC implements JavaSpringDAO {


	// methods for pulling User name and password from Customer Table
	@Override
	public Customer getUserandPass(String customerusername, String customerpassword) {
		Customer remoteCustomer = null;
					
			try (Connection conn = ConnectionUtil.getConnection()) {
				String query = "SELECT * FROM customer WHERE username = ? and pwd = ?;";
				try (PreparedStatement stmt = conn.prepareStatement(query)) {
					stmt.setString(1, customerusername);
					stmt.setString(2, customerpassword);
					if (stmt.execute()) {
						try (ResultSet resultSet = stmt.getResultSet()) {
							if (resultSet.next()) { 
								
								remoteCustomer = createCustomerFromRS(resultSet);
								
							}
						}
						
					}
				} 
			} catch (SQLException e) {
					e.printStackTrace();
		}
		
		return remoteCustomer;
	}
	
	
// method to pull account balance from Account Table
		@Override
		public Account getbalance(int id) {
			Account remoteAccount = null;
							
				try (Connection conn = ConnectionUtil.getConnection()) {
					String query = "SELECT * FROM account WHERE accountid = ?;";
					try (PreparedStatement stmt = conn.prepareStatement(query)) {
						stmt.setInt(1, id);
						if (stmt.execute()) {
							try (ResultSet resultSet = stmt.getResultSet()) {
								if (resultSet.next()) { 
									remoteAccount = createAccountFromRS(resultSet);
									
								}
							}
							
						}
					} 
				} catch (SQLException e) {
						e.printStackTrace();
			}
			
			return remoteAccount;
		}

		
// UPDATE query for Account Table on javaspring database = accountbalance , accountnumber
		@Override
			public boolean updateAccount(String accountnumber, double Accountbalance) {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			final String query = "UPDATE account SET accountbalance = ? WHERE accountnumber =?;";

			try {
				conn = ConnectionUtil.getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setDouble(1, Accountbalance);
				stmt.setString(2, accountnumber);
				
				stmt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				} finally {
					StreamCloser.close(stmt);
					StreamCloser.close(conn);
			} return true;
		}

// resultSets for Customer Table
		private Customer createCustomerFromRS(ResultSet resultSet) throws SQLException {
			return new Customer(
					resultSet.getInt("customerid"),
					resultSet.getString("lastname"),
					resultSet.getString("firstname"),
					resultSet.getString("username"),
					resultSet.getString("pwd")
					);
		}
		
// resultSets for Account Table
		private Account createAccountFromRS(ResultSet resultSet) throws SQLException {
				return new Account (
						resultSet.getInt("accountid"),
						resultSet.getString("accountnumber"),
						resultSet.getString("accounttype"),
						resultSet.getDouble("accountbalance"));
			}


// old logic : SELECT statement for Account Table - pulls account balance from javaspring.account table
//// 
//			@Override
//			public double getAccountBalance(double accountbalance) {//
//				Account remoteAccount = null; //changed from Customer class
//				double remoteAccountBalance = 0;
//						
//						try (Connection conn = ConnectionUtil.getConnection()) {
//							String query = "SELECT * FROM customer FULL JOIN account ON customerid = accountid WHERE username = ?; \"";
//							try (PreparedStatement stmt = conn.prepareStatement(query)) {
//								stmt.setDouble(1, accountbalance);
//								if (stmt.execute()) {
//									try (ResultSet resultSet = stmt.getResultSet()) {
//										if (resultSet.next()) { 
//											remoteAccount = createAccountFromRS(resultSet); // changed from createCustomerFromRS()
//											remoteAccountBalance = remoteAccount.getAccountbalance(); // removed getAccountlink()
//										}
//									}
//									
//								}
//							} 
//						} catch (SQLException e) {
//								e.printStackTrace();
//					}
//				return remoteAccountBalance;
//			}		
		

//	old logic for pulling customer name	
//	
//	// pulls user name from javaspring.customer table
//	@Override
//	public Customer getCustomerUserName(String customerusername) {
//		Customer remoteCustomer = null;
//		String remoteUsername = null;
//			
//			try (Connection conn = ConnectionUtil.getConnection()) {
//				String query = "SELECT * FROM customer WHERE username = ?;";
//				try (PreparedStatement stmt = conn.prepareStatement(query)) {
//					stmt.setString(1, customerusername);
//					if (stmt.execute()) {
//						try (ResultSet resultSet = stmt.getResultSet()) {
//							if (resultSet.next()) { 
//								remoteCustomer = createCustomerFromRS(resultSet);
//								remoteUsername = remoteCustomer.getCustomerusername();
//							}
//						}
//						
//					}
//				} 
//			} catch (SQLException e) {
//					e.printStackTrace();
//		}
//		
//		return remoteCustomer;
//	}
//
//
//

//  old logic for pulling pass word from javaspring.customer table
//  
//	@Override
//	public String getCustomerPassWord(String customerpassword) {
//		Customer remoteCustomer = null;
//		String remotePassword = null;
//			
//			try (Connection conn = ConnectionUtil.getConnection()) {
//				String query = "SELECT * FROM customer WHERE pwd = ?;";
//				try (PreparedStatement stmt = conn.prepareStatement(query)) {
//					stmt.setString(1, customerpassword);
//					if (stmt.execute()) {
//						try (ResultSet resultSet = stmt.getResultSet()) {
//							if (resultSet.next()) { 
//								remoteCustomer = createCustomerFromRS(resultSet);
//								remotePassword = remoteCustomer.getCustomerpassword();
//							}
//						}
//						
//					}
//				} 
//			} catch (SQLException e) {
//					e.printStackTrace();
//		}
//		
//		return remotePassword;
//	}

// old logic for first and last name pulls from db
//	
// pulls first name from javaspring.customer table
//	@Override
//	public Customer getCustomerFirstName(String firstname) {
//		Customer remotefirstname = null;
//				
//				try (Connection conn = ConnectionUtil.getConnection()) {
//					String query = "SELECT firstname FROM customer WHERE firstname = ?; ";
//					try (PreparedStatement stmt = conn.prepareStatement(query)) {
//						stmt.setString(3, firstname);
//						if (stmt.execute()) {
//							try (ResultSet resultSet = stmt.getResultSet()) {
//								if (resultSet.next()) { 
//									remotefirstname = createCustomerFromRS(resultSet);
//								}
//							}
//							
//						}
//					} 
//				} catch (SQLException e) {
//						e.printStackTrace();
//			}
//			
//			return remotefirstname;
//	}
//

		
//	old logic for pulling last name from javaspring.customer table
//	@Override
//	public Customer getCustomerLastName(String lastname) {
//		Customer remotelastname = null;
//		
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String query = "SELECT lastname FROM customer WHERE lastname = ?; ";
//			try (PreparedStatement stmt = conn.prepareStatement(query)) {
//				stmt.setString(2, lastname);
//				if (stmt.execute()) {
//					try (ResultSet resultSet = stmt.getResultSet()) {
//						if (resultSet.next()) { 
//							remotelastname = createCustomerFromRS(resultSet);
//						}
//					}
//					
//				}
//			} 
//		} catch (SQLException e) {
//				e.printStackTrace();
//	}
//	
//	return remotelastname;
//	}
//

// old logic for pulling account type from db
//	
// pulls accounttype from javaspring.account table
//	@Override
//	public Account getAccountType(String accounttype) {
//		Account remoteaccounttype = null;
//		
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String query = "SELECT accounttype FROM customer INNER JOIN account ON customer.id = account.customerid WHERE username = ?; ";
//			try (PreparedStatement stmt = conn.prepareStatement(query)) {
//				stmt.setString(3, accounttype);
//				if (stmt.execute()) {
//					try (ResultSet resultSet = stmt.getResultSet()) {
//						if (resultSet.next()) { 
//							remoteaccounttype = createAccountFromRS(resultSet);
//						}
//					}
//					
//				}
//			} 
//		} catch (SQLException e) {
//				e.printStackTrace();
//	}
//	
//	return remoteaccounttype;
//	}
//
	
// old logic for pulling account number from account table
//		
//	// pulls account number from javaspring.account table
//	@Override
//	public String getAccountNumber(String accountnumber) {
//		Account remoteAccountN = null; // changed from Customer class
//		String remoteaccountnumber = null;
//				
//				try (Connection conn = ConnectionUtil.getConnection()) {
//					String query = "SELECT * FROM customer INNER JOIN account ON customerid = accountid WHERE username = ?; ";
//				try (PreparedStatement stmt = conn.prepareStatement(query)) {
//						stmt.setString(1, accountnumber);
//						if (stmt.execute()) {
//							try (ResultSet resultSet = stmt.getResultSet()) {
//								if (resultSet.next()) { 
//									remoteAccountN = createAccountFromRS(resultSet); // changed from createCustomerFromRS()
//									remoteaccountnumber = remoteAccountN.getAccountnumber(); // removed getAccountlink()
//								}
//							}
//							
//						}
//					} 
//				} catch (SQLException e) {
//						e.printStackTrace();
//	}
//	
//	return remoteaccountnumber;
//	}
	
// class closed
}





	

	
