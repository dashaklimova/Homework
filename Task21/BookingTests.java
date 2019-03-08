package core;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingTests {
	private WebDriver driver;
	private HomePage homePage;
	private FoundHotelsPage foundHotelsPage;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.booking.com/");
		homePage = new HomePage(driver);
	}

	@Test
	public void testMoscowHotels() {
		homePage.enterCity("Moscow");
		homePage.clickDatesField();
		homePage.setDate();
		foundHotelsPage = homePage.clickCheckPricesButton();
		assertTrue(!foundHotelsPage.areHotelsListEmpty(driver));
	}

	@Test
	public void testMoscowHotelsRatingOverNine() {
		homePage.enterCity("Moscow");
		homePage.clickDatesField();
		homePage.setDate();
		foundHotelsPage = homePage.clickCheckPricesButton();
		WebElement checkPricesButton = driver.findElement(By.xpath("//button[@class='sb-searchbox__button  ']"));
		checkPricesButton.click();
		foundHotelsPage.clickRating9TickBox(driver);
		foundHotelsPage.waitForFiltersToBeApplied();
		foundHotelsPage.clickHotelLink();
		foundHotelsPage.switchToThe2ndTab();
		assertTrue("Rating was <9", foundHotelsPage.getRatingAndCheckItsMoreThan9());
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
