package PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ElementUtils;
import Utilities.excelReader;

public class RegisterPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private ElementUtils elementUtils;
	public static String username;
	private String password;
	private String passwordConfirmation;

	@FindBy(name = "username")
	private WebElement Username;
	@FindBy(name = "password1")
	private WebElement Password;
	@FindBy(name = "password2")
	private WebElement PasswordConfirmation;
	@FindBy(xpath = "//input[@value = 'Register']")
	private WebElement RegisterButton;
	@FindBy(linkText = "Login")
	private WebElement LoginHyperlink;
	@FindBy(linkText = "Register")
	private WebElement RegisterHyperLink;
	@FindBy(linkText = "Sign in")
	private WebElement SignInHyperLink;
	@FindBy(xpath = "//*[@role='alert']")
	private WebElement WarningMessage;
	@FindBy(xpath = "//a[text()='NumpyNinja']")
	private WebElement NumpyNinjaLabel;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement DataStructuresDropdown;
	@FindBy(xpath = "//*[@class='dropdown-item']")
	private List<WebElement> DataStructuresDropdownValues;

	public RegisterPage(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
		elementUtils  = new ElementUtils(driver);
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public void fetchRegistrationDetailsAndRegister(String scenarioName) {
		List<Map<String, String>> registrationDetails = null;
		try {
			registrationDetails = excelReader.getTestData(scenarioName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Map<String, String> registrationData : registrationDetails) {
					username = registrationData.get("Username");
					password = registrationData.get("Password");
					passwordConfirmation = registrationData.get("Password Confirmation");
					userRegistration(username, password, passwordConfirmation);
		}
	}

	public void userRegistration(String username, String password, String passwordConfirmation) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		PasswordConfirmation.sendKeys(passwordConfirmation);
		RegisterButton.click();
	}

	public String hoverText(String field) {
		String tooltipText = null;
		if (field.equalsIgnoreCase("username")) {
			tooltipText = elementUtils.hoverText(Username);
		}
		if (field.equalsIgnoreCase("password")) {
			tooltipText = elementUtils.hoverText(Password);
		}
		if (field.equalsIgnoreCase("passwordConfirmation")) {
			tooltipText = elementUtils.hoverText(PasswordConfirmation);
		}
		return tooltipText;
	}

	public String warningMessage() {
		return WarningMessage.getText();
	}

	public void clickRegisterHyperLink() {
		RegisterHyperLink.click();
	}

	public void clickSignInHyperLink() {
		SignInHyperLink.click();
	}

	public void clickLogInHyperLink() {
		LoginHyperlink.click();
	}

	public void clickNumpyNinjaLabel() {
		wait.until(ExpectedConditions.elementToBeClickable(NumpyNinjaLabel)).click();
	}

	public void clickDataStructuresDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(DataStructuresDropdown)).click();
	}

	public List<String> fetchDataStructuresDropdownValues() {
		return elementUtils.fetchValuesAsString(DataStructuresDropdownValues);
	}

	public void selectDropdownValue(String dropdownValue) {
		elementUtils.selectByText(dropdownValue, DataStructuresDropdownValues);
	}
}
