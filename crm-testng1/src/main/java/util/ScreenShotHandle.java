package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotHandle {
	static WebDriver driver;
public static void takeScreenshoot(WebDriver driver ,String filename) throws IOException {
//1. take screenshot and store it as a file format:
 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 //now copy screenshot to desire location  using copy file method
 FileUtils.copyFile(screenshotFile,new File("c:\\data\\"+filename+".png"));
}
}
