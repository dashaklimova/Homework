package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePage {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class='js-item-checkbox b-datalist__item__cbx']")
	private List<WebElement> messagesChekBoxes;

	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[3]/div")
	private WebElement spamButton;

	@FindBy(xpath = "//button[@data-id='approve']")
	private WebElement approveSpamButton;
	
	@FindBy(xpath = "//div[@data-id='950']")   
	private WebElement spamField;
	
	@FindBy(xpath ="//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a/span")
	private WebElement createMessageButton;
	
	@FindBy(xpath ="//div[@data-bem='b-flag']")
	private List<WebElement> messagesFlags;

	public MessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void chooseFirstMessage() {
		messagesChekBoxes.get(0).click();
	}

	public void clickSpamButton() {
		spamButton.click();
	}

	public void clickApproveSpamButton() {
		new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(approveSpamButton));
		approveSpamButton.click();
	}
	
	public void clickSpamField() {
		new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(spamField));
		spamField.click();
	}
	

	public boolean isMessageListEmty() {
		return messagesChekBoxes.isEmpty();
	}
	
	public SendMessagePage clickCreateMessageButton() {
		createMessageButton.click();
		return new SendMessagePage(driver);
	}

	public void chooseSeveralMessagesFlags() {
		messagesFlags.get(0).click();
		messagesFlags.get(1).click();
		messagesFlags.get(2).click();
	}

}
