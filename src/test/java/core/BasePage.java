package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void clickOnButton(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void typeTextIntoField(String xpath, String text) {
		clearTextField(xpath);
		getDriver().findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public void clearTextField(String xpath) {
		getDriver().findElement(By.xpath(xpath)).clear();
	}
	
	public String getAlertMessage() {
		Alert alert = getDriver().switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}
	
	public void acceptAlert() {
		Alert alert = getDriver().switchTo().alert();
		alert.accept();
	}
	
	public String getText(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getText();
	}
	
	public String getPageUrl() {
		return getDriver().getCurrentUrl();
	}
	
	public void selectCombo(String xpath, String text) {
		WebElement element = getDriver().findElement(By.id(xpath));
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
	}
	
	public int getTableSize(String xpath) {
		return getDriver().findElements(By.xpath(xpath)).size();
	}
}
