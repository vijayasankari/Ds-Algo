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

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private ElementUtils elementUtils;
	private String username;
	private String password;

	@FindBy(name = "username")
	private WebElement Username;
	@FindBy(name = "password")
	private WebElement Password;
	@FindBy(xpath = "//input[@value = 'Login']")
	private WebElement LoginButton;
	@FindBy(linkText = "Register!")
	private WebElement RegisterHyperlinkAtEndOfPage;
	@FindBy(xpath = "//a[text()='NumpyNinja']")
	private WebElement NumpyNinjaLabel;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement DataStructuresDropdown;
	@FindBy(xpath = "//*[@class='dropdown-item']")
	private List<WebElement> DataStructuresDropdownValues;
	@FindBy(linkText = "Register")
	private WebElement RegisterHyperLink;
	@FindBy(linkText = "Sign in")
	private WebElement SignInHyperLink;
	@FindBy(xpath = "//*[@role='alert']")
	private WebElement ErrorMessage;

	public LoginPage(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
		elementUtils = new ElementUtils(driver);
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public String errorMessage() {
		return ErrorMessage.getText();
	}

	public String hoverText(String field) {
		String tooltipText = null;
		if (field.equalsIgnoreCase("username")) {
			tooltipText = elementUtils.hoverText(Username);
		}
		if (field.equalsIgnoreCase("password")) {
			tooltipText = elementUtils.hoverText(Password);
		}
		return tooltipText;
	}

	public void clickLoginButton() {
		LoginButton.click();
	}

	public void fetchLoginCredentialsAndLogin(String scenarioName) {
		List<Map<String, String>> loginDataList = null;
		try {
			loginDataList = excelReader.getTestData(scenarioName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (loginDataList != null) {
			for (Map<String, String> loginData : loginDataList) {
				username = loginData.get("Username");
				password = loginData.get("Password");
				loginAuthentication(username, password);
			}
		} else {
			System.out.println("loginDataList is null");
		}
	}

	public void loginAuthentication(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
	}

	public void clickRegisterHyperLink() {
		RegisterHyperLink.click();
	}

	public void clickSignInHyperLink() {
		SignInHyperLink.click();
	}

	public void clickRegisterHyperLinkAtEndOfPage() {
		RegisterHyperlinkAtEndOfPage.click();
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
