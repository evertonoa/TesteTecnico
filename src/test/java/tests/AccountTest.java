package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.BankingPage;
import pages.OpenAccountPage;

public class AccountTest extends BaseTest{
	
	@Test
	public void openAccountTest() {
		new BankingPage()
			.clickOnBankManagerLoginButton()
			.clickOnOpenAccountButton()
			.selectCustomer("Harry Potter")
			.selectCurrency("Dollar")
			.clickOnProcessButton()
			;
		String alertSuccessMessage = new OpenAccountPage().getAlertSuccessMessage();
		Assert.assertTrue(alertSuccessMessage.contains("Account created successfully with account Number"));
	}
	
	
	
}
