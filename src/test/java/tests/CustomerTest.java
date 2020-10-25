package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AddCustomerPage;
import pages.BankingManagerPage;
import pages.BankingPage;

public class CustomerTest extends BaseTest{
	
	public final String FIRST_NAME = "Jose";
	public final String LAST_NAME = "Silva";
	public final String POST_CODE =  "999999";
			

	@Test
	public void addNewCustomerTest() {
		new BankingPage()
			.clickOnBankManagerLoginButton()
			.clickOnAddCustomerButton()
			.typeFirstName(FIRST_NAME)
			.typeLastName(LAST_NAME)
			.typePostCode(POST_CODE)
			.AddCustomer()
			;
		
		String alertSuccessMessage = new AddCustomerPage().getAlertSuccessMessage();
		Assert.assertTrue(alertSuccessMessage.contains("Customer added successfully with customer"));
		
		new BankingManagerPage()
			.clickOnCustomerListButton()
			.findCustomerOnTheList(FIRST_NAME);
		//NAO SEI FAZER O ASSERTION PARA VERIFICAR SE O CUSTOMER FOI ADICIONADO
	}
	
	@Test
	public void addDuplicateCustomerTest() throws InterruptedException {
		new BankingPage()
		.clickOnBankManagerLoginButton()
		.clickOnAddCustomerButton()
		.typeFirstName(FIRST_NAME)
		.typeLastName(LAST_NAME)
		.typePostCode(POST_CODE)
		.AddCustomer()
		.acceptAlertSuccessMessage()
		.typeFirstName(FIRST_NAME)
		.typeLastName(LAST_NAME)
		.typePostCode(POST_CODE)
		.AddCustomer();
		
		String alertCustomerDuplicateMessage = new AddCustomerPage().getAlertCustumerDuplicateMessage();
		Assert.assertTrue(alertCustomerDuplicateMessage.contains("Please check the details. Customer may be duplicate."));
	}
	
	@Test
	public void deleteCustomerTest() throws InterruptedException {
		new BankingPage()
			.clickOnBankManagerLoginButton()
			.clickOnCustomerListButton()
			.removeCustomer("Neville")
			.findCustomerOnTheList("Nevillexxxxx")
			;
		//NAO SEI FAZER O ASSERTION PARA VERIFICAR SE O CUSTOMER FOI REMOVIDO
		Thread.sleep(2000);
	}
}
