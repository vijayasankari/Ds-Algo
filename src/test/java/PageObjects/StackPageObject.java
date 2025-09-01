package PageObjects;


import java.awt.AWTException;
import java.io.IOException;
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



import Hooks.Hooks;

import Utilities.Screenshot;
import Utilities.excelReader;




public class StackPageObject {
	WebDriver driver;
	WebDriverWait wait; 
	private PageObjectManager pageObjectManager;
	
	

	
	public StackPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		pageObjectManager = new PageObjectManager(Hooks.driver);
		
	}
	
	
	@FindBy(xpath="//a[@href='stack']")private WebElement stackGetstartedBtn;
	@FindBy (xpath="//div[@class='navbar-nav']")private WebElement dropdownBtn;
	@FindBy(xpath="//div/a[@class='dropdown-item']")private List<WebElement> dropdownItems;
	
	@FindBy (xpath="//p[@class='bg-secondary text-white']") private WebElement topicsCoveredHeader;
	//@FindBy(xpath="//a[@class='list-group-item']")private List<WebElement> stackTopicsList;
	
	@FindBy(linkText="Try here>>>")private WebElement tryEditor;
	@FindBy(xpath="//textarea[@tabindex='0']")private WebElement tryEditorBox;
	@FindBy(xpath="//button[@type='button']")private WebElement runButton;


			
	
	public String getTitleCurrentPage() {
		return driver.getTitle();
	}
	
	
	public boolean StackTopicCoveredHeader() {
		
		boolean presenceOfTopicCoveredHdr=pageObjectManager.getElementUtilsPage().TopicsCoveredHeader();
		return presenceOfTopicCoveredHdr;
		
	}
	
	public boolean StackTopicList(String stacktopic) {
		
		boolean presenceOfTopics=pageObjectManager.getElementUtilsPage().TopicsCovered("Stack",stacktopic,false);
		return 	presenceOfTopics;
		
	}
	
	public boolean stackTopicLinksFormat(String stackTopic) {
		
		return pageObjectManager.getElementUtilsPage().TopicsCovered("Stack",stackTopic, true);
		
	}
	
	
	public void StackTopicLinksClickAction(String stackTopic) {
		
		pageObjectManager.getElementUtilsPage().ModuleTopicLinks(stackTopic);
			
	}
		
	public boolean tryHereDisplayed() {
		return tryEditor.isDisplayed();
	}

	public void tryEditor() {
		tryEditor.click();
		
	}
	public boolean runBtnDisplayed() {
		return runButton.isDisplayed();
	}
	public boolean runBtnEnabled() {
		return runButton.isEnabled();
	}
	
	public void tryEditorcode(String scenarioName,String codeType, String topic) throws Exception{
		String code=pageObjectManager.getElementUtilsPage().tryEditorcode(scenarioName, codeType, topic);
		if(code!=null) {
		Actions actions=new Actions(driver);
		actions.moveToElement(tryEditorBox).sendKeys(code).perform();
				Thread.sleep(10);
				wait.until(ExpectedConditions.elementToBeClickable(runButton)).click();
				System.out.println("Run button clicked");
		}
		else
			System.out.println("Code String value is null");				
			}

	
	public boolean tryEditorInvalidcodeError()throws InterruptedException {
		try
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(5000);
			
			alert.accept();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	
	}
	

	public void tryEditorValidcodeoutput(String Page) throws IOException, AWTException, Exception {
		
		Screenshot.takeScreenshot(Page);
	}
	
	
}
