package PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ElementUtils;
import Utilities.LoggerReader;
import Utilities.excelReader;

public class DataStructuresPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private ElementUtils elementUtils;
	private String output;
	private String alertMessage;
	Actions actions;

	@FindBy(xpath = "//*[@class = 'list-group-item']")
	private List<WebElement> TopicsPresent;
	@FindBy(linkText = "Time Complexity")
	private WebElement TimeComplexityLink;
	@FindBy(linkText = "Try here>>>")
	private WebElement TryHereButton;
	@FindBy(linkText = "Practice Questions")
	private WebElement PracticeQuestionsLink;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement DataStructuresDropdown;
	@FindBy(xpath = "//*[@class='dropdown-item']")
	private List<WebElement> DataStructuresDropdownValues;
	@FindBy(xpath = "//a[text()='Sign out']/preceding-sibling::a[1]")
	private WebElement UsernameDisplayed;
	@FindBy(xpath = "//*[@type='button'][text()='Run']")
	private WebElement RunButton;
	@FindBy(className = "CodeMirror-code")
	private WebElement TextArea;
	@FindBy(xpath = "//*[@id = 'output']")
	private WebElement ConsoleOutput;

	public DataStructuresPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		elementUtils = new ElementUtils(driver);
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public List<String> topicsPresent() {
		return elementUtils.fetchValuesAsString(TopicsPresent);
	}

	public boolean linkFormatOrNot() {
		for (WebElement topic : TopicsPresent) {
			if (!topic.getTagName().equalsIgnoreCase("a")) {
				System.out.println(topic.getText() + " is not in link format");
				return false;
			}
		}
		return true;
	}

	public void clickTimeComplexityLink() {
		TimeComplexityLink.click();
	}

	public void clickTryHereButton() {
		wait.until(ExpectedConditions.elementToBeClickable(TryHereButton)).click();
	}

	public boolean runButtonDisplay() {
		return RunButton.isDisplayed();
	}

	public void clickPracticeQuestionsLink() {
		PracticeQuestionsLink.click();
	}

	public void clickUsernameLink() {
		UsernameDisplayed.click();
	}

	public void clickDataStructuresDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(DataStructuresDropdown)).click();
	}

	public void selectDropdownValue(String dropdownValue) {
		elementUtils.selectByText(dropdownValue, DataStructuresDropdownValues);
	}

	public void clickRunButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(RunButton)).click();
	}

	public void enterCode(String code) {
		actions.moveToElement(TextArea).sendKeys(code).perform();
	}

	public void fetchCodeAndRun(String codetype, String scenarioName) {
		try {
			List<Map<String, String>> tryeditorDataList = excelReader.getTestData(scenarioName);
			for (Map<String, String> tryEditorCodeTypeData : tryeditorDataList) {
				if (codetype.equalsIgnoreCase(tryEditorCodeTypeData.get("CodeType"))) {
					LoggerReader.info("Code Matched");
					Thread.sleep(1000);
					enterCode(tryEditorCodeTypeData.get("Code"));
					Thread.sleep(1000);
					clickRunButton();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String fetchResult(String expectedOutput) {

		switch (expectedOutput) {
		case "Alert Message":
			Alert alert = null;
			alert = wait.until(ExpectedConditions.alertIsPresent());
			alertMessage = alert.getText();
			System.out.println(alertMessage);
			alert.accept();
			// result = "Alert Message is " + alertMessage;
			return alertMessage;
		case "Console Output":
			output = ConsoleOutput.getText();
			// result = "Console Output is " + output;
			return output;
		default:
			return "Unhandled error";
		}
	}
}
