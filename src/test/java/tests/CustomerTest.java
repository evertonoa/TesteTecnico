package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.BaseTest;
import pages.AddCustomerPage;
import pages.ManagerPage;
import pages.BankingMainPage;
import pages.CustomersListPage;

public class CustomerTest extends BaseTest{
	
	public final String FIRST_NAME = "Jose";
	public final String LAST_NAME = "Silva";
	public final String POST_CODE =  "999999";
	public final String ALERT_MESSAGE_SUCCESS_TXT = "Customer added successfully with customer";
	public final String ALERT_MESSAGE_CUSTOMER_DUPLICATE_TXT = "Please check the details. Customer may be duplicate.";
			

	@Test
	public void addNewCustomerTest() {
		new BankingMainPage()
			.clickOnBankManagerLoginButton()
			.clickOnAddCustomerButton()
			.typeFirstName(FIRST_NAME)
			.typeLastName(LAST_NAME)
			.typePostCode(POST_CODE)
			.AddCustomer();
		
		String alertSuccessMessage = new AddCustomerPage().getAlertSuccessMessage();
		assertTrue(alertSuccessMessage.contains(ALERT_MESSAGE_SUCCESS_TXT));
		
		new ManagerPage()
			.clickOnCustomerListButton()
			.findCustomerOnTheList(FIRST_NAME);
		
		CustomersListPage customer = new CustomersListPage();
		assertEquals(FIRST_NAME, customer.getFirstName());
		assertEquals(LAST_NAME, customer.getLastName());
		assertEquals(POST_CODE, customer.getPostCode());
	}
	
	@Test
	public void addDuplicateCustomerTest() throws InterruptedException {
		new BankingMainPage()
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
		assertTrue(alertCustomerDuplicateMessage.contains(ALERT_MESSAGE_CUSTOMER_DUPLICATE_TXT));
	}
	
	@Test
	public void deleteCustomerTest() throws InterruptedException {
		new BankingMainPage()
			.clickOnBankManagerLoginButton()
			.clickOnCustomerListButton()
			.removeCustomer("Neville")
			.findCustomerOnTheList("Neville");
		
		assertEquals(1, new CustomersListPage().getCustomerListTableSize());
	}
}
