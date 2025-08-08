package Hooks;

import org.openqa.selenium.WebDriver;

import DriverFactory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	public static WebDriver driver;
	@Before(order = 0)
    public void setUp() {
		if (driver == null) {
			driver = driverFactory.getChromeDriver();
		}
		System.out.println("Hooks.driver is: " + driver);
    }
	
	@After
     public void tearDown() {
        if (driver != null) {
            driver.quit();
           driver = null; // Reset for next scenario
    }
}
}