package PageWisePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProject.myPack.Finder;
import com.TestProject.myPack.Browser.GlobalVars;

public class LoginPOM {
	static WebDriverWait wait = new WebDriverWait(GlobalVars.Web_Driver, 20);

	public static WebElement alredyMember() {
		// return Finder.findWebElement("//div[@class='already-accoutn login']");
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='already-accoutn login']")));
		return element;
	}

	public static WebElement userId() {
		return Finder.findWebElement("//input[@id='login_email']");
	}

	public static WebElement password() {
		return Finder.findWebElement("//input[@id='login_password']");
	}

	public static WebElement rememberMe() {
		return Finder.findWebElement("//div[@class='col-sm-6 text-left']//span");
	}

	public static WebElement logIn() {
		return Finder.findWebElement("//button[@type='submit']//span[text()='Log in']");
	}

	public static WebElement loginButton() {
		return Finder.findWebElement("//li//a[@title='login']");
	}
	public static WebElement confirmLogin()
	{
		System.out.println("login confirmation...");
		return Finder.findWebElement("(//header//div[@class='container']//nav/ul/li)[1]/a//span");
	}
	public static WebElement closeLoginDialog() {
		return Finder.findWebElement("(//button[@type='button' and @class='close'])[1]");
	}

}
