package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AccountPage;
import pages.BankingPage;
import pages.OpenAccountPage;

public class AccountTest extends BaseTest{
	
	public final String CUSTOMER_NAME = "Harry Potter";
	public final String CURRENCY = "Dollar";
	public final String ALERT_SUCCESS_MESSAGE_TXT = "Account created successfully with account Number";
	public final String AMOUNT_TO_BE_DEPOSITED = "200";
	public final String AMOUNT_TO_BE_WITHDREW = "100";
	public final String AMOUNT_TO_BE_WITHDREW_MORE_THAN_BALANCE = "300";
	public final String DEPOSIT_SUCCESS_MESSAGE_XPATH = "//span[@ng-show='message']";
	public final String DEPOSIT_SUCCESS_MESSAGE = "Deposit Successful";
	public final String WITHDRAW_SUCCESS_MESSAGE_XPATH = "//span[@ng-show='message']";
	public final String WITHDRAW_SUCCESS_MESSAGE = "Transaction successful";
	public final String WITHDRAW_FAIL_MESSAGE_XPATH = "//span[@ng-show='message']";
	public final String WITHDRAW_FAIL_MESSAGE = "Transaction Failed. You can not withdraw amount more than the balance.";
	
	@Test
	public void openAccountTest() {
		new BankingPage()
			.clickOnBankManagerLoginButton()
			.clickOnOpenAccountButton()
			.selectCustomer(CUSTOMER_NAME)
			.selectCurrency(CURRENCY)
			.clickOnProcessButton();
		
		String alertSuccessMessage = new OpenAccountPage().getAlertSuccessMessage();
		Assert.assertTrue(alertSuccessMessage.contains(ALERT_SUCCESS_MESSAGE_TXT));
		String accountNumber = alertSuccessMessage.substring(50, 54);

		new OpenAccountPage()
			.clickOnHomeButton()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton()
			.selectAccountNumberOnCombo(accountNumber);;

		Assert.assertEquals(accountNumber, new AccountPage().getText("/html/body/div[3]/div/div[2]/div/div[2]/strong[1]"));
//		melhorar o xpath
	}
	
	@Test
	public void depositTest() {
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton()
			.clickOnDepositButton()
			.typeDepositAmount(AMOUNT_TO_BE_DEPOSITED)
			.clickOnConfirmDepositButton();
			
		Assert.assertEquals(DEPOSIT_SUCCESS_MESSAGE, new AccountPage().getText(DEPOSIT_SUCCESS_MESSAGE_XPATH));
	}
	
	@Test
	public void withdrawlTest() throws InterruptedException {
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton()
			.clickOnDepositButton()
			.typeDepositAmount(AMOUNT_TO_BE_DEPOSITED)
			.clickOnConfirmDepositButton()
			.clickOnWithdrawlButton();
		
		Thread.sleep(1000);
		
		new AccountPage().typeDepositAmount(AMOUNT_TO_BE_WITHDREW)
			.clickOnConfirmWithdrawButton();
			
		Assert.assertEquals(WITHDRAW_SUCCESS_MESSAGE, new AccountPage().getText(WITHDRAW_SUCCESS_MESSAGE_XPATH));
	}
	
	@Test
	public void withdrawMoreThanBalanceTest() throws InterruptedException {
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton()
			.clickOnWithdrawlButton()
			.typeDepositAmount(AMOUNT_TO_BE_WITHDREW)
			.clickOnConfirmWithdrawButton()
			;
			
		Assert.assertEquals(WITHDRAW_FAIL_MESSAGE, new AccountPage().getText(WITHDRAW_FAIL_MESSAGE_XPATH));
	}
}
