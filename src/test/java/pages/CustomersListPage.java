package pages;

import core.BasePage;

public class CustomersListPage extends BasePage {

	public final String SEARCH_CUSTOMER_FIELD_XPATH = "//input[@ng-model='searchCustomer']";
	public final String DELETE_BUTTON_XPATH = "//button[@ng-click='deleteCust(cust)']";
	
	public CustomersListPage findCustomerOnTheList(String customerName) {
		clearTextField(SEARCH_CUSTOMER_FIELD_XPATH);
		typeTextIntoField(SEARCH_CUSTOMER_FIELD_XPATH, customerName);
		return this;
	}
	
	public CustomersListPage removeCustomer(String text) {
		typeTextIntoField(SEARCH_CUSTOMER_FIELD_XPATH, text);
		clickOnButton(DELETE_BUTTON_XPATH);
		return this;
	}
}
