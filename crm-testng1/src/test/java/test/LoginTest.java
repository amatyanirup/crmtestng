package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ScreenShotHandle;

public class LoginTest {
	
	@Test
	public void logintest() throws IOException  {
//Starts the Browser and save the driver in the test class
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=admin/");
		//calling LoginPage Class or Activate
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		//calling the method inside Login Page
		loginPage.login("techfiosdemo@gmail.com", "abc123");
		loginPage.verifytakeScreenshot();
		// Activate DashboardPage
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		//call the method inside DashBoard Page
		dashboardPage.waitForPage();
	
		
		}
	
	@Test
	public void TakeScreenshotTest() {
		Assert.assertEquals(false, true);
	}
		}
	




