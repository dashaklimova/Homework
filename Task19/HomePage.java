package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	@FindBy(xpath = "//input[@id='ss']")
	private WebElement searchField;

	@FindBy(xpath = "//div[@class='sb-date-field b-datepicker'][1]")
	private WebElement datesField;

	@FindBy(xpath = "//td[@data-date='2019-03-06']")
	private WebElement dateOfArrivalField;

	@FindBy(xpath = "//td[@data-date='2019-03-12']")
	private WebElement departureDateField;

	@FindBy(xpath = "//label[@id='xp__guests__toggle']")
	private WebElement countsOfAdultAndRoomsField;

	@FindBy(xpath = "//div[contains(@class,'sb-group__field-adults')]//span[@class='bui-stepper__display']")
	private WebElement adultsCountText;

	@FindBy(xpath = "//div[contains(@class,'sb-group__field-adults')]//button[contains(@class,'bui-stepper__add-button')]")
	private WebElement addAdultButton;
	
	@FindBy(xpath = "//div[contains(@class,'sb-group__field-rooms')]//span[@class='bui-stepper__display']")
	private WebElement roomsCountText;
	
	@FindBy(xpath = "//div[contains(@class,'sb-group__field-rooms')]//button[contains(@class,'bui-stepper__add-button')]")
	private WebElement addRoomButton;

	@FindBy(xpath = "//button[@class='sb-searchbox__button  ']")
	private WebElement checkPricesButton;

	@FindBy(xpath = "//span[contains(text(),'Войти в аккаунт')]")
	private WebElement loginButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterCity(String city) {
		searchField.clear();
		searchField.sendKeys(city);
		searchField.click();
	}

	public void selectAdultsRooms(int adults, int rooms) {
		countsOfAdultAndRoomsField.click();
		while (Integer.parseInt(adultsCountText.getText()) < adults) {
			addAdultButton.click();
		}

		while (Integer.parseInt(roomsCountText.getText()) < rooms) {
			addRoomButton.click();
		}
	}
	
	public void setDate() {
		dateOfArrivalField.click();
		departureDateField.click();
	}

	public void clickDatesField() {
		datesField.click();
	}

	public FoundHotelsPage clickCheckPricesButton() {
		checkPricesButton.click();
		return new FoundHotelsPage(driver);
	}

	public LoginPage clickLogin() {
		loginButton.click();
		return new LoginPage(driver);
	}
}
