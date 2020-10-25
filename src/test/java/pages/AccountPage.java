package pages;

import core.BasePage;

public class AccountPage extends BasePage {
	
	public final String LOGOUT_BUTTON_XPATH = "//button[@class='btn logout']";
	public final String ACCOUNT_NAME_XPATH = "//span[@class='fontBig ng-binding']";
	public final String COMBO_ACCOUNT_NUMBER_ID = "accountSelect";
	public final String DEPOSIT_BUTTON_XPATH = "//button[contains(text(), 'Deposit')]";
	public final String AMOUNT_TXT_FIELD_XPATH = "//input[@placeholder='amount']";
	public final String CONFIRM_DEPOSIT_BUTTON_XPATH = "//button[@type='submit']";
	
	public BankingCustomerPage clickOnLogOutButton() {
		clickOnButton(LOGOUT_BUTTON_XPATH);
		return new BankingCustomerPage();
	}
	
	public String getWelcomeAccountName() {
		return getText(ACCOUNT_NAME_XPATH);
	}
	
	public void selectAccountNumberOnCombo(String accountNumber) {
		selectCombo(COMBO_ACCOUNT_NUMBER_ID, accountNumber);
	}
	
	public AccountPage clickOnDepositButton() {
		clickOnButton(DEPOSIT_BUTTON_XPATH);
		return this;
	}
	
	public AccountPage typeDepositAmount(String depositAmount) {
		typeTextIntoField(AMOUNT_TXT_FIELD_XPATH, depositAmount);
		return this;
	}
	
	public void clickOnConfirmDepositButton() {
		clickOnButton(CONFIRM_DEPOSIT_BUTTON_XPATH);
	}
	
}
