package PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driverFactory;

public class StackPO {
	WebDriver driver;
	WebDriverWait wait; 
	
	public StackPO(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="btn")WebElement getStarted;
	@FindBy(xpath="//a[text()='Sign in']") WebElement signin;
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@type='submit' and @value='Login']")WebElement login;
	@FindBy(xpath="//a[@href='stack']")WebElement stackGetstartedBtn;
	@FindBy (xpath="//div[@class='navbar-nav']")WebElement dropdown;
	@FindBy(xpath="//div[@class='dropdown-menu']/a[text()='Stack']")WebElement stackDropdown;
	@FindBy(xpath="//a[text()='Operations in Stack']")WebElement operationsStack;
	@FindBy(xpath="//a[text()='Implementation']")WebElement implementationStack;
	@FindBy(xpath="//a[text()='Applications']")WebElement applicationsStack;
	@FindBy(xpath="//a[text()='Try Here']")WebElement tryEditor;
	@FindBy(xpath="///div[@class='input']")WebElement tryEditorBox;
	@FindBy(xpath="//button[text()='Run']")WebElement runButton;
	@FindBy(xpath="//li/a[text()='Operations in Stack']")WebElement operationsStackIn;
	@FindBy(xpath="//li/a[text()='Implementation']")WebElement implementationStackIn;
	@FindBy(xpath="//li/a[text()='Applications']")WebElement applicationStackIn;
	@FindBy(xpath="//a[text()='Practice Questions']")WebElement practiceStack;
	
	public void homegetstarted() {
		getStarted.click();
		
	}
	public void login(String userName, String passwd) {
		signin.click();
		
		username.sendKeys(userName);
		password.sendKeys(passwd);
		login.click();
	}
	public void selectStackDropdown() {
		dropdown.click();
		stackDropdown.click();
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
	
	public void tryEditor() throws InterruptedException{
		tryEditor.click();
		tryEditorBox.sendKeys("System.println(\"hello world\")");
		runButton.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
		
		tryEditorBox.clear();
		tryEditorBox.sendKeys("print(\"Hello\")");
		runButton.click();
		
	}
	
	public void OperationsStackIn() {
		operationsStackIn.click();
	}
	
	public void ImplementationStackIn() {
		implementationStackIn.click();
	}
	
	public void ApplicationStackIn() {
		applicationStackIn.click();
	}
	
	public void PracticeStack() {
		practiceStack.click();
		
	}
	
}
