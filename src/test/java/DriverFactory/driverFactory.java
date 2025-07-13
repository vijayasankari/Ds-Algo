package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {
	public static WebDriver getChromeDriver() {
		
			//WebDriverManager.chromedriver().setup(); // Use WebDriverManager for automatic driver setup
            // Initialize the driver (e.g., for Chrome)        
			WebDriver driver = new ChromeDriver();
        	driver.get("https://dsportalapp.herokuapp.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30) );
            driver.manage().window().maximize();
        return driver;
    }
	
	public static WebDriver getFirefoxDriver() {
            // Initialize the driver (e.g., for firefox)  
		//WebDriverManager.firefoxdriver().setup(); // Use WebDriverManager for automatic driver setup
		WebDriver driver = new FirefoxDriver();
        
        return driver;
    }
	public static WebDriver getEdgeDriver() {
      
            // Initialize the driver (e.g., for Edge)        
			WebDriver driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30) );
            driver.manage().window().maximize();
        return driver;
    }

}
