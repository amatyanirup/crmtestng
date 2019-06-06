package page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.ScreenShotHandle;

public class LoginPage {
	WebDriver driver; // Global Driver
	
	// Every page must have a constructor to invite the driver
	public LoginPage(WebDriver driver) {
	
		this.driver = driver;
	}
	// Element Library

	@FindBy(how = How.ID, using = "username")
	WebElement UserName;
	@FindBy(how = How.ID, using = "password")
	WebElement Password;
	@FindBy(how = How.NAME, using = "login")
	WebElement Signin;
	
	

	// Methods to interact with the elements
	public void login(String userName, String password) {
		UserName.sendKeys(userName);
		Password.sendKeys(password);
		Signin.click();

	}
	
	public void verifytakeScreenshot() throws IOException {
		ScreenShotHandle.takeScreenshoot(driver, "test3");
	}
	
}