package core;

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

	@FindBy(xpath = "//div[@id='filter_review']//a[@data-id='review_score-90']")
	private WebElement rating9TickBox;

	@FindBy(xpath = "//a[contains(@class,'hotel_name_link')]")
	private WebElement hotelLink;

	public FoundHotelsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean areHotelsListEmpty(WebDriver driver) {
		return hotels.isEmpty();
	}

	public void clickRating9TickBox(WebDriver driver) {
		rating9TickBox.click();
	}

	public void clickHotelLink() {
		WebElement hotel = hotels.get(0);
		WebElement hotelLink = hotel.findElement(By.xpath("//a[contains(@class,'hotel_name_link')]"));
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'hotel_name_link')]")));
		hotelLink.click();
	}

	public void switchToThe2ndTab() {
		ArrayList<String> tabsNames = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabsNames.get(1));
	}

	public boolean getRatingAndCheckItsMoreThan9() {
		WebElement ratingValue = driver
				.findElement(By.xpath("//div[@id='js--hp-gallery-scorecard']//div[@class='bui-review-score__badge']"));
		double rating = Double.parseDouble(ratingValue.getText().replace(',', '.').trim());
		return rating >= 9;
	}

	private void waitForLoadingToDisappear() {
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='sr-usp-overlay__loading']")));
	}

	public void waitForFiltersToBeApplied() {
		waitForLoadingToDisappear();
	}
}
