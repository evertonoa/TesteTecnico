package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = Web.createChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
