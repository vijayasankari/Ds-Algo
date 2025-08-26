package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.excelReader;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
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
			tooltipText = Username.getAttribute("validationMessage");
		}
		if (field.equalsIgnoreCase("password")) {
			tooltipText = Password.getAttribute("validationMessage");
		}
		return tooltipText;
	}

	public void clickLoginButton() {
			LoginButton.click();
	}

	public void fetchLoginCredentialsAndLogin(String filepath, String sheetName) {
		try {
			List<Map<String, String>> fetchedData = excelReader.getTestData(filepath, sheetName);
			for (Map<String, String> rowData : fetchedData) {
				if ("SuccessfulLogin".equals(rowData.get("ScenarioName"))) {
					username = rowData.get("Username");
					password = rowData.get("Password");
					loginAuthentication(username, password);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
