package core;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.BookPage;
import pages.FinishedBookingPage;
import pages.FoundHotelsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;

public class ParisTests {
	private WebDriver driver;
	private HomePage homePage;
	private FoundHotelsPage foundHotelsPage;
	private String login = "testuserdasha@gmail.com";
	private String password = "test7777";
	private String phone = "375271232323";
	private String cardNumber = "4242424242424242";
	private String cvc = "123";
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
		homePage = new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testParisLowPriceHighRating() {
		homePage.enterCity("Париж");
		homePage.clickDatesField();
		homePage.setDate();
		foundHotelsPage = homePage.clickCheckPricesButton();
		foundHotelsPage.clickCheapestPriceTickBox();
		foundHotelsPage.waitForFiltersToBeApplied();
		assertTrue(!foundHotelsPage.areHotelsListEmpty(driver));
		foundHotelsPage.clickRating9TickBox(driver);
		foundHotelsPage.waitForFiltersToBeApplied();
		assertTrue(!foundHotelsPage.areHotelsListEmpty(driver));
		assertTrue(foundHotelsPage.getPrice() <= 720);
	}

	@Test
	public void testPriceNotLowerThanRange() {
		homePage.enterCity("Париж");
		homePage.clickDatesField();
		homePage.setDate();
		homePage.selectAdultsRooms(4, 2);
		foundHotelsPage = homePage.clickCheckPricesButton();
		foundHotelsPage.clicktheMostExpensivePriceTickBox();
		foundHotelsPage.waitForFiltersToBeApplied();
		foundHotelsPage.clicktheCheapestPriceButton();
		foundHotelsPage.waitForFiltersToBeApplied();
		assertTrue(foundHotelsPage.getPriceFromString() >= 5820);
	}
	
	@Test
	public void testBookWithWrongDataErrorDisplayed() {
		LoginPage loginPage = homePage.clickLogin();
		homePage = loginPage.login(login, password);
		homePage.enterCity("Париж");
		homePage.clickDatesField();
		homePage.setDate();
		homePage.selectAdultsRooms(4, 2);
		foundHotelsPage = homePage.clickCheckPricesButton();
		foundHotelsPage.clicktheMostExpensivePriceTickBox();
		foundHotelsPage.waitForFiltersToBeApplied();
		foundHotelsPage.clicktheCheapestPriceButton();
		foundHotelsPage.waitForFiltersToBeApplied();
		
		BookPage bookPage = foundHotelsPage.seeFirstHotelDetails();
		PaymentPage paymentPage = bookPage.book();
		paymentPage.clickNext();
		paymentPage.enterUserData(phone, cardNumber, cvc);
		FinishedBookingPage finishedBookingPage = paymentPage.finishBooking();
		finishedBookingPage.waitForLoadingToDisappear();
		finishedBookingPage.refreshPage();
		assertTrue(finishedBookingPage.errorMessageIsDisplayed());
	}
	
	

}
