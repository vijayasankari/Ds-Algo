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

import Utilities.excelReader;

public class TryEditorPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private String output;
	private String alertMessage;
	private String result;
	Actions actions;

	@FindBy(xpath = "//*[@type='button'][text()='Run']")
	private WebElement RunButton;
	@FindBy(className = "CodeMirror-code")
	private WebElement TextArea;
	@FindBy(xpath = "//*[@id = 'output']")
	private WebElement ConsoleOutput;

	public TryEditorPage(WebDriver driver) { // Pass the driver instance to the constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public void clickRunButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(RunButton)).click();
	}

	public void enterCode(String code) {
		actions.moveToElement(TextArea).sendKeys(code).perform();
	}

	public void fetchCodeAndRun(String codetype, String filepath, String sheetName) {
		try {
			List<Map<String, String>> fetchedData = excelReader.getTestData(filepath, sheetName);
			for (Map<String, String> rowData : fetchedData) {
				if ("TryEditorValidation".equals(rowData.get("ScenarioName"))) {
					String code = rowData.get(codetype);
					enterCode(code);
					clickRunButton();
					System.out.println("Run button clicked");
					return;
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
			result = "Alert Message is " + alertMessage;
			return result;
		case "Console Output":
			output = ConsoleOutput.getText();
			result = "Console Output is " + output;
			return result;
		default:
			return "Unhandled error";
		}
	}
}
