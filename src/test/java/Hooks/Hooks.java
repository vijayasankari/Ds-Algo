package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.driverFactory;
import Utilities.configReader;
import Utilities.excelReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

	public static WebDriver driver;
	
	@BeforeAll
	public static void getData() {
		try {
			excelReader.fetchData = excelReader.loadTestDataFile(configReader.getProperty("excelPath"),"TryCatchers");
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}

	@Before(order = 0)
	public void setUp() {
		if (driver == null) {
			driver = driverFactory.getDriver();
		}
		System.out.println("Hooks.driver is: " + driver);
	}
	
	@Before("@Login")
	public void loginFilePathSetup() {
		configReader.filepath = "/src/test/resources/TestData/TestData.xlsx"; 
		configReader.SheetName = "LoginCredentials";
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null; // Reset for next scenario
		}
	}
	/*
	 * @AfterStep public void afterStep(Scenario scenario) { WebDriver driver =
	 * driverFactory.getDriver(); // Get WebDriver for current thread
	 * 
	 * if (scenario.isFailed()) { // Capture screenshot if scenario fails
	 * TakesScreenshot screenshotTaker = (TakesScreenshot) driver; final byte[]
	 * screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
	 * scenario.attach(screenshot, "image/png", "My screenshot");
	 * Allure.addAttachment("Myscreenshot", new String(screenshot)); } }
	 */
}