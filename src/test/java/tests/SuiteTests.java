package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AccountTest.class,
	CustomerTest.class,
	LoginTest.class
})
public class SuiteTests {

}
