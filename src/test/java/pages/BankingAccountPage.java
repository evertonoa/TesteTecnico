package pages;

import core.BasePage;

public class BankingAccountPage extends BasePage {
	public BankingCustomerPage clickOnLogOutButton() {
		clickOnButton("//button[@class='btn logout']");
		return new BankingCustomerPage();
	}
}
