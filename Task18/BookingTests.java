package core;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingTests {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
	}

	@Test
	public void testMoscowHotels() {
		driver.get("https://www.booking.com/");
		WebElement searchField = driver.findElement(By.xpath("//input[@id='ss']"));
		searchField.clear();
		searchField.sendKeys("Москва");
		WebElement startDateField = driver.findElement(By.xpath("//div[@class='sb-date-field b-datepicker'][1]"));
		startDateField.click();
		WebElement dateOfArrivalField = driver.findElement(By.xpath("//td[@data-date='2019-03-04']"));
		dateOfArrivalField.click();
		WebElement departureDateField = driver.findElement(By.xpath("//td[@data-date='2019-03-10']"));
		departureDateField.click();
		WebElement checkPricesButton = driver.findElement(By.xpath("//button[@class='sb-searchbox__button  ']"));
		checkPricesButton.click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@data-et-view=' eWHJbWPNZWEHXT:5']"));
		assertTrue(!list.isEmpty());
	}

	@Test
	public void testMoscowHotelsRatingOverNine() {
		// open browser and navigate to booking
		driver.get("https://www.booking.com/");

		// enter city, date and click Search
		WebElement searchField = driver.findElement(By.xpath("//input[@id='ss']"));
		searchField.clear();
		searchField.sendKeys("Москва");
		WebElement startDateField = driver.findElement(By.xpath("//div[@class='sb-date-field b-datepicker'][1]"));
		startDateField.click();
		WebElement dateOfArrivalField = driver.findElement(By.xpath("//td[@data-date='2019-03-04']"));
		dateOfArrivalField.click();
		WebElement departureDateField = driver.findElement(By.xpath("//td[@data-date='2019-03-10']"));
		departureDateField.click();
		WebElement checkPricesButton = driver.findElement(By.xpath("//button[@class='sb-searchbox__button  ']"));
		checkPricesButton.click();

		// filter by '9' rating, get the first hotel and open it
		WebElement rating9 = driver.findElement(By.xpath("//div[@id='filter_review']//a[@data-id='review_score-90']"));
		rating9.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		new WebDriverWait(driver, 20).until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'sr_item')]")));
		List<WebElement> hotels = driver.findElements(By.xpath("//div[contains(@class,'sr_item')]"));
		WebElement hotel = hotels.get(0);
		WebElement hotelLink = hotel.findElement(By.xpath("//a[contains(@class,'hotel_name_link')]"));
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'hotel_name_link')]")));
		hotelLink.click();

		// switch to the 2nd tab
		ArrayList<String> tabsNames = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabsNames.get(1));

		// get rating and check it's>=9
		WebElement ratingValue = driver
				.findElement(By.xpath("//div[@id='js--hp-gallery-scorecard']//div[@class='bui-review-score__badge']"));
		double rating = Double.parseDouble(ratingValue.getText().replace(',', '.').trim());
		assertTrue("Rating was <9", rating >= 9);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
