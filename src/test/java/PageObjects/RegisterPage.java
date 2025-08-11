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

public class RegisterPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private String filepath;
	private String SheetName;
	public static String username;
	private String password;
	private String passwordConfirmation;

	@FindBy(name = "username")
	WebElement Username;
	@FindBy(name = "password1")
	WebElement Password;
	@FindBy(name = "password2")
	WebElement PasswordConfirmation;
	@FindBy(css = "input[type=submit][value=Register]")
	WebElement RegisterButton;
	@FindBy(linkText = "Login")
	WebElement LoginHyperlink;
	@FindBy(linkText = "Register")
	WebElement RegisterHyperLink;
	@FindBy(linkText = "Sign in")
	WebElement SignInHyperLink;
	@FindBy(xpath = "//*[@role='alert']")
	WebElement WarningMessage;
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

	public RegisterPage(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public void fetchRegistrationDetailsAndRegister() {
		filepath = configReader.getProperty("filepath");
		SheetName = configReader.getProperty("registerSheetName");
		try {
			Object[][] fetchedData = excelReader.getTestData(filepath, SheetName);
			for (Object[] row : fetchedData) {
				username = (String) row[0];
				password = (String) row[1];
				passwordConfirmation = (String) row[2];
				userRegistration(username, password, passwordConfirmation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userRegistration(String username, String password, String passwordConfirmation) {
		if (Username.isDisplayed() && Username.isDisplayed()) {
			Username.sendKeys(username);
		}
		if (Password.isDisplayed() && Password.isEnabled()) {
			Password.sendKeys(password);
		}
		if (PasswordConfirmation.isDisplayed() && PasswordConfirmation.isEnabled()) {
			PasswordConfirmation.sendKeys(passwordConfirmation);
		}
		if (RegisterButton.isDisplayed()) {
			RegisterButton.click();
		}
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

	public String passwordConfirmationHoverText() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String tooltipText = (String) jse.executeScript("return arguments[0].validationMessage;", PasswordConfirmation);
		System.out.println(tooltipText);
		return tooltipText;
	}

	public String warningMessage() {
		return WarningMessage.getText();
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

	public void clickLogInHyperLink() {
		if (LoginHyperlink.isDisplayed()) {
			LoginHyperlink.click();
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
