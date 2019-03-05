package core;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;
import pages.MessagePage;
import pages.SendMessagePage;

public class Tests {
	private WebDriver driver;
	private LoginPage loginPage;
	private MessagePage messagePage;
	private SendMessagePage sendMessagePage;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		driver.get("https://mail.ru/");
		loginPage.enterData("user.test.2000", "us20002000");
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
		messagePage = loginPage.clickEnterButton();
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Входящие"));
		assertTrue(loginPage.isLogoutDisplayed(driver));
		sendMessagePage = messagePage.clickCreateMessageButton();
		sendMessagePage.enterRecipients("user.test.2000@mail.ru dasha.7777777@mail.ru");
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
