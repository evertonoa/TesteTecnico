package pages;

import core.BasePage;

public class ManagerPage extends BasePage {

	public final String ADD_CUSTOMER_BUTTON_XPATH = "//button[@ng-click='addCust()']";
	public final String OPEN_ACCOUNT__BUTTON_XPATH = "//button[@ng-click='openAccount()']";
	public final String CUSTOMERS_LIST_BUTTON_XPATH = "//button[@ng-click='showCust()']";
	
	public AddCustomerPage clickOnAddCustomerButton() {
		clickOnButton(ADD_CUSTOMER_BUTTON_XPATH);
		return new AddCustomerPage();
	}

	public OpenAccountPage clickOnOpenAccountButton() {
		clickOnButton(OPEN_ACCOUNT__BUTTON_XPATH);
		return new OpenAccountPage();
	}

	public CustomersListPage clickOnCustomerListButton() {
		clickOnButton(CUSTOMERS_LIST_BUTTON_XPATH);
		return new CustomersListPage();
	}
}
