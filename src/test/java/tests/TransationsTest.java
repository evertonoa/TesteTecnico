package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.BaseTest;
import pages.AccountPage;
import pages.BankingPage;

public class TransationsTest extends BaseTest{

	public final String CUSTOMER_NAME = "Harry Potter";
	public final String CURRENCY = "Dollar";
	public final String ALERT_SUCCESS_MESSAGE_TXT = "Account created successfully with account Number";
	public final String AMOUNT_TO_BE_DEPOSITED = "200";
	public final String AMOUNT_TO_BE_WITHDREW = "100";
	public final String AMOUNT_TO_BE_WITHDREW_MORE_THAN_BALANCE = "300";
	public final String DEPOSIT_SUCCESS_MESSAGE = "Deposit Successful";
	public final String WITHDRAW_SUCCESS_MESSAGE = "Transaction successful";
	public final String WITHDRAW_FAIL_MESSAGE = "Transaction Failed. You can not withdraw amount more than the balance.";
	
	@Test
	public void depositTest() {
		AccountPage accountPage = new AccountPage();
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton()
			.clickOnDepositButton();
			
		int balanceBeforeDeposit = Integer.parseInt(accountPage.getAccountBalance());
		
		accountPage
			.typeDepositAmount(AMOUNT_TO_BE_DEPOSITED)
			.clickOnConfirmDepositButton();

		
		int balanceAfterDeposit = Integer.parseInt(accountPage.getAccountBalance());
		int amountDeposited = Integer.parseInt(AMOUNT_TO_BE_DEPOSITED);
		
		assertEquals(DEPOSIT_SUCCESS_MESSAGE, accountPage.getSuccessDepositMessage());
		assertEquals(balanceBeforeDeposit+amountDeposited, balanceAfterDeposit);
	}
	
	@Test
	public void withdrawlTest() throws InterruptedException {
		AccountPage accountPage = new AccountPage();
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton()
			.clickOnDepositButton()
			.typeDepositAmount(AMOUNT_TO_BE_DEPOSITED)
			.clickOnConfirmDepositButton()
			.clickOnWithdrawlButton();
		
		Thread.sleep(1000);
		
		int balanceBeforeWithdraw = Integer.parseInt(accountPage.getAccountBalance());

		accountPage.typeWithdrawAmount(AMOUNT_TO_BE_WITHDREW)
			.clickOnConfirmWithdrawButton();
			
		assertEquals(WITHDRAW_SUCCESS_MESSAGE, new AccountPage().getSuccessWithdrawMessage());
		
		int balanceAfterWithdraw = Integer.parseInt(accountPage.getAccountBalance());
		int amountWithdrew = Integer.parseInt(AMOUNT_TO_BE_WITHDREW);
		
		assertEquals(balanceBeforeWithdraw-amountWithdrew, balanceAfterWithdraw);
	}
	
	@Test
	public void withdrawMoreThanBalanceTest() throws InterruptedException {
		new BankingPage()
			.clickOnCustomerLoginButton()
			.selectAccountName(CUSTOMER_NAME)
			.clickOnLoginButton()
			.clickOnWithdrawlButton()
			.typeDepositAmount(AMOUNT_TO_BE_WITHDREW)
			.clickOnConfirmWithdrawButton();
			
		assertEquals(WITHDRAW_FAIL_MESSAGE, new AccountPage().getFailWithdrawMessage());
	}
}
