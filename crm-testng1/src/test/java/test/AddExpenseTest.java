package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddExpensePage;
import page.BasePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddExpenseTest extends BasePage {
	
	@Test
	public void AddExpenseToVerifyExpensePosted() throws InterruptedException {
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
		// Step:click on the Add Expense Button
		dashboardPage.clickonAddExpenseBtn();
		AddExpensePage addexpensePage = PageFactory.initElements(driver, AddExpensePage.class);
		// Activate Add Deposit Page
		//AddDepositPage adddepositPage = PageFactory.initElements(driver, AddDepositPage.class);
// Validate AddExpensePage opened (waitForPage)
	
		addexpensePage.waitForPage();
		// A method to select a specific info from dropDown
		addexpensePage.selectFromDropDownForExpenseAccount("housedownpayment");
// Call to  fill the date		
		addexpensePage.clearTheDateAndnputExpense("2019-06-13");
		Thread.sleep(6000);
//call for filling the form for Description and Amount
		String description = "HouseExpenses" + addexpensePage.randomnumber(100);
		String amount = String.valueOf(addexpensePage.randomnumber(5000));
		addexpensePage.fillinAddExpenseForm(description, amount);
		addexpensePage.clickonSubmitBtn();
//Explicit wait validation
		addexpensePage.WaitforSuccessMsg();

		Assert.assertTrue(addexpensePage.isSuccessMsgDisplayed(), "Success msg didnot show !");

		driver.close();
		driver.quit();
	}
	}

