package com.revature.Mimic;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.exception.NegativeBalanceException;
import com.revature.exception.NegativeDepositException;
import com.revature.model.Account;
import com.revature.service.BalanceManipulation;

public class BalanceManipulationTest {

	
	private static Account fbal;
	private static Account fbal0;
	
	@BeforeClass
	public static void setup() {
		
		fbal = new Account(7, "test", "test2", 1000);
		fbal0 = new Account(8, "test3", "test4", 0);
	}
	
	@Test
	public void withdrawTestOfPositiveAmount () {
		Assert.assertEquals(BalanceManipulation.fundWithdraw(fbal, 500), true);
	}
	
	@Test (expected = NegativeBalanceException.class)
	public void withdrawTestOfNegativeAmount () {
		BalanceManipulation.fundWithdraw(fbal0, 555);
	}
	
	@Test
	public void withdrawTestOfFalsePositiveAmount () {
		Assert.assertEquals(BalanceManipulation.fundWithdraw(fbal, 2500), false);
	}
	
	@Test
	public void depositTestOfPositiveAmount () {
		BalanceManipulation.fundDeposit(fbal, 5000);
	}
	
	@Test
	public void depositTestOfNoAmount () {
		BalanceManipulation.fundDeposit(fbal0, 50);
	}
	
	@Test(expected = NegativeDepositException.class)
	public void depositTestOfNegativeAmount () {
		BalanceManipulation.fundDeposit(fbal, -3500);
	}
	
	
	@AfterClass
	public static void teardown() {
		fbal = null;
	}
	
	
	
//class closed
}
