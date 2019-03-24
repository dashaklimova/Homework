package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@Before
	public void setUp() throws Exception {
		databaseHelper = new DatabaseHelper();
		ArrayList<String> credentialPair = databaseHelper.getCredentials().get(0);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		driver.get("https://mail.ru/");
		loginPage.enterData(credentialPair.get(0), credentialPair.get(1));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
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
		sendMessagePage.enterTheme("111");
		sendMessagePage.enterMessageText("Hi");
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

}
