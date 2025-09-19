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

	
	private static String browser;
	//public static WebDriver driver;
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
//	private static ThreadLocal<String> threadlocalbrowser=new ThreadLocal<String>();

	public static void setDriver() {
		try {
			
			
			browser = configReader.getBrowserType();
		
			//System.out.println("Driverfact"+threadlocalbrowser.get());
			
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver.set(new ChromeDriver(chromeOptions)); // Initialize the driver (e.g., for Chrome)
			} else if (browser.equalsIgnoreCase("edge")) {
				System.out.println("DFEdge: "+browser);
				EdgeOptions edgeOptions=new EdgeOptions();
				driver.set(new EdgeDriver());
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver.set(new FirefoxDriver());
			} else {
				driver.set(null);
				System.out.println("Invalid Browser Type");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().manage().window().maximize();
		
	}
	public static WebDriver getDriver() {
		return driver.get();
		
	}
	
	public static void quitDriver() {
		if (driver.get()!= null) {
			driver.get().quit();
			System.out.println("Quitting");
			driver.remove();
		}
	}
	
	
	
}
