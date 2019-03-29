package patterns;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;
import pages.MessagePage;
import pages.SendMessagePage;

// Facade
public class EmailSender {

	private WebDriver driver;

	public EmailSender(WebDriver driver) {
		this.driver = driver;
	}

	public SendMessagePage sentMessage(Email email, LoginPage loginPage) {
		MessagePage messagePage = loginPage.clickEnterButton();
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Входящие"));
		assertTrue(loginPage.isLogoutDisplayed(driver));
		SendMessagePage sendMessagePage = messagePage.clickCreateMessageButton();
		sendMessagePage.enterRecipientNew(email.getTo());
		sendMessagePage.enterTheme(email.getSubject());
		sendMessagePage.enterMessageText(email.getMessage());
		sendMessagePage.sendButtonClick();
		return sendMessagePage;
	}

}
