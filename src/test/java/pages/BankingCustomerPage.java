package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.BasePage;

public class BankingCustomerPage extends BasePage{
	
	public final String COMBO_ACCOUNT_NAME_ID = "userSelect";
	public final String LOGIN_BUTTON_XPATH = "//button[@type='submit']";

	public BankingCustomerPage selectAccountName(String text) {
		WebElement element = getDriver().findElement(By.id(COMBO_ACCOUNT_NAME_ID));
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
		return this;
	}
	
	public AccountPage clickOnLoginButton() {
		clickOnButton(LOGIN_BUTTON_XPATH);
		return new AccountPage();
	}
}
