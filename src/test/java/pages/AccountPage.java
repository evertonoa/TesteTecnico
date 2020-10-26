package pages;

import core.BasePage;

public class AccountPage extends BasePage {
	
	//***BUTTONS***
	public final String LOGOUT_BUTTON_XPATH = "//button[@class='btn logout']";
	public final String DEPOSIT_BUTTON_XPATH = "//button[contains(text(), 'Deposit')]";
	public final String CONFIRM_DEPOSIT_BUTTON_XPATH = "//button[@type='submit']";
	public final String WITHDRAWL_BUTTON_XPATH = "//button[@ng-click='withdrawl()']";
	public final String CONFIRM_WITHDRAW_BUTTON_XPATH = "//button[@type='submit']";

	public final String ACCOUNT_NAME_XPATH = "//span[@class='fontBig ng-binding']";
	public final String ACCOUNT_NUMBER_XPATH = "//div[@ng-hide]/strong[1]";
	
	public final String COMBO_ACCOUNT_NUMBER_ID = "accountSelect";
	public final String AMOUNT_TXT_FIELD_XPATH = "//input[@placeholder='amount']";
	public final String BALANCE_XPATH = "//div[@ng-hide]/strong[2]";
	
	//***MESSAGES***
	public final String DEPOSIT_SUCCESS_MESSAGE_XPATH = "//span[@ng-show='message']";
	public final String WITHDRAW_SUCCESS_MESSAGE_XPATH = "//span[@ng-show='message']";
	public final String WITHDRAW_FAIL_MESSAGE_XPATH = "//span[@ng-show='message']";


	
	public CustomerListPage clickOnLogOutButton() {
		clickOnButton(LOGOUT_BUTTON_XPATH);
		return new CustomerListPage();
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
	
	public String getSuccessDepositMessage() {
		return getText(DEPOSIT_SUCCESS_MESSAGE_XPATH);
	}

	public String getSuccessWithdrawMessage() {
		return getText(WITHDRAW_SUCCESS_MESSAGE_XPATH);
	}

	public String getFailWithdrawMessage() {
		return getText(WITHDRAW_FAIL_MESSAGE_XPATH);
	}
	
	public String getAccountNumber() {
		return getText(ACCOUNT_NUMBER_XPATH);
	}
}
