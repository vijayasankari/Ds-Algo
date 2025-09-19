package PageObjects;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.Hooks;
import Utilities.configReader;

public class LaunchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private static String url;
	private PageObjectManager pageObjectManager;

	@FindBy(xpath = "//*[text()='Get Started']")
	WebElement GetStartedButton;

	public LaunchPage(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
		pageObjectManager = new PageObjectManager(Hooks.driver);
		
		
	}

	public void GetStartedClick() {
		url = configReader.getProperty("url");
		System.out.println("DF: "+url);
		driver.get(url);
			int attempts=0;
			
			pageObjectManager.getElementUtilsPage().clickOn(GetStartedButton);
			//System.out.println("page title"+getTitleCurrentPage()+" "+Thread.currentThread().getName());
			//try {
				//	wait.until(ExpectedConditions.elementToBeClickable(GetStartedButton)).click();
					
			//}catch(StaleElementReferenceException e){
				
				//driver.navigate().refresh();
				//PageFactory.initElements(driver,this);
				//wait.until(ExpectedConditions.elementToBeClickable(GetStartedButton)).click();
			
			//}
			
		
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}
}

