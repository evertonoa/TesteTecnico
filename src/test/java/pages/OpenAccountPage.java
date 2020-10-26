package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.BasePage;

public class OpenAccountPage extends BasePage{
	
	public final String SELECT_CUSTUMER_ID = "userSelect";
	public final String SELECT_CURRENCY_ID = "currency";
	public final String PROCESS_BUTTON_XPATH = "//button[@type='submit']";
	public final String HOME_BUTTON_XPATH = "//button[@class='btn home']";
	
	public OpenAccountPage selectCustomer(String text) {
		WebElement element = getDriver().findElement(By.id(SELECT_CUSTUMER_ID));
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
		return this;
	}

	public OpenAccountPage selectCurrency(String text) {
		WebElement element = getDriver().findElement(By.id(SELECT_CURRENCY_ID));
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
		return this;
	}

	public OpenAccountPage clickOnProcessButton() {
		clickOnButton(PROCESS_BUTTON_XPATH);
		return this;
	}
	
	public String getAlertSuccessMessage() {
		return getAlertMessage();
	}
	
	public BankingMainPage clickOnHomeButton() {
		clickOnButton(HOME_BUTTON_XPATH);
		return new BankingMainPage();
	}
}