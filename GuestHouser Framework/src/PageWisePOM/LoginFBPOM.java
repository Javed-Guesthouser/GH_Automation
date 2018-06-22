package PageWisePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProject.myPack.Finder;
import com.TestProject.myPack.Browser.GlobalVars;

public class LoginFBPOM {
	static WebDriverWait wait = new WebDriverWait(GlobalVars.Web_Driver, 20);

	public static WebElement email() {
		return Finder.findWebElement("//input[@type='text' and @name='email']");
	}

	public static WebElement password() {
		return Finder.findWebElement("//input[@type='password' and @name='pass']");
	}

	public static WebElement loginWithFacebook() {
		return Finder.findWebElement("(//span[text()='or Login with']//following::a[@class='facebook'])[1]");
	}

	public static WebElement loginButton() {
		return Finder.findWebElement("//li//a[@title='login']");
	}

	public static WebElement alredyMember() {
		// return Finder.findWebElement("//div[@class='already-accoutn login']");
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='already-accoutn login']")));
		return element;
	}

	public static WebElement submit() {
		return Finder.findWebElement("//input[@name='login' and @type='submit']");
	}

	public static WebElement closeLoginDialog() {
		return Finder.findWebElement("(//button[@type='button' and @class='close'])[1]");
	}

}
