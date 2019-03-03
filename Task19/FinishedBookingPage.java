package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinishedBookingPage {

	private WebDriver driver;

	@FindBy(xpath = "//div[contains(@class,'invalid-cc-banner-alert__container')]")
	private WebElement invalidCardMessageContainer;
	
	@FindBy(xpath = "//div[@class='reassurance__title']")
	private WebElement reassuranceTitleText;

	@FindBy(xpath = "//div[@class='bp_interstitial__preloader']")
	private WebElement loadingIcon;

	public FinishedBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForLoadingToDisappear() {
		new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bp_interstitial__preloader']")));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reassurance__title']")));
	}

	public void refreshPage() {
		driver.navigate().refresh();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reassurance__title']")));
	}

	public boolean errorMessageIsDisplayed() {
		return invalidCardMessageContainer.isDisplayed();
	}
}
