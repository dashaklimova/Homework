package patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import enums.Browser;

// Singleton + Factory
public class DriverFactory {
	private static WebDriver instance;

	private DriverFactory() {

	}

	public static WebDriver getInstance(Browser browserType) {
		if (instance == null) {
			switch (browserType) {
			case Chrome:
				instance = new ChromeDriver();
				break;
			case Firefox:
				instance = new FirefoxDriver();
				break;
			case Opera:
				instance = new OperaDriver();
				break;
			}
		}

		return instance;
	}

	public static void disposeDriver() {
		instance.quit();
		instance = null;
	}
}