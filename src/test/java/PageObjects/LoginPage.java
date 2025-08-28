package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.configReader;
import Utilities.excelReader;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "username")
	WebElement Username;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(css = "input[type=submit][value=Login]")
	WebElement LoginButton;
	@FindBy(linkText = "Register!")
	WebElement RegisterHyperlinkAtEndOfPage;
	@FindBy(xpath = "//a[text()='NumpyNinja']")
	WebElement NumpyNinjaLabel;
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
	@FindBy(linkText = "Register")
	WebElement RegisterHyperLink;
	@FindBy(linkText = "Sign in")
	WebElement SignInHyperLink;
	@FindBy(xpath = "//*[@role='alert']")
	WebElement ErrorMessage;

	public LoginPage(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public String usernameHoverText() {
		// return Username.getAttribute("validationMessage");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String tooltipText = (String) jse.executeScript("return arguments[0].validationMessage;", Username);
		System.out.println(tooltipText);
		return tooltipText;
	}

	public String passwordHoverText() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String tooltipText = (String) jse.executeScript("return arguments[0].validationMessage;", Password);
		System.out.println(tooltipText);
		return tooltipText;
	}

	public void clickLoginButton() {
		if (LoginButton.isDisplayed()) {
			LoginButton.click();
		}
	}

	public void fetchLoginCredentialsAndLogin() {
		String filepath = configReader.getProperty("filepath");
		String SheetName = configReader.getProperty("loginSheetName");
		try {
			Object[][] fetchedData = excelReader.getTestData(filepath, SheetName);
			for (Object[] row : fetchedData) {
				String username = (String) row[0];
				String password = (String) row[1];
				loginAuthentication(username, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginAuthentication(String username, String password) {
		if (Username.isDisplayed() && Username.isDisplayed()) {
			Username.sendKeys(username);
		}
		if (Password.isDisplayed() && Password.isEnabled()) {
			Password.sendKeys(password);
		}
		if (LoginButton.isDisplayed()) {
			LoginButton.click();
		}
	}

	public void clickRegisterHyperLink() {
		if (RegisterHyperLink.isDisplayed()) {
			RegisterHyperLink.click();
		}
	}

	public void clickSignInHyperLink() {
		if (SignInHyperLink.isDisplayed()) {
			SignInHyperLink.click();
		}
	}

	public void clickRegisterHyperLinkAtEndOfPage() {
		if (RegisterHyperlinkAtEndOfPage.isDisplayed()) {
			RegisterHyperlinkAtEndOfPage.click();
		}
	}

	public void clickNumpyNinjaLabel() {
		if (NumpyNinjaLabel.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(NumpyNinjaLabel)).click();
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
			for (WebElement item : dropdownValues) {
				String text = item.getText();
				System.out.println("WebElement Text: '" + text + "' (Length: " + text.length() + ")");
				dropdownValue.add(text);
			}
		}
		return dropdownValue;
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

	public String errorMessage() {
		return ErrorMessage.getText();
	}
}

