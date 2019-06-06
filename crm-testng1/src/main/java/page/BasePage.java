package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver; // Global Driver

	public static void waitForElement(WebElement element,WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public int randomnumber(int i) {
		Random rnd = new Random();
		int randomnumber=  rnd.nextInt(i);
		return randomnumber;
	}
	
}