package patterns;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import enums.Browser;

// Singleton + Factory
public class DriverFactory {
	private static WebDriver instance;

	private DriverFactory() {

	}

	private static Browser getBrowserFromConfig() {
		Browser browser = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse("config.xml");
			Node browserNode = document.getElementsByTagName("browser").item(0);
			String browserString = browserNode.getTextContent();
			browser = Browser.valueOf(browserString);			
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return browser;
	}
	
	public static WebDriver getInstance() {	
		if (instance == null) {
			Browser browserType = getBrowserFromConfig();
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