package test;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddDepositPage;
import page.BasePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ScreenShotHandle;

public class AddDepositTest extends BasePage {
	
	@Test
	public void AddDepositToVerifyDepositPosted() throws InterruptedException, IOException {
//Starts the Browser and save the driver in the test class
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=admin/");
		// calling LoginPage Class or Activate
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		// calling the method inside Login Page
		loginPage.login("techfiosdemo@gmail.com", "abc123");
		// Activate DashboardPage
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		// call the method inside DashBoard Page
		dashboardPage.waitForPage();
		// Step:click on the Add deposit Button
		dashboardPage.clickonAddDepositBtn();
		// Activate Add Deposit Page
		AddDepositPage adddepositPage = PageFactory.initElements(driver, AddDepositPage.class);
		ScreenShotHandle screenShotHandler= PageFactory.initElements(driver,ScreenShotHandle.class);
		
// Validate AddDepositPage opened (waitForPage)
		adddepositPage.waitForPage();
		// A method to select a specific info from dropDown
		adddepositPage.selectFromDropDownForAccount("checking account");
// Call to  fill the date		
		adddepositPage.clearTheDateAndnput("2019-06-12");
		Thread.sleep(6000);
//call for filling the form for Description and Amount
		String description = "SalaryDeposit" + adddepositPage.randomnumber(100);
		String amount = String.valueOf(adddepositPage.randomnumber(5000));
		adddepositPage.fillinAddDepositForm(description, amount);
		adddepositPage.clickonSubmitBtn();
//Explicit wait validation
		adddepositPage.WaitforSuccessMsg();

		Assert.assertTrue(adddepositPage.isSuccessMsgDisplayed(), "Success msg didnot show !");
		screenShotHandler.takeScreenshoot(driver, "Adddeposit");
		driver.close();
		driver.quit();
	}
	}

