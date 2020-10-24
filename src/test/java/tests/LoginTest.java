package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import core.Web;
import pages.BankingPage;

public class LoginTest {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = Web.createChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginIntoTheAccountTest () throws InterruptedException {
		new BankingPage(driver)
			.clickOnCustomerLoginButton()
			.selectAccount("Harry Potter")
			.clickOnLoginButton();
			;
		Thread.sleep(2000);
	}
	
	@Test
	public void LogoutFromTheAccountTest() throws InterruptedException {
		new BankingPage(driver)
			.clickOnCustomerLoginButton()
			.selectAccount("Harry Potter")
			.clickOnLoginButton()
			.clickOnLogOutButton()
			;
		;
		Thread.sleep(2000);
	}
}
