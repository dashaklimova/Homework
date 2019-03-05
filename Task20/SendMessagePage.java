package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMessagePage {
	private WebDriver driver;

	@FindBy(xpath = "//textarea[@data-original-name='To']")
	private WebElement toWhomField;

	@FindBy(xpath = "//input[@class='b-input']")
	private WebElement themeField;

	@FindBy(xpath = "//body[@id='tinymce']")
	private WebElement messageTextField;

	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div/span")
	private WebElement sendButton;

	@FindBy(xpath = "//iframe[contains(@id,'composeEditor_ifr')]")
	private WebElement frameElement;

	@FindBy(className="message-sent__title")
	private WebElement messageSentMessage;
	
	public SendMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterRecipients(String recipients) {
		for (int i = 0; i < recipients.length(); i++) {
			char letter = recipients.charAt(i);
			String stringLetter = new StringBuilder().append(letter).toString();
			toWhomField.sendKeys(stringLetter);
		}
	}

	public void enterTheme(String themeText) {
		themeField.sendKeys(themeText);
	}

	public void enterMessageText(String messageText) {
		driver.switchTo().frame(frameElement);
		messageTextField.sendKeys(messageText);
		driver.switchTo().defaultContent();
	}

	public void sendButtonClick() {
		sendButton.click();
	}
	
	public boolean messageIsSent() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(messageSentMessage));
		return messageSentMessage.isDisplayed();
	}
}
