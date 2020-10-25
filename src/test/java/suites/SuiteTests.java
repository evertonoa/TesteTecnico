package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.OpenAccountTest;
import tests.CustomerTest;
import tests.LoginTest;

@RunWith(Suite.class)
@SuiteClasses({
	OpenAccountTest.class,
	CustomerTest.class,
	LoginTest.class
})

public class SuiteTests {
	
}
