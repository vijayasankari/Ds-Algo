package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public void fetchRegistrationDetailsAndRegister(String filepath, String sheetName) {
		//can we fetch the username and password inside this method or it has be in step def
		try {
			List<Map<String, String>> fetchedData = excelReader.getTestData(filepath, sheetName);
			for (Map<String, String> rowData : fetchedData) {
				if ("SuccessfulRegistration".equals(rowData.get("ScenarioName"))) {
					username = rowData.get("Username");
					password = rowData.get("Password");
					passwordConfirmation = rowData.get("Password Confirmation");
					userRegistration(username, password, passwordConfirmation);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			tooltipText = Username.getAttribute("validationMessage");
		}
		if (field.equalsIgnoreCase("password")) {
			tooltipText = Password.getAttribute("validationMessage");
		}
		if (field.equalsIgnoreCase("passwordConfirmation")) {
			tooltipText = PasswordConfirmation.getAttribute("validationMessage");
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
		List<String> dropdownValue = new ArrayList<>();
		if (DataStructuresDropdownValues.isEmpty()) {
			System.out.println("List is empty");
		} else {
			System.out.println(DataStructuresDropdownValues.size());
			for (WebElement item : DataStructuresDropdownValues) {
				String text = item.getText();
				dropdownValue.add(text);
			}
		}
		return dropdownValue;
	}

	public void selectDropdownValue(String dropdownValue) {
		if (DataStructuresDropdownValues.isEmpty()) {
			System.out.println("List is empty");
		} else {
			for (WebElement item : DataStructuresDropdownValues) {
				if (dropdownValue.equalsIgnoreCase(item.getText())) {
					System.out.println(item.getText());
					wait.until(ExpectedConditions.elementToBeClickable(item)).click();
					return;
				}
			}
		}
	}
}
