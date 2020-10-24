package pages;

import org.openqa.selenium.WebDriver;

import core.BasePage;

public class BankingPage extends BasePage {

	public BankingPage(WebDriver driver) {
		super(driver);
	}

	public BankingManagerPage clickOnBankManagerLoginButton() {
		clickOnButton("//button[contains(text(),'Bank Manager Login')]");
		return new BankingManagerPage(driver);
	}
	
	public BankingCustomerPage clickOnCustomerLoginButton() {
		clickOnButton("//button[contains(text(),'Customer Login')]");
		return new BankingCustomerPage(driver);
	}
}
