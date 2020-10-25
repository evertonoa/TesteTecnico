package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class BasePage {

	public void clickOnButton(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void typeTextIntoField(String xpath, String text) {
		getDriver().findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public String getAlertMessage() {
		Alert alert = getDriver().switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}
}
