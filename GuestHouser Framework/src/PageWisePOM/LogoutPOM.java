package PageWisePOM;

import org.openqa.selenium.WebElement;

import com.TestProject.myPack.Finder;

public class LogoutPOM {

	public static WebElement logoutButton() {
		return Finder.findWebElement("(//header//div[@class='container']//nav/ul/li)[1]/a//span");
	}

	public static WebElement logout() {
		return Finder.findWebElement("//header//div[@class='container']//nav/ul//li//ul//li[8]/a");
	}

	public static WebElement verifyLogout() {
		return Finder.findWebElement("//li//a[@title='login']");
	}
}
