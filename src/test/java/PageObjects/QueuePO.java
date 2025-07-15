package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driverFactory;

public class QueuePO {
	WebDriver driver;
	WebDriverWait wait; 
	
	public QueuePO(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	

}