package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	private WebDriver driver;
	private LaunchPage launchPage;
	private homePO homePage;
	private RegisterPage register;
	private LoginPage loginPage;
	private DataStructuresPage dataStructuresPage;
	
	private StackPageObject stackPageObject;
	
	// private TryHereEditor tryHereEditor;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LaunchPage getLaunchPage() {
		if (launchPage == null) {
			launchPage = new LaunchPage(driver);
		}
		return launchPage;
	}

	public homePO getHomePage() {
		if (homePage == null) {
			homePage = new homePO(driver);
		}
		return homePage;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}

	public RegisterPage getRegisterPage() {
		if (register == null) {
			register = new RegisterPage(driver);
		}
		return register;
	}

	public DataStructuresPage getDataStructuresPage() {
		if (dataStructuresPage == null) {
			dataStructuresPage = new DataStructuresPage(driver);
		}
		return dataStructuresPage;
	}

	/*
	 * public TryHereEditor getTryHereEditorPage() { if (tryHereEditor == null) {
	 * tryHereEditor = new TryHereEditor(driver); } return tryHereEditor; }
	 */

	public StackPageObject getStackPage() {
		if (stackPageObject==null) {
			stackPageObject=new StackPageObject(driver);
		}
		return stackPageObject;
	}
}
