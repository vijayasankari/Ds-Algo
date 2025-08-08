package PageObjects;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import DriverFactory.driverFactory;
import Utilities.excelReader;

public class StackPageObject {
	WebDriver driver;
	WebDriverWait wait; 
	excelReader excelData;
	String[] invCode;
	String[] vCode;
	
	public StackPageObject(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="btn")WebElement getStarted;
	//@FindBy(xpath="//a[text()='Sign in']") WebElement signin;
	@FindBy(linkText="Sign in") WebElement signin;
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@type='submit' and @value='Login']")WebElement login;
	@FindBy(xpath="//a[@href='stack']")WebElement stackGetstartedBtn;
	@FindBy (xpath="//div[@class='navbar-nav']")WebElement dropdown;
	//@FindBy(xpath="//div[@class='dropdown-menu']/a[text()='Stack']")WebElement stackDropdown;
	@FindBy(xpath="//div/a[@class='dropdown-item' and @href='/stack']")WebElement stackDropdown;
	@FindBy(xpath="//ul/a[@href='operations-in-stack']")WebElement operationsStack;
	@FindBy(xpath="//ul/a[@href='implementation']")WebElement implementationStack;
	@FindBy(xpath="//ul/a[@href='stack-applications']")WebElement applicationsStack;
	@FindBy(linkText="Try here>>>")WebElement tryEditor;
	@FindBy(xpath="//div[@class='input']/div/div/textarea]")WebElement tryEditorBox;
	@FindBy(xpath="//button[@type='button']")WebElement runButton;
	@FindBy(xpath="//li/a[text()='Operations in Stack']")WebElement operationsStackIn;
	@FindBy(xpath="//li/a[text()='Implementation']")WebElement implementationStackIn;
	@FindBy(xpath="//li/a[text()='Applications']")WebElement applicationStackIn;
	@FindBy(xpath="//a[text()='Practice Questions']")WebElement practiceStack;
	
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
	
	public boolean tryHereDisplayed() {
		return tryEditor.isDisplayed();
	}
	public boolean tryHereEnabled() {
		return tryEditor.isEnabled();
	}
	
	public void tryEditor() {
		tryEditor.click();
		
	}
	public void tryEditorGetInvalidCode() throws IOException {
		//ExcelData.readTestData();
		//invCode=ExcelData.getExcelData("Invalid");
		
		//for (String invalidCode:invCode) {
			//System.out.println("Invaliddddd code:"+invalidCode);
	//}
	}
	public void tryEditorInvalidcode(int i) throws InterruptedException, IOException{
		tryEditorGetInvalidCode();
		int size=invCode.length;
		if (i<size) {
			tryEditorBox.sendKeys(invCode[i]);
			Thread.sleep(10);
			runButton.click();
		}
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
	
	public void tryEditorGetValidCode() throws IOException {
		//ExcelData.readTestData();
		//vCode=ExcelData.getExcelData("valid");
		
		//for (String validCode:vCode) {
			//System.out.println("Invaliddddd code:"+vCode);
		//}
	}
	public void tryEditorValidcode(int i) throws InterruptedException, IOException {
		tryEditorGetValidCode();
		int size=vCode.length;
		if (i<size) {
		tryEditorBox.sendKeys(vCode[i]);
		Thread.sleep(10);
		runButton.click();
		}
		//tryEditorBox.sendKeys("print(\"hello world\")");
	}
	public void tryEditorValidcodeoutput() {
		System.out.println("Screenshot of output taken");
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
