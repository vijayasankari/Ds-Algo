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
	private WebElement NumpyNinjaLabel;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement DataStructuresDropdown;
	@FindBy(xpath = "//*[@class='dropdown-item']")
	private List<WebElement> DataStructuresDropdownValues;
	@FindBy(linkText = "Register")
	private WebElement Register;
	@FindBy(linkText = "Sign in")
	private WebElement SignIn;
	@FindBy(xpath = "//*[@class='card-body d-flex flex-column']")
	private List<WebElement> Modules;
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

	public void selectDropdownValue(String dropdownValue){
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

	public void clickGetStarted(String moduleName) {
		if (Modules.isEmpty()) {
			System.out.println("List is empty");
		} else {
			for (WebElement item : Modules) {
				WebElement ModuleTitle = item.findElement(By.xpath(".//*[@class='card-title']"));
				if (moduleName.equals(ModuleTitle.getText())) {
					System.out.println("Module name is: " + ModuleTitle.getText());
					WebElement ModulesGetStartedButton = item.findElement(By.xpath(".//a"));
					wait.until(ExpectedConditions.elementToBeClickable(ModulesGetStartedButton)).click();
					return;
				}
			}
		}
	}

	public void clickSignOut() {
		SignOut.click();
	}
}
