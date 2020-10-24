package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import core.BaseTest;
import core.Web;
import pages.BankingPage;

public class AccountTest extends BaseTest{
	
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
	public void openAccountTest() throws InterruptedException {
		new BankingPage(driver)
			.clickOnBankManagerLoginButton()
			.clickOnOpenAccountButton()
			.selectCustomer("Harry Potter")
			.selectCurrency("Dollar")
			.clickOnProcessButton()
			.checkAlertSuccessMessage("Account created successfully with account Number")
			;
		Thread.sleep(2000);
	}
	
	
	
}
