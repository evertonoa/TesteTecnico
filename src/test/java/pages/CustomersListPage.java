package pages;

import core.BasePage;

public class CustomersListPage extends BasePage {

	public final String SEARCH_CUSTOMER_FIELD_XPATH = "//input[@ng-model='searchCustomer']";
	public final String DELETE_BUTTON_XPATH = "//button[@ng-click='deleteCust(cust)']";
	public final String FIRST_NAME_XPATH = "//table[@class='table table-bordered table-striped']/tbody/tr/td[1]";
	public final String LAST_NAME_XPATH = "//table[@class='table table-bordered table-striped']/tbody/tr/td[2]";
	public final String POST_CODE_XPATH = "//table[@class='table table-bordered table-striped']/tbody/tr/td[3]";
	public final String CUSTOMER_LIST_TABLE_XPATH = "//table[@class='table table-bordered table-striped']";
	
	
	public CustomersListPage findCustomerOnTheList(String customerName) {
		clearTextField(SEARCH_CUSTOMER_FIELD_XPATH);
		typeTextIntoField(SEARCH_CUSTOMER_FIELD_XPATH, customerName);
		return this;
	}
	
	public int getCustomerListTableSize() {
		return getTableSize(CUSTOMER_LIST_TABLE_XPATH);
	}
	
	public CustomersListPage removeCustomer(String text) {
		typeTextIntoField(SEARCH_CUSTOMER_FIELD_XPATH, text);
		clickOnButton(DELETE_BUTTON_XPATH);
		return this;
	}
	
	public String getFirstName() {
		return getText(FIRST_NAME_XPATH);
	}
	
	public String getLastName() {
		return getText(LAST_NAME_XPATH);
	}

	public String getPostCode() {
		return getText(POST_CODE_XPATH);
	}
}
