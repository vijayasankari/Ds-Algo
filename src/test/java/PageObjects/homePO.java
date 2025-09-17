package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ElementUtils;

public class homePO {

	private WebDriver driver;
	private WebDriverWait wait;
	private ElementUtils elementUtils;

	@FindBy(xpath = "//a[text()='NumpyNinja']")
	private WebElement NumpyNinjaLabel;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement DataStructuresDropdown;
	@FindBy(xpath = "//*[@class='dropdown-item']")
	private List<WebElement> DataStructuresDropdownValues;
	@FindBy(xpath = "//*[@class = 'col']")
	private List<WebElement> ModuleCards;
	@FindBy(linkText = "Register")
	private WebElement Register;
	@FindBy(linkText = "Sign in")
	private WebElement SignIn;
	@FindBy(xpath = "//*[@role='alert']")
	private WebElement WarningMessage;
	@FindBy(linkText = "Sign out")
	private WebElement SignOut;
	@FindBy(xpath = "//a[text()='Sign out']/preceding-sibling::a[1]")
	private WebElement FetchUsername;

	public homePO(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
		elementUtils = new ElementUtils(driver);
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public String messageToUser() {
		return wait.until(ExpectedConditions.elementToBeClickable(WarningMessage)).getText();
	}

	public void clickNumpyNinjaLabel() {
		NumpyNinjaLabel.click();
	}

	public void clickRegisterLink() {
		Register.click();
	}

	public void clickSignInLink() {
		SignIn.click();
	}

	public void clickDataStructuresDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(DataStructuresDropdown)).click();
	}

	public int numberOfModulesCards() {
		return elementUtils.countOfModules(ModuleCards);
	}

	public int countOfModulesInDropdown() {
		return elementUtils.countOfModules(DataStructuresDropdownValues);
	}

	public List<String> fetchDataStructuresDropdownValues() {
		return elementUtils.fetchValuesAsString(DataStructuresDropdownValues);
	}

	public void selectDropdownValue(String dropdownValue) {
		elementUtils.selectByText(dropdownValue, DataStructuresDropdownValues);
	}

	public void clickGetStarted(String moduleName) {
		elementUtils.clickModuleGetStartedButton(moduleName, ModuleCards);
	}

	public void clickSignOut() {
		SignOut.click();
	}
}
