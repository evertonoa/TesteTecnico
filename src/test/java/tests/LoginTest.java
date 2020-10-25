package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AccountPage;
import pages.BankingCustomerPage;
import pages.BankingPage;

public class LoginTest extends BaseTest{
	
	public final String CUSTOMER_NAME = "Harry Potter";
	public final String CUSTOMER_URL = "http://www.way2automation.com/angularjs-protractor/banking/#/customer";
	
	@Test
	public void loginIntoTheAccountTest () {
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton();
		
		Assert.assertEquals(CUSTOMER_NAME, new AccountPage().getWelcomeAccountName()); 
	}
	
	@Test
	public void LogoutFromTheAccountTest() {
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton();
		
		Assert.assertEquals(CUSTOMER_NAME, new AccountPage().getWelcomeAccountName()); 
		
		new AccountPage()
			.clickOnLogOutButton();
		
		String currentUrl = new BankingCustomerPage().getPageUrl();
		Assert.assertEquals(currentUrl, CUSTOMER_URL);
	}
}
