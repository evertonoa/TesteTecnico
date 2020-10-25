package pages;

import core.BasePage;

public class BankingPage extends BasePage {
	
	public final String BANK_MANAGER_BUTTON_XPATH = "//button[contains(text(),'Bank Manager Login')]";
	public final String CUSTOMER_LOGIN_BUTTON_XPATH = "//button[contains(text(),'Customer Login')]";
	

	public BankingManagerPage clickOnBankManagerLoginButton() {
		clickOnButton(BANK_MANAGER_BUTTON_XPATH);
		return new BankingManagerPage();
	}
	
	public BankingCustomerPage clickOnCustomerLoginButton() {
		clickOnButton(CUSTOMER_LOGIN_BUTTON_XPATH);
		return new BankingCustomerPage();
	}
}
