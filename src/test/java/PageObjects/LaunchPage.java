package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//*[text()='Get Started']")
	private WebElement GetStartedButton;

	public LaunchPage(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
	}

	public void GetStartedClick() {
		if (GetStartedButton.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(GetStartedButton)).click();
		}
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}
}
