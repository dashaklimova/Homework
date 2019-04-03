package helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import patterns.DriverFactory;

public class ScreenshotTaker {
	public static void takeScreenshot(String scenarioName) {
		File scrFile = ((TakesScreenshot) DriverFactory.getInstance()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("D:\\JAVA training Dasha\\ProjectScreenshots\\" + scenarioName
					+ System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
