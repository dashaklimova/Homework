package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoundHotelsPage {
	private WebDriver driver;

	@FindBy(xpath = "//div[@data-et-view=' eWHJbWPNZWEHXT:5']")
	private List<WebElement> hotels;

	@FindBy(xpath = "//a[@data-id='pri-1']")
	private WebElement cheapestPriceTickBox;

	@FindBy(xpath = "//a[@data-id='pri-5']")
	private WebElement theMostExpensivePriceTickBox;

	@FindBy(xpath = "//div[@id='filter_review']//a[@data-id='review_score-90']")
	private WebElement rating9TickBox;

	@FindBy(xpath = "//a[@data-category='price']")
	private WebElement cheapestPriceButton;

	@FindBy(xpath = "//strong//b")
	private List<WebElement> priceValues;

	@FindBy(xpath = "// div[contains(@class, 'totalPrice')]")
	private List<WebElement> priceInStringValues;

	@FindBy(xpath = "// div[contains(@class, 'prd-taxes-and-fees-under-price')]")
	private List<WebElement> taxesValues;

	@FindBy(xpath = "//a[contains(@class,'hotel_name_link')]")
	private WebElement hotelLink;

	public FoundHotelsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean areHotelsListEmpty(WebDriver driver) {
		return hotels.isEmpty();
	}

	public void clickCheapestPriceTickBox() {
		cheapestPriceTickBox.click();
	}

	public void clicktheMostExpensivePriceTickBox() {
		theMostExpensivePriceTickBox.click();
	}

	public void clicktheCheapestPriceButton() {
		cheapestPriceButton.click();
	}

	public void clickRating9TickBox(WebDriver driver) {
		rating9TickBox.click();
	}

	public BookPage seeFirstHotelDetails() {
		String detailsButtonLocator = "//div[@class='sr-cta-button-row']";
		hotels.get(0).findElement(By.xpath(detailsButtonLocator)).click();
		// switch to the 2nd tab
		ArrayList<String> tabsNames = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabsNames.get(1));
		return new BookPage(driver);
	}

	// gets the price for 2 persons
	public int getPrice() {
		String empty = "";
		int price = Integer.parseInt(priceValues.get(0).getText().replaceAll("[ BYN]", empty));
		return price;
	}

	// gets the price when there are several rooms
	public int getPriceFromString() {
		String empty = "";
		String message = priceInStringValues.get(0).getText();
		int indexOfBun = message.indexOf("BYN");
		String priceString = message.substring(indexOfBun);
		String taxesText = taxesValues.get(0).getText();
		priceString = priceString.replace(taxesText, empty);
		int price = Integer.parseInt(priceString.replaceAll("[ BYN\\n]", empty));
		return price;
	}

	private void waitForLoadingToDisappear() {
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='sr-usp-overlay__loading']")));
	}

	public void waitForFiltersToBeApplied() {
		waitForLoadingToDisappear();
	}
}
