package PageObjects;


import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import DriverFactory.driverFactory;
import Utilities.configReader;
import Utilities.excelReader;
import io.cucumber.datatable.DataTable;
import Utilities.Screenshot;

public class StackPageObject {
	WebDriver driver;
	WebDriverWait wait; 
	

	
	public StackPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	
	@FindBy(xpath="//a[@href='stack']")private WebElement stackGetstartedBtn;
	@FindBy (xpath="//div[@class='navbar-nav']")private WebElement dropdownBtn;
	@FindBy(xpath="//div/a[@class='dropdown-item']")private List<WebElement> dropdownItems;
	@FindBy (xpath="//div/p")private List<WebElement> stackPageTopics;
	@FindBy(xpath="//ul/a[@class='list-group-item']")private List<WebElement> stackTopicsList;
	
	
	@FindBy(linkText="Operations in Stack")private WebElement operationsInStack;
	@FindBy(linkText="Implementation")private WebElement implementationStack;
	@FindBy(linkText="Applications")private WebElement applicationsStack;
	@FindBy(linkText="Try here>>>")private WebElement tryEditor;
	//@FindBy(xpath="//textarea[@id='editor']")WebElement tryEditorBox;
	@FindBy(xpath="//textarea[@tabindex='0']")private WebElement tryEditorBox;
	@FindBy(xpath="//button[@type='button']")private WebElement runButton;
	@FindBy(className="navbar-brand")private WebElement numpyNinjaBtn;
	@FindBy(linkText = "Sign out")private WebElement logoutBtn;
	@FindBy(xpath="//*[@role='alert']")private WebElement logoutMsg;
	
	public String getTitleCurrentPage() {
		return driver.getTitle();
	}
	
	public void selectStackDropdown() {
		dropdownBtn.click();
		//stackDropdown.click();
	}
	
	public void StackGetStartedBtn() {
		stackGetstartedBtn.click();
	}
	
	public void StackTopicsCoveredPart() {
		for(int i=0;i<stackPageTopics.size();i++) {
			WebElement stackPageTopic=stackPageTopics.get(i);
			String text=stackPageTopic.getText();
			System.out.println(text+"stackPageTopics");
			if (text.equalsIgnoreCase("Topics Covered")) {
				i=stackPageTopics.size();
//			log:"Topics Covered" is present in the webpage
			System.out.println("Topics Covered header is present in the webpage");
						}
			else
				//log:"Topics Covered" header is missing
				System.out.println("Topics Covered header is not present in the webpage");
		}
				
	}
	
		
			
	
	public void StackTopicList(String stacktopic) {
		int j=0;
		for(int i=0;i<stackTopicsList.size();i++) {
			WebElement stackTopic=stackTopicsList.get(i);
			String stackTopicText=stackTopic.getText();
			
			if (stackTopicText.equalsIgnoreCase(stacktopic)) {
				i=stackTopicsList.size();
				//log:"stackTopic is present in the webpage
				System.out.println(stacktopic+" is present in the webpage");
				j=1;
			}
			else if ((i==stackTopicsList.size())&&j==0)
				//log:"Stack Topic" is not present in the webpage
				System.out.println(stacktopic+" is not present in the webpage");
				
			
		}
					
	}
	
	public boolean stackTopicLinks(String stacktopic) {
	int j=0;
		for(int i=0;i<stackTopicsList.size();i++) {
			WebElement stackTopic=stackTopicsList.get(i);
			String stackTopicText=stackTopic.getText();
			
			if (stackTopicText.equalsIgnoreCase(stacktopic)) {
				i=stackTopicsList.size();
				if (stackTopic.getTagName().equalsIgnoreCase("a")) {
					//log:"Stacktopic" is a link
					System.out.println(stacktopic+"topic in Stack is a link");
					j=1;
					return true;
				}
				else {
					//log:"Stacktopic" is not a link
					System.out.println(stackTopic.getTagName()+" "+stacktopic+"topic in Stack is not a link");
					return false;
				}
				
			}
			else if((i==stackTopicsList.size())&&j==0)
				//log:"Stack Topic" is not present in the webpage
				System.out.println(stacktopic+" is not present in the webpage");
			return false;
		}
		
		return false;
	}
	
	
	public void StackTopic(String stackTopic) {
		switch(stackTopic)
		{
		case "Operations in Stack":
			operationsInStack.click();
			break;
		case "Implementation":
			implementationStack.click();
			break;
		case "Applications":
			applicationsStack.click();
			break;
			
		}
			
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
	
	public void tryEditorcode(String code) throws InterruptedException, IOException{
		 
			tryEditorBox.sendKeys(code);
			Thread.sleep(10);
			if (runBtnEnabled())
			runButton.click();
		}
	
		
		//tryEditorBox.sendKeys("System.println(\"hello world\")");
		//Thread.sleep(10);
		//runButton.click();
		
		
	
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
	
	public void getdropdownItems(String dropdownselect) {
		if (dropdownItems.isEmpty()) {
			System.out.println("List is empty");
			//Log here
		} 
		else {
			
			dropdownBtn.click();
			/* PageFactory.initElements(driver,this); */
			this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			for (int i=0;i<dropdownItems.size();i++) {
			WebElement dropdownItem=dropdownItems.get(i);
				String text = dropdownItem.getText();
				System.out.println("dropdownitem is"+dropdownItem.getText());
				System.out.println("dropdownselect is"+dropdownselect);
				if( dropdownselect.equalsIgnoreCase(text)) {
					i=dropdownItems.size();
					dropdownItem.click();
					//Actions action=new Actions(driver);
					//action.moveToElement(dropdownItem).perform();
					//action.click(dropdownItem).perform();
					//wait.until(ExpectedConditions.elementToBeClickable(dropdownItem)).click();
					System.out.println(text+" dropdownitem click");
				}
				
						}
		}
	}

	
	public void homePage() {
		numpyNinjaBtn.click();
		
	}
	
	public void logoutPage() {
		logoutBtn.click();
		 
	}
	public String logoutMsg() {
		return logoutMsg.getText();
	}
	
}
