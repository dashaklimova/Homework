package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {

	private WebDriver driver;

	@FindBy(xpath = "//button[@name='book']")
	private WebElement nextButton;

	@FindBy(xpath = "//div[@class='bp-overview-buttons-wrapper']//button[@name='book']")
	private WebElement finishBookingButton;

	@FindBy(id = "phone")
	private WebElement phoneInput;

	@FindBy(id = "cc_type")
	private WebElement cardTypeDropdown;

	@FindBy(id = "cc_number")
	private WebElement cardNumberField;

	@FindBy(id = "cc_cvc")
	private WebElement cvcCodeInput;

	@FindBy(id = "ccYear")
	private WebElement yearDropdown;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickNext() {
		nextButton.click();
	}

	public void enterUserData(String phone, String cardNumber, String cvc) {
		phoneInput.clear();
		phoneInput.sendKeys(phone);
		Select cardTypeDropdownSelect = new Select(cardTypeDropdown);
		cardTypeDropdownSelect.selectByValue("Visa");
		enterCardNumber(cardNumber);
		Select yearDropdownSelect = new Select(yearDropdown);
		yearDropdownSelect.selectByValue("2020");
		if (cvcCodeInput.isDisplayed()) {
			cvcCodeInput.sendKeys(cvc);
		}
	}

	private void enterCardNumber(String cardNumber) {
		for (int i = 0; i < cardNumber.length(); i++) {
			char letter = cardNumber.charAt(i);
			String stringLetter = new StringBuilder().append(letter).toString();
			cardNumberField.sendKeys(stringLetter);
		}
	}

	public FinishedBookingPage finishBooking() {
		finishBookingButton.click();
		return new FinishedBookingPage(driver);
	}
}
