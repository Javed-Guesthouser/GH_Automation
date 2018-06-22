package Keywords;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.TestProject.myPack.Browser.GlobalVars;



public class Keywords {

	public static void typeText(WebElement elemet, String text) {
		try {
			elemet.sendKeys(text);
			GlobalVars.GHStepsReport = true;

		} catch (Exception ee) {
			GlobalVars.GHStepsReport = false;
		}
		System.out.println("Text typed ...flag status is:--" + GlobalVars.GHStepsReport);
	}

	public static void isElementPresent(WebElement elemet) {
		boolean flag = false;
		try {
			flag = elemet.isDisplayed();
			GlobalVars.GHStepsReport = flag;

		} catch (Exception ee) {
			GlobalVars.GHStepsReport = flag;
		}

	}

	public static void click(WebElement element) {
		try {
			element.click();
			GlobalVars.GHStepsReport = true;
		}

		catch (Exception ee) {
			GlobalVars.GHStepsReport = false;
			ee.printStackTrace();
		}
	}

	public static void clearEditField(WebElement element) {
		try {
			element.clear();
			GlobalVars.GHStepsReport = true;
		} catch (Exception ee) {

			GlobalVars.GHStepsReport = false;
		}
	}
	
	public static void waitForPageLoad(WebDriver driver) {
		try {
			driver.manage().timeouts().pageLoadTimeout(250, TimeUnit.SECONDS);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	
	public static void waitForPage(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	
	
}
