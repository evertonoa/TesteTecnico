package tests;

import org.junit.Test;

import core.BaseTest;
import pages.BankingPage;

public class AccountTest extends BaseTest{
	
	@Test
	public void openAccountTest() {
		new BankingPage()
			.clickOnBankManagerLoginButton()
			.clickOnOpenAccountButton()
			.selectCustomer("Harry Potter")
			.selectCurrency("Dollar")
			.clickOnProcessButton()
			.checkAlertSuccessMessage("Account created successfully with account Number");
	}
	
	
	
}
