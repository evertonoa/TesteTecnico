package pages;

import core.BasePage;

public class AccountPage extends BasePage {
	
	public final String LOGOUT_BUTTON_XPATH = "//button[@class='btn logout']";
	public final String ACCOUNT_NAME_XPATH = "//span[@class='fontBig ng-binding']";
	
	public BankingCustomerPage clickOnLogOutButton() {
		clickOnButton(LOGOUT_BUTTON_XPATH);
		return new BankingCustomerPage();
	}
	
	public String getWelcomeAccountName() {
		return getText(ACCOUNT_NAME_XPATH);
	}
	
}
