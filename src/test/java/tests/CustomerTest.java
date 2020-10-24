package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import core.BaseTest;
import core.Web;
import pages.BankingPage;

public class CustomerTest extends BaseTest{

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
	public void addNewCustomerTest() throws InterruptedException {
		new BankingPage(driver)
			.clickOnBankManagerLoginButton()
			.clickOnAddCustomerButton()
			.typeFirstName("Jose")
			.typeLastName("Silva")
			.typePostCode("11111")
			.AddCustomer()
			.checkAlertSuccessMessage("Customer added successfully with customer")
			;
		Thread.sleep(2000);
	}
	
	@Test
	public void deleteCustomerTest() throws InterruptedException {
		new BankingPage(driver)
			.clickOnBankManagerLoginButton()
			.clickOnCustomerButton()
			.removeCustomer("Neville")
			;
		Thread.sleep(2000);
	}
}
