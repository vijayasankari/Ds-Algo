package DriverFactory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.configReader;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {
	
	private static String url;
	private static String browser;
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
			try {
				url = configReader.getProperty("url");
				browser = configReader.getProperty("browser");
				if (browser.equalsIgnoreCase("chrome"))
				{
					ChromeOptions chromeOptions = new ChromeOptions();
				    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					driver = new ChromeDriver(chromeOptions); // Initialize the driver (e.g., for Chrome)   
				}
				else if (browser.equalsIgnoreCase("edge"))
				{
					driver = new EdgeDriver();
				}
				else if (browser.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
				}
				else
				{
					driver = null;
					System.out.println("Invalid Browser Type");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        	driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30) );
            driver.manage().window().maximize();
        return driver;
    }
}
