package tests;

import org.junit.Test;

import core.BaseTest;
import pages.BankingPage;

public class CustomerTest extends BaseTest{

	@Test
	public void addNewCustomerTest() throws InterruptedException {
		new BankingPage()
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
		new BankingPage()
			.clickOnBankManagerLoginButton()
			.clickOnCustomerButton()
			.removeCustomer("Neville")
			;
		Thread.sleep(2000);
	}
}
