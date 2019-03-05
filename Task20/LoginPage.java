package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='mailbox:login']")
	private WebElement loginField;

	@FindBy(xpath = "//input[@id='mailbox:password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@class='o-control']")
	private WebElement enterButton;

	@FindBy(xpath = "//a[@id='PH_logoutLink']")
	private WebElement logoutLink;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterData(String login, String password) {
		enterText(loginField, login);
		enterText(passwordField, password);
	}

	public MessagePage clickEnterButton() {
		enterButton.click();
		return new MessagePage(driver);
	}
	

	public boolean isLogoutDisplayed(WebDriver driver) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElements(logoutLink));
		return logoutLink.isDisplayed();
	}

	private void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	


}
