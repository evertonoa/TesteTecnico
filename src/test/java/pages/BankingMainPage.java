package pages;

import core.BasePage;

public class BankingMainPage extends BasePage {
	
	public final String BANK_MANAGER_BUTTON_XPATH = "//button[contains(text(),'Bank Manager Login')]";
	public final String CUSTOMER_LOGIN_BUTTON_XPATH = "//button[contains(text(),'Customer Login')]";
	

	public ManagerPage clickOnBankManagerLoginButton() {
		clickOnButton(BANK_MANAGER_BUTTON_XPATH);
		return new ManagerPage();
	}
	
	public CustomerListPage clickOnCustomerLoginButton() {
		clickOnButton(CUSTOMER_LOGIN_BUTTON_XPATH);
		return new CustomerListPage();
	}
}
