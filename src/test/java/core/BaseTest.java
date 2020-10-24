package core;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

public class BaseTest {

	@Before
	public void setUp() {
		getDriver().get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@After
	public void tearDown() {
		killDriver();
	}

}
