package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookPage {

	private WebDriver driver;

	@FindBy(xpath = "//div[@id='wrap-hotelpage-top']//button[@id='hp_book_now_button']")
	private WebElement bookButton;

	@FindBy(xpath = "//tr[contains(@class,'hprt-table-last-row')]")
	private List<WebElement> rooms;

	@FindBy(xpath = "//button[contains(@class,'js-reservation-button')]")
	private WebElement iBookButton;

	public BookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private void selectRoom() {
		WebElement firstRoomSelector = rooms.get(0).findElement(By.xpath("//select[@class='hprt-nos-select']"));
		Select roomSelect = new Select(firstRoomSelector);
		roomSelect.selectByValue("1");
	}
	
	public PaymentPage book (){
		bookButton.click();
		selectRoom();
		iBookButton.click();
		return new PaymentPage(driver);
	}
}
