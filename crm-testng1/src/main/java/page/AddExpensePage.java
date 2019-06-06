package page;

import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddExpensePage extends BasePage {
	WebDriver driver;

	public AddExpensePage(WebDriver driver) {
		this.driver = driver;
	}

//Element Library or object Repository

	@FindBy(xpath = "//select[@id='account']")
	WebElement SelectAccountName;
	@FindBy(id = "description")
	WebElement DescriptionField;
	@FindBy(id = "amount")
	WebElement AmountField;
	@FindBy(id = "submit")
	WebElement SummitBtn;
	@FindBy(xpath = "//button[@data-dismiss='alert']")
	WebElement ExpenseDepositSuccess;
	@FindBy(xpath = "//h5[text()='Add Expense']")
	WebElement AddExpensePanelHeading;
	@FindBy(id = "date")
	WebElement DateField;

//Method to interact with the Elements

	public void waitForPage() {
		waitForElement(AddExpensePanelHeading, driver);
	}

	
	public void selectFromDropDownForExpenseAccount(String string) {
		Select AcctDropDown = new Select(SelectAccountName);
		AcctDropDown.selectByVisibleText(string);

	}

	public void clearTheDateAndnputExpense(String string) {
		DateField.clear();
		DateField.sendKeys(string);
//After input a date need to click some where to go calendar field so I click on AddExpensePanelHeading
		AddExpensePanelHeading.click();
	}

	public void fillinAddExpenseForm(String description, String amount) {
		DescriptionField.sendKeys(description);
		AmountField.sendKeys(amount);

	}
	public void clickonSubmitBtn() {
		SummitBtn.click();
	}

	public void WaitforSuccessMsg() {
		waitForElement(ExpenseDepositSuccess, driver);
	}
	public boolean isSuccessMsgDisplayed() {
		try {
			return ExpenseDepositSuccess.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}