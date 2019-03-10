package core;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingSteps {

	private WebDriver driver;
	private HomePage homePage;
	private FoundHotelsPage foundHotelsPage;
	private static final String URL = "https://www.booking.com/";
	private static final String CITY = "Moscow";

	public BookingSteps() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
	}

	@Given("^I am on home booking page$")
	public void loadHomePage() {
		driver.get(URL);
	}

	@When("^I enter city$")
	public void enterCity() {
		homePage.enterCity(CITY);
	}

	@And("^I fill dates$")
	public void fillDates() {
		homePage.clickDatesField();
		homePage.setDate();
	}

	@And("^I click CheckPricesButton$")
	public void clickCheckPricesButton() {
		foundHotelsPage = homePage.clickCheckPricesButton();
	}

	@Then("I see a full list of hotels")
	public void seeFullListOfHotels() {
		Assert.assertTrue(!foundHotelsPage.areHotelsListEmpty(driver));
	}

	@And("^I sort hotels with a rating of more than nine$")
	public void sortHotelsWithRatingOverNine() {
		foundHotelsPage.clickRating9TickBox(driver);
		foundHotelsPage.waitForFiltersToBeApplied();
	}

	@And("^I go to the page with the hotel$")
	public void goToPageWithHotel() {
		foundHotelsPage.clickHotelLink();
		foundHotelsPage.switchToThe2ndTab();
	}

	@Then("I see that the hotel rating is over nine")
	public void seeHotelWithRatingOverNine() {
		Assert.assertTrue("Rating was <9", foundHotelsPage.getRatingAndCheckItsMoreThan9());
	}

	@After
	public void afterClass() {
		driver.quit();
	}
}
