package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePO {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[text()='NumpyNinja']")
	WebElement NumpyNinjaLabel;
	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement DataStructuresDropdown;
	@FindBy(xpath = "//a[text()='Arrays']")
	WebElement ArraysDropdown;
	@FindBy(xpath = "//a[text()='Linked List']")
	WebElement LinkedListDropdown;
	@FindBy(xpath = "//a[text()='Stack']")
	WebElement StackDropdown;
	@FindBy(xpath = "//a[text()='Queue']")
	WebElement QueueDropdown;
	@FindBy(xpath = "//a[text()='Tree']")
	WebElement TreeDropdown;
	@FindBy(xpath = "//a[text()='Graph']")
	WebElement GraphDropdown;
	@FindBy(linkText = "Register")
	WebElement Register;
	@FindBy(linkText = "Sign in")
	WebElement SignIn;
	@FindBy(xpath = "//*[text()='Data Structures-Introduction']/../*[text()='Get Started']")
	WebElement DataStructuresGetStarted;
	@FindBy(xpath = "//*[text()='Array']/../*[text()='Get Started']")
	WebElement ArrayGetStarted;
	@FindBy(xpath = "//*[text()='Linked List']/../*[text()='Get Started']")
	WebElement LinkedListGetStarted;
	@FindBy(xpath = "//*[text()='Stack']/../*[text()='Get Started']")
	WebElement StackGetStarted;
	@FindBy(xpath = "//*[text()='Queue']/../*[text()='Get Started']")
	WebElement QueueGetStarted;
	@FindBy(xpath = "//*[text()='Tree']/../*[text()='Get Started']")
	WebElement TreeGetStarted;
	@FindBy(xpath = "//*[text()='Graph']/../*[text()='Get Started']")
	WebElement GraphGetStarted;
	@FindBy(xpath = "//*[@role='alert']")
	WebElement WarningMessage;
	@FindBy(linkText = "Sign out")
	WebElement SignOut;
	@FindBy(xpath = "//*[@id='navbarCollapse']/div[2]/ul/a[2]")
	WebElement FetchUsername;

	public homePO(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public void clickNumpyNinjaLabel() {
		if (NumpyNinjaLabel.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(NumpyNinjaLabel)).click();
		}
	}

	public void clickRegisterLink() {
		if (Register.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(Register)).click();
		}
	}

	public void clickSignInLink() {
		if (SignIn.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(SignIn)).click();
		}
	}

	public void clickDataStructuresDropdown() {
		if (DataStructuresDropdown.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(DataStructuresDropdown)).click();
		}
	}

	public List<String> fetchDataStructuresDropdownValues() {
		List<WebElement> dropdownValues = DataStructuresDropdown.findElements(By.xpath("//*[@class='dropdown-item']"));
		List<String> dropdownValue = new ArrayList<>();
		if (dropdownValues.isEmpty()) {
			System.out.println("List is empty");
		} else {
			System.out.println(dropdownValues.size());
			for (WebElement item : dropdownValues) {
				String text = item.getText();
				dropdownValue.add(text);
			}
		}
		return dropdownValue;
	}

	public void clickArrayInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(ArraysDropdown)).click();
	}

	public void clickLinkedListInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(LinkedListDropdown)).click();
	}

	public void clickStackInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(StackDropdown)).click();
	}

	public void clickQueueInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(QueueDropdown)).click();
	}

	public void clickTreeInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(TreeDropdown)).click();
	}

	public void clickGraphInDropdown() {
		clickDataStructuresDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(GraphDropdown)).click();
	}

	public String messageToUser() {

		return wait.until(ExpectedConditions.elementToBeClickable(WarningMessage)).getText();
	}

	public void clickDataStructuresGetStartedButton() {
		if (DataStructuresGetStarted.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(DataStructuresGetStarted)).click();
		}
	}

	public void clickArrayGetStartedButton() {
		if (ArrayGetStarted.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(ArrayGetStarted)).click();
		}
	}

	public void clickLinkedListGetStartedButton() {
		if (LinkedListGetStarted.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(LinkedListGetStarted)).click();
		}
	}

	public void clickStackGetStartedButton() {
		if (StackGetStarted.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(StackGetStarted)).click();
		}
	}

	public void clickQueueGetStartedButton() {
		if (QueueGetStarted.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(QueueGetStarted)).click();
		}
	}

	public void clickTreeGetStartedButton() {
		if (TreeGetStarted.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(TreeGetStarted)).click();
		}
	}

	public void clickGraphGetStartedButton() {
		if (GraphGetStarted.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(GraphGetStarted)).click();
		}
	}

	public void clickSignOut() {
		if (SignOut.isDisplayed()) {
			SignOut.click();
		}
	}
}
