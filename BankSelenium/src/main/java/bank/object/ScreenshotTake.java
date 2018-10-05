package main.java.bank.object;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTake {
	private WebDriver driver;
	
	public ScreenshotTake(WebDriver driver) {
		this.driver = driver;
	}
	
	public void takesSnapshot(String fileWithPath) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot)driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		File destFile = new File(fileWithPath+date.toString().replaceAll(" ", "_").replaceAll(":", "-")+".png");
		FileUtils.copyFile(srcFile, destFile);
	}
}
