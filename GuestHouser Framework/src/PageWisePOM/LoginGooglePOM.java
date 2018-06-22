package PageWisePOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProject.myPack.Finder;
import com.TestProject.myPack.Browser.GlobalVars;

public class LoginGooglePOM {
	static WebDriverWait wait = new WebDriverWait(GlobalVars.Web_Driver, 20);

	public static WebElement loginButton() {
		return Finder.findWebElement("//li//a[@title='login']");
	}

	public static WebElement alredyMember() {
		// return Finder.findWebElement("//div[@class='already-accoutn login']");
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='already-accoutn login']")));
		return element;
	}

	public static List<WebElement> alreadyLogged() {
		List<WebElement> list = Finder.findWebElements("//div[@jsname='USBQqe']//p[@role='heading']");
		return list;
	}

	public static WebElement useAnotherAcct() {
		return Finder.findWebElement("//p[text()='Use another account']");
	}

	public static WebElement email() {
		return Finder.findWebElement("//input[@type='email']");
	}

	public static WebElement next() {
		return Finder.findWebElement("//span[text()='Next']");

	}

	public static WebElement pass() {
		return Finder.findWebElement("//input[@type='password']");
	}
	
	public static WebElement loginWithGoogle()
	{
		return Finder.findWebElement("(//span[text()='or Login with']//following::a[@class='google'])[1]");
	}
}
