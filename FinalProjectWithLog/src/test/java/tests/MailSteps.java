package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DatabaseHelper;
import helpers.ScreenshotTaker;
import pages.LoginPage;
import pages.MessagePage;
import pages.SendMessagePage;
import patterns.DriverFactory;

public class MailSteps {

	private static final Logger logger = Logger.getLogger(MailSteps.class);
	private WebDriver driver;
	private LoginPage loginPage;
	private MessagePage messagePage;
	private SendMessagePage sendMessagePage;
	private DatabaseHelper databaseHelper;
	private String subject = "I am subject";
	private String message = "I am an email body";
	private int i = 0;
	private String scenarioName;

	@Before("@UI")
	public void before(Scenario scenario) {
		scenarioName = scenario.getName();
	}

	@After("@UI")
	public void after() {
		DriverFactory.disposeDriver();
	}

	@Given("^I am on home mail.ru page$")
	public void loadMailPage() {
		databaseHelper = new DatabaseHelper();
		ArrayList<String> credentialPair = databaseHelper.getCredentials().get(0);
		// factory method and singleton patterns are used here
		driver = DriverFactory.getInstance();
		driver.manage().window().maximize();
		driver.get("https://mail.ru/");
		loginPage = new LoginPage(driver);
		loginPage.enterData(credentialPair.get(0), credentialPair.get(1));
		logger.info("login");
		ScreenshotTaker.takeScreenshot(scenarioName);
	}

	@When("^I login with correct data$")
	public void loginWithCorrectData() {
		messagePage = loginPage.clickEnterButton();
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Входящие"));
	}

	@Then("I see login is succesfull")
	public void loginIsSuccesfull() {
		ScreenshotTaker.takeScreenshot(scenarioName);
		assertTrue(loginPage.isLogoutDisplayed(driver));
//		DriverFactory.disposeDriver();
	}

	@Then("I see message is sent")
	public void messageIsSent() {
		ScreenshotTaker.takeScreenshot(scenarioName);
		logger.info("message is sent");
		assertTrue(sendMessagePage.messageIsSent());
	}

	@And("^I send a message to several users$")
	public void sendMessageToSeveralUsers() {
		logger.info("send a message to several users");
		ArrayList<String> emails = databaseHelper.getEmails();
		sendMessagePage = messagePage.clickCreateMessageButton();
		for (String email : emails) {
			sendMessagePage.enterRecipientNew(email);
		}
		sendMessagePage.enterTheme(subject);
		sendMessagePage.enterMessageText(message);
		sendMessagePage.sendButtonClick();
		ScreenshotTaker.takeScreenshot(scenarioName);
	}

	@And("^I delete message$")
	public void deleteMessage() {
		logger.info("delete message");
		messagePage.chooseFirstMessage();
		messagePage.clickDeleteMessageButton();
		driver.navigate().refresh();
		messagePage.clickBasketField();
		ScreenshotTaker.takeScreenshot(scenarioName);
		assertTrue(messagePage.isClearFolderButtonPresent());
		driver.navigate().refresh();
		messagePage.clearFolder();
		ScreenshotTaker.takeScreenshot(scenarioName);
	}

	@Then("I see that message is deleted")
	public void messageIsDeleted() {
		ScreenshotTaker.takeScreenshot(scenarioName);
		assertTrue(messagePage.isFolderClean());
	}

	@And("^I move message to spam$")
	public void moveMessageToSpam() {
		logger.info("move message to spam");
		messagePage.chooseFirstMessage();
		messagePage.clickSpamButton();
		messagePage.clickApproveSpamButton();
		driver.navigate().refresh();
		messagePage.clickSpamField();
		ScreenshotTaker.takeScreenshot(scenarioName);
	}

	@Then("I see that message is in spam")
	public void messageIsInSpam() {
		ScreenshotTaker.takeScreenshot(scenarioName);
		assertTrue(messagePage.isClearFolderButtonPresent());
	}

	@And("^I clean spam folder$")
	public void cleanSpamFolder() {
		logger.info("clean spam folder");
		assertTrue(messagePage.isClearFolderButtonPresent());
		driver.navigate().refresh();
		messagePage.clearFolder();
		ScreenshotTaker.takeScreenshot(scenarioName);
	}

	@Then("I see spam folder is clean")
	public void spamFolderIsClean() {
		ScreenshotTaker.takeScreenshot(scenarioName);
		assertTrue(messagePage.isFolderClean());
	}

	@Then("I see message move back from spam")
	public void messageMoveBackFromSpam() {
		driver.navigate().refresh();
		messagePage.chooseFirstMessage();
		messagePage.clickSpamButton();
		ScreenshotTaker.takeScreenshot(scenarioName);
	}

	@And("^I mark several messages by flag$")
	public void markSeveralMessagesByFlag() {
		logger.info("mark several messages by flag");
		messagePage.chooseSeveralMessagesFlags();
		driver.navigate().refresh();
		messagePage.clickFlagIcon();
		ScreenshotTaker.takeScreenshot(scenarioName);
	}

	@Then("I see messages with flags in folder")
	public void messagesWithFlagsInFolder() {
		ScreenshotTaker.takeScreenshot(scenarioName);
		assertTrue(!messagePage.isMessagesListWithFlagsEmpty());
	}

	@And("^I click on folder field$")
	public void clickOnFolderField() {
		logger.info("click on folder field");
		messagePage.clickFilesButton();
		ScreenshotTaker.takeScreenshot(scenarioName);
	}

	@Then("I see message about folder field")
	public void messagesAboutFolderFild() {
		ScreenshotTaker.takeScreenshot(scenarioName);
		assertTrue(messagePage.isFolderClean());
	}

	@Then("I see that field with icons is displayed")
	public void fieldWithIconsIsDisplayed() {
		ScreenshotTaker.takeScreenshot(scenarioName);
		assertTrue(loginPage.isFieldWithIconsDisplayed());
	}
}
