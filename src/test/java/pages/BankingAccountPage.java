package pages;

import core.BasePage;

public class BankingAccountPage extends BasePage {
	public BankingCustomerPage clickOnLogOutButton() {
		clickOnButton("//button[@ng-show='logout']");
		return new BankingCustomerPage();
	}
}
