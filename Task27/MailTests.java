package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import patterns.DriverFactory;
import patterns.Email;
import patterns.EmailBuilder;
import patterns.EmailSender;
import enums.Browser;
import helpers.DatabaseHelper;
import pages.LoginPage;
import pages.MessagePage;
import pages.SendMessagePage;

public class MailTests {
	private WebDriver driver;
	private LoginPage loginPage;
	private MessagePage messagePage;
	private SendMessagePage sendMessagePage;
	private DatabaseHelper databaseHelper;
	private String subject = "I am subject";
	private String message = "I am an email body";

	@Before
	public void setUp() throws Exception {
		databaseHelper = new DatabaseHelper();
		ArrayList<String> credentialPair = databaseHelper.getCredentials().get(0);
		// factory method and singleton patterns are used here
		driver = DriverFactory.getInstance(Browser.Chrome);
		driver.manage().window().maximize();
		driver.get("https://mail.ru/");
		loginPage = new LoginPage(driver);
		loginPage.enterData(credentialPair.get(0), credentialPair.get(1));
	}

	@After
	public void tearDown() throws Exception {
		DriverFactory.disposeDriver();
	}

	@Test
	public void testMoveToSpamAndBack() {
		// move to spam
		messagePage = loginPage.clickEnterButton();
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Входящие"));
		assertTrue(loginPage.isLogoutDisplayed(driver));
		messagePage.chooseFirstMessage();
		messagePage.clickSpamButton();
		messagePage.clickApproveSpamButton();
		driver.navigate().refresh();
		messagePage.clickSpamField();
		driver.navigate().refresh();
		// move from spam
		messagePage.chooseFirstMessage();
		messagePage.clickSpamButton();
	}

	@Test
	public void testSentMessageSeveralUsers() {
		ArrayList<String> emails = databaseHelper.getEmails();
		messagePage = loginPage.clickEnterButton();
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Входящие"));
		assertTrue(loginPage.isLogoutDisplayed(driver));
		sendMessagePage = messagePage.clickCreateMessageButton();
		for (String email : emails) {
			sendMessagePage.enterRecipientNew(email);
		}
		sendMessagePage.enterTheme(subject);
		sendMessagePage.enterMessageText(message);
		sendMessagePage.sendButtonClick();
		assertTrue(sendMessagePage.messageIsSent());
	}

	@Test
	public void testFlagAndUnflag() {
		messagePage = loginPage.clickEnterButton();
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Входящие"));
		assertTrue(loginPage.isLogoutDisplayed(driver));
		messagePage.chooseSeveralMessagesFlags();
		messagePage.chooseSeveralMessagesFlags();
	}

	// test with facade and builder patterns
	@Test
	public void testSentMessageOneUser() {
		EmailSender emailSender = new EmailSender(driver);
		String to = databaseHelper.getEmails().get(1);
		EmailBuilder emailBuilder = new EmailBuilder();
		Email email = emailBuilder.setTo(to).setSubject(subject).setMessage(message).build();
		sendMessagePage = emailSender.sentMessage(email, loginPage);
		assertTrue(sendMessagePage.messageIsSent());
	}
}
