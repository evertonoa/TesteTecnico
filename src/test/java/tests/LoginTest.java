package tests;

import org.junit.Test;

import core.BaseTest;
import pages.BankingPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginIntoTheAccountTest () throws InterruptedException {
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccount("Harry Potter")
			.clickOnLoginButton();
	}
	
	@Test
	public void LogoutFromTheAccountTest() {
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccount("Harry Potter")
			.clickOnLoginButton()
			.clickOnLogOutButton();
	}
}
