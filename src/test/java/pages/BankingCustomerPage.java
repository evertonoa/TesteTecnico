package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.BasePage;

public class BankingCustomerPage extends BasePage{

	public BankingCustomerPage(WebDriver driver) {
		super(driver);
	}
	
	public BankingCustomerPage selectAccount(String text) {
		WebElement element = driver.findElement(By.id("userSelect"));
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
		
		return this;
	}
	
	public BankingAccountPage clickOnLoginButton() {
		clickOnButton("//button[@type='submit']");
		return new BankingAccountPage(driver);
	}

}
