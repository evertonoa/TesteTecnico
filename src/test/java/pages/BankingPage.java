package pages;

import core.BasePage;

public class BankingPage extends BasePage {

	public BankingManagerPage clickOnBankManagerLoginButton() {
		clickOnButton("//button[contains(text(),'Bank Manager Login')]");
		return new BankingManagerPage();
	}
	
	public BankingCustomerPage clickOnCustomerLoginButton() {
		clickOnButton("//button[contains(text(),'Customer Login')]");
		return new BankingCustomerPage();
	}
}
