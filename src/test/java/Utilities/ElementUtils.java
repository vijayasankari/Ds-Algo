package Utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private WebDriverWait wait;
	private WebDriver driver;

	public ElementUtils(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public int countOfModules(List<WebElement> element) {
		if (element.isEmpty()) {
			LoggerReader.warn("List is empty");
			return 0;
		} else {
			int ModuleCount = element.size();
			return ModuleCount;
		}
	}

	public List<String> fetchValuesAsString(List<WebElement> element) {
		List<String> values = new ArrayList<>();
		if (element.isEmpty()) {
			LoggerReader.warn("List is empty");
		} else {
			for (WebElement item : element) {
				String text = item.getText();
				values.add(text);
			}
		}
		return values;
	}
	
	public void selectByText(String text, List<WebElement> element) {
		if (element.isEmpty()) {
			LoggerReader.warn("List is empty");
		} else {
			for (WebElement item : element) {
				if (text.equalsIgnoreCase(item.getText())) {
					wait.until(ExpectedConditions.elementToBeClickable(item)).click();
					return;
				}
			}
		}
	}

	public void clickModuleGetStartedButton(String moduleName, List<WebElement> modules) {
		if (modules.isEmpty()) {
			LoggerReader.warn("List is empty");
		} else {
			for (WebElement item : modules) {
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

	public String hoverText(WebElement element) {
		return element.getAttribute("validationMessage");
	}

	public boolean TopicsCoveredHeader(WebElement topicsCoveredHeader) {

		String text = topicsCoveredHeader.getText();

		if (text.equalsIgnoreCase("Topics Covered")) {

			// log:"Topics Covered" is present in the webpage
			System.out.println("Topics Covered header is present in the webpage");
			return true;

		} else {
			// log:"Topics Covered" header is missing
			System.out.println("Topics Covered header is not present in the webpage");
			return false;
		}

	}

	public boolean TopicsCovered(String module, String topic, List<WebElement> listOfTopicsCovered,
			boolean linkformatTest) {

		int j = 0;
		int i = 0;

		for (WebElement moduleTopic : listOfTopicsCovered) {
			// WebElement moduleTopic=listOfTopicsCovered.get(i);
			String moduleTopicText = moduleTopic.getText();

			if (moduleTopicText.equalsIgnoreCase(topic)) {

				if (linkformatTest == true) {
					if (moduleTopic.getTagName().equalsIgnoreCase("a")) {
						// log:"topic" is a link
						System.out.println(topic + " topic in " + module + " module is in link format");
						j = 1;
						return true;
					} else {
						// log:"Stacktopic" is not a link
						System.out.println(topic + " topic in " + module + " module is not in link format");
						return false;
					}
				}

				// log:"Topic is present in the webpage
				System.out.println("In " + module + " module \"" + topic + " \" topic is present in the webpage");
				j = 1;
				return true;
			}
		}
		if ((i == listOfTopicsCovered.size()) && j == 0)
			// log:"Stack Topic" is not present in the webpage
			System.out.println("In " + module + " module " + topic + " topic is not present in the webpage");

		return false;
	}

	public void ModuleTopicLinks(String topic, List<WebElement> listOfTopicsCovered) {

		int i = 0;
		System.out.println(topic);
		for (i = 0; i < listOfTopicsCovered.size(); i++) {
			WebElement moduleTopic = listOfTopicsCovered.get(i);
			String moduleTopicText = moduleTopic.getText();
			System.out.println(moduleTopicText);

			if (moduleTopicText.equalsIgnoreCase(topic)) {
				i = listOfTopicsCovered.size();
				moduleTopic.click();
			}
		}

	}

	public String tryEditorcode(String scenarioName, String codeType, String topic,
			List<WebElement> listOfTopicsCovered, WebElement tryEditor) throws Exception {

		String code = null;
		ModuleTopicLinks(topic, listOfTopicsCovered);
		tryEditor.click();
		List<Map<String, String>> scenarioTestData = excelReader.getTestData(scenarioName);

		for (Map<String, String> scenarioRowData : scenarioTestData) {

			System.out.println(scenarioRowData.get("CodeType"));
			if (codeType.equals(scenarioRowData.get("CodeType"))) {

				code = scenarioRowData.get("Code");
				System.out.println(code);

			}
		}

		return code;
	}

}
