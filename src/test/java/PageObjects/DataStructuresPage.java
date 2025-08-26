package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataStructuresPage {

	private WebDriver driver;
	private WebDriverWait wait;

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

	public DataStructuresPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public String getTitleCurrentPage() {
		return driver.getTitle();
	}

	public void clickTimeComplexityLink() {
		TimeComplexityLink.click();
	}

	public void clickTryHereButton() {
		wait.until(ExpectedConditions.elementToBeClickable(TryHereButton)).click();
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

}
