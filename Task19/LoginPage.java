package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	@FindBy(xpath="//input[@id='username']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//span[@class='bui-button__text']")
	private WebElement continueButton;
	
	@FindBy(xpath="//span[@class='bui-button__text']")
	private WebElement enterButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String login, String password) {
		emailField.sendKeys(login);
		continueButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		passwordField.sendKeys(password);
		enterButton.click();
		return new HomePage(driver);
	}
}
