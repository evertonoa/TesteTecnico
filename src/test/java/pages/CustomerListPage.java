package pages;

import core.BasePage;

public class CustomerListPage extends BasePage{
	
	public final String COMBO_ACCOUNT_NAME_ID = "userSelect";
	public final String LOGIN_BUTTON_XPATH = "//button[@type='submit']";

	public CustomerListPage selectAccountName(String customerName) {
		selectCombo(COMBO_ACCOUNT_NAME_ID, customerName);
		return this;
	}
	
	public AccountPage clickOnLoginButton() {
		clickOnButton(LOGIN_BUTTON_XPATH);
		return new AccountPage();
	}
	
}
