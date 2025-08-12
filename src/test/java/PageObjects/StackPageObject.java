package PageObjects;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import DriverFactory.driverFactory;
import Utilities.configReader;
import Utilities.excelReader;

public class StackPageObject {
	WebDriver driver;
	WebDriverWait wait; 
	excelReader excelData;

	
	public StackPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(className="btn")WebElement getStarted;
	//@FindBy(xpath="//a[text()='Sign in']") WebElement signin;
	@FindBy(linkText="Sign in") WebElement signin;
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@type='submit' and @value='Login']")WebElement login;
	@FindBy(xpath="//a[@href='stack']")WebElement stackGetstartedBtn;
	@FindBy (xpath="//div[@class='navbar-nav']")WebElement dropdownBtn;
	//@FindBy(xpath="//div[@class='dropdown-menu']/a[text()='Stack']")WebElement stackDropdown;
	
	@FindBy(xpath="//div/a[@class='dropdown-item']")List<WebElement> dropdownItems;
	//List<WebElement> dropdownItems=dropdownBtn.findElements(By.className("dropdown-item"));

	@FindBy(xpath="//div/a[@class='dropdown-item' and text()='Arrays']")WebElement arrayDropdown;
	@FindBy(xpath="//div/a[@class='dropdown-item' and text()='Stack']")WebElement stackDropdown;
	@FindBy(xpath="//div/a[@class='dropdown-item' and text()='Linked List']")WebElement linkedListDropdown;
	@FindBy(xpath="//div/a[@class='dropdown-item' and text()='Queue']")WebElement queueDropdown;
	@FindBy(xpath="//div/a[@class='dropdown-item' and text()='Tree']")WebElement treeDropdown;
	@FindBy(xpath="//div/a[@class='dropdown-item' and text()='Graph']")WebElement graphDropdown;
	
	@FindBy(xpath="//ul/a[@href='operations-in-stack']")WebElement operationsStack;
	@FindBy(xpath="//ul/a[@href='implementation']")WebElement implementationStack;
	@FindBy(xpath="//ul/a[@href='stack-applications']")WebElement applicationsStack;
	@FindBy(linkText="Try here>>>")WebElement tryEditor;
	@FindBy(xpath="//div[@class='input']/div/div/textarea")WebElement tryEditorBox;
	@FindBy(xpath="//button[@type='button']")WebElement runButton;
	@FindBy(className="navbar-brand")WebElement numpyNinjaBtn;
	@FindBy(linkText = "Sign out")WebElement logoutBtn;
	
	public String getTitleCurrentPage() {
		return driver.getTitle();
	}
	public void homegetstarted() {
		getStarted.click();
		
	}
	public void login(String userName, String passwd) {
		signin.click();
		
		username.sendKeys(userName);
		password.sendKeys(passwd);
		login.click();
		System.out.println("dropdown" +dropdownBtn);
	}
	public void selectStackDropdown() {
		dropdownBtn.click();
		//stackDropdown.click();
	}
	public void StackGetStartedBtn() {
		stackGetstartedBtn.click();
	}
	public void OperationsInStack() {
		operationsStack.click();
	}
	
	public void ImplementationStack() {
		implementationStack.click();
	}
	
	public void ApplicationsStack() {
		applicationsStack.click();
	}
	
	public boolean tryHereDisplayed() {
		return tryEditor.isDisplayed();
	}
	public boolean tryHereEnabled() {
		return tryEditor.isEnabled();
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
		
		
	
	public void tryEditorInvalidcodeError()throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(5000);
		alert.accept();
	}
	

	public void tryEditorValidcodeoutput() {
		System.out.println("Screenshot of output taken");
	}
	
	
	public void arrayFromdropdown() {
		dropdownBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(arrayDropdown)).click();
	}
	
	public void stackFromdropdown() {
		dropdownBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(stackDropdown)).click();
	}
	
	public void linkedListFromdropdown() {
		dropdownBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(linkedListDropdown)).click();
	}
	
	public void queueFromdropdown() {
		dropdownBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(queueDropdown)).click();
	}
	
	
	public void treeFromdropdown() {
		dropdownBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(treeDropdown)).click();
	}
	
	public void graphFromdropdown() {
		dropdownBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(graphDropdown)).click();
	}
	
	public void homePage() {
		numpyNinjaBtn.click();
		
	}
	
	public void logoutPage() {
		logoutBtn.click();
	}
	
}
