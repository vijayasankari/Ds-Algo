package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataStructuresPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(linkText = "Time Complexity")
	WebElement TimeComplexityLink;
	@FindBy(linkText = "Try here>>>")
	WebElement TryHereButton;
	@FindBy(linkText = "Practice Questions")
	WebElement PracticeQuestionsLink;
	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement DataStructuresDropdown;
	@FindBy(xpath = "//a[text()='Arrays']")
	WebElement Arrays;
	@FindBy(xpath = "//a[text()='Linked List']")
	WebElement LinkedList;
	@FindBy(xpath = "//a[text()='Stack']")
	WebElement Stack;
	@FindBy(xpath = "//a[text()='Queue']")
	WebElement Queue;
	@FindBy(xpath = "//a[text()='Tree']")
	WebElement Tree;
	@FindBy(xpath = "//a[text()='Graph']")
	WebElement Graph;
	@FindBy(xpath = "//*[@id='navbarCollapse']/div[2]/ul/a[2]")
	WebElement UsernameDisplayed;

	public DataStructuresPage(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public void clickTimeComplexityLink() {
		if (TimeComplexityLink.isDisplayed()) {
			TimeComplexityLink.click();
		}
	}

	public void clickTryHereButton() {
		if (TryHereButton.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(TryHereButton)).click();
		}
	}

	public void clickPracticeQuestionsLink() {
		if (PracticeQuestionsLink.isDisplayed()) {
			PracticeQuestionsLink.click();
		}
	}

	public void clickUsernameLink() {
		if (UsernameDisplayed.isDisplayed()) {
			UsernameDisplayed.click();
		}
	}

	public void clickDataStructuresDropdown() {
		if (DataStructuresDropdown.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(DataStructuresDropdown)).click();
		}
	}

	public void clickArrayInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(Arrays)).click();
	}

	public void clickLinkedListInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(LinkedList)).click();
	}

	public void clickStackInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(Stack)).click();
	}

	public void clickQueueInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(Queue)).click();
	}

	public void clickTreeInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(Tree)).click();
	}

	public void clickGraphInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(Graph)).click();
	}

}
