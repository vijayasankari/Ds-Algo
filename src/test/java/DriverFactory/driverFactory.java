package DriverFactory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.configReader;

import java.time.Duration;

public class driverFactory {

	private static String url;
	private static String browser;
	public static WebDriver driver;

	public static WebDriver getDriver() {
		try {
			url = configReader.getProperty("url");
			System.out.println("DF: "+url);
			browser = configReader.getBrowserType();
			System.out.println("Driverfact"+browser);
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				driver = new ChromeDriver(chromeOptions); // Initialize the driver (e.g., for Chrome)
			} else if (browser.equalsIgnoreCase("edge")) {
				System.out.println("DFEdge: "+browser);
				EdgeOptions edgeOptions=new EdgeOptions();
				driver = new EdgeDriver(edgeOptions);
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = null;
				System.out.println("Invalid Browser Type");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}
}
