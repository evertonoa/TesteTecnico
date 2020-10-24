package pages;

import org.openqa.selenium.WebDriver;

import core.BasePage;

public class BankingAccountPage extends BasePage {

	public BankingAccountPage(WebDriver driver) {
		super(driver);
	}

	public BankingCustomerPage clickOnLogOutButton() {
		clickOnButton("//button[@ng-show='logout']");
		return new BankingCustomerPage(driver);
	}
}
