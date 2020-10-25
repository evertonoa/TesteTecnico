package pages;

import core.BasePage;

public class AccountPage extends BasePage {
	
	public final String LOGOUT_BUTTON_XPATH = "//button[@class='btn logout']";
	public final String ACCOUNT_NAME_XPATH = "//span[@class='fontBig ng-binding']";
	public final String COMBO_ACCOUNT_NUMBER_ID = "accountSelect";
	public final String DEPOSIT_BUTTON_XPATH = "//button[contains(text(), 'Deposit')]";
	public final String AMOUNT_TXT_FIELD_XPATH = "//input[@placeholder='amount']";
	public final String CONFIRM_DEPOSIT_BUTTON_XPATH = "//button[@type='submit']";
	public final String WITHDRAWL_BUTTON_XPATH = "//button[@ng-click='withdrawl()']";
	public final String CONFIRM_WITHDRAW_BUTTON_XPATH = "//button[@type='submit']";
	public final String BALANCE_XPATH = "//div[@ng-hide]/strong[2]";
	
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
	
	public AccountPage clickOnConfirmDepositButton() {
		clickOnButton(CONFIRM_DEPOSIT_BUTTON_XPATH);
		return this;
	}
	
	public AccountPage typeWithdrawAmount(String withdrawAmount) {
		typeTextIntoField(AMOUNT_TXT_FIELD_XPATH, withdrawAmount);
		return this;
	}
	
	public AccountPage clickOnWithdrawlButton() {
		clickOnButton(WITHDRAWL_BUTTON_XPATH);
		return this;
	}
	
	public AccountPage clickOnConfirmWithdrawButton() {
		clickOnButton(CONFIRM_WITHDRAW_BUTTON_XPATH);
		return this;
	}
	
	public String getAccountBalance() {
		return getText(BALANCE_XPATH);
	}
	
}
