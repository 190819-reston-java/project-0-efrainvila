package com.revature.Mimic;

import java.sql.Connection;

import com.revature.repository.JavaSpringDAO;
import com.revature.repository.JavaSpringJDBC;
import com.revature.tools.ConnectionUtil;

public class DBTableTest {

	public static void main(String[] args) {
		ConnectionUtil.getConnection();
		
		JavaSpringDAO test1 = new JavaSpringJDBC();
		
		//System.out.println(test1.getCustomerUserName("AprilZ"));
		
		System.out.println(test1.getUserandPass("BertY", "2581"));
		
		System.out.println(test1.getbalance(6));
		
		

	}

}
