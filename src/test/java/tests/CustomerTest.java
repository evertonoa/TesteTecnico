package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AddCustomerPage;
import pages.BankingPage;

public class CustomerTest extends BaseTest{

	@Test
	public void addNewCustomerTest() {
		new BankingPage()
			.clickOnBankManagerLoginButton()
			.clickOnAddCustomerButton()
			.typeFirstName("Jose")
			.typeLastName("Silva")
			.typePostCode("11111")
			.AddCustomer()
			;
		String alertSuccessMessage = new AddCustomerPage().getAlertSuccessMessage();
		Assert.assertTrue(alertSuccessMessage.contains("Customer added successfully with customer"));
	}
	
	@Test
	public void deleteCustomerTest() {
		new BankingPage()
			.clickOnBankManagerLoginButton()
			.clickOnCustomerButton()
			.removeCustomer("Neville");
	}
}
