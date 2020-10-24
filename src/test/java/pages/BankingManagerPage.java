package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.BasePage;

public class BankingManagerPage extends BasePage {

	public BankingManagerPage(WebDriver driver) {
		super(driver);
	}

	public BankingManagerPage clickOnAddCustomerButton() {
		clickOnButton("//button[@ng-click='addCust()']");
		return new BankingManagerPage(driver);
	}
	
	public BankingManagerPage clickOnOpenAccountButton() {
		clickOnButton("//button[@ng-click='openAccount()']");
		return this;
	}

	public BankingManagerPage clickOnCustomerButton() {
		clickOnButton("//button[@ng-click='showCust()']");
		return new BankingManagerPage(driver);
	}

	public BankingManagerPage typeFirstName(String firstName) {
		typeTextIntoField("//input[@ng-model='fName']", firstName);
		return this;
	}

	public BankingManagerPage typeLastName(String lastName) {
		typeTextIntoField("//input[@ng-model='lName']", lastName);
		return this;
	}

	public BankingManagerPage typePostCode(String postCode) {
		typeTextIntoField("//input[@placeholder='Post Code']", postCode);
		return this;
	}

	public BankingManagerPage AddCustomer() {
		clickOnButton("//button[@class='btn btn-default']");
		return this;
	}

	public BankingManagerPage removeCustomer(String text) {
		typeTextIntoField("//input[@ng-model='searchCustomer']", text);
		clickOnButton("//button[@ng-click='deleteCust(cust)']");
		return this;
	}
	
	public BankingManagerPage checkAlertSuccessMessage(String message) {
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		Assert.assertTrue(alertMessage.contains(message));
		alert.accept();
		return this;
	}
	
	public BankingManagerPage selectCustomer(String text) {
		WebElement element = driver.findElement(By.id("userSelect"));
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
		return this;
	}
	
	public BankingManagerPage selectCurrency(String text) {
		WebElement element = driver.findElement(By.id("currency"));
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
		return this;
	}
	
	public BankingManagerPage clickOnProcessButton() {
		clickOnButton("//button[@type='submit']");
		return this;
	}
}
