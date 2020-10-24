package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnButton(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void typeTextIntoField(String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
}
