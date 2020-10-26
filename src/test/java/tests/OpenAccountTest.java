package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AccountPage;
import pages.BankingMainPage;
import pages.OpenAccountPage;

public class OpenAccountTest extends BaseTest{
	
	public final String CUSTOMER_NAME = "Harry Potter";
	public final String CURRENCY = "Dollar";
	public final String ALERT_SUCCESS_MESSAGE_TXT = "Account created successfully with account Number";
	
	@Test
	public void openAccountTest() {
		new BankingMainPage()
			.clickOnBankManagerLoginButton()
			.clickOnOpenAccountButton()
			.selectCustomer(CUSTOMER_NAME)
			.selectCurrency(CURRENCY)
			.clickOnProcessButton();
		
		String alertSuccessMessage = new OpenAccountPage().getAlertSuccessMessage();
		Assert.assertTrue(alertSuccessMessage.contains(ALERT_SUCCESS_MESSAGE_TXT));
		String accountNumber = alertSuccessMessage.substring(50, 54);

		new OpenAccountPage()
			.clickOnHomeButton()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton()
			.selectAccountNumberOnCombo(accountNumber);;

		Assert.assertEquals(accountNumber, new AccountPage().getAccountNumber());
	}
}
