package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;

	}

//Element Library or object Repository
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),Dashboard )]")
	WebElement PageTitleDashBoard;
	@FindBy(xpath = "//a[contains(text(),'Add Deposit') ]")
	WebElement AddDepositBtn;
	@FindBy(xpath="//a[text()='Add Expense']")WebElement AddExpenseBtn;
//Method
	public void waitForPage() {
	
		waitForElement(PageTitleDashBoard,driver);
	}

	public void clickonAddDepositBtn() {
		AddDepositBtn.click();
	}
	public void clickonAddExpenseBtn() {
		AddExpenseBtn.click();
	}
	}
