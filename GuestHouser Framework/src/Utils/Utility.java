package Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.TestProject.myPack.Action;
import com.TestProject.myPack.Browser.GlobalVars;

import PageWisePOM.LoginFBPOM;
import PageWisePOM.LoginGooglePOM;
import PageWisePOM.LoginPOM;
import PageWisePOM.SignUpPOM;

public class Utility {
	String parentwindow = null;

	public void waitForElement(Integer Time) throws InterruptedException {
		String time = Time.toString();
		time = time.toString().concat("000");
		System.out.println("Time to wait is " + time + " miliseconds");
		Thread.sleep(Long.valueOf(time));
	}

	public void waitForElementVisible() {

	}

	public void validation() {
		System.out.println("assertion validation starts...");
		String theTextIWant = (String) ((JavascriptExecutor) GlobalVars.Web_Driver)
				.executeScript("return arguments[0].innerHTML;", SignUpPOM.passwordError());
		System.out.println(theTextIWant);
		System.out.println("*******" + SignUpPOM.passwordError().getAttribute("innerHTML"));
		Assert.assertEquals(theTextIWant, "  The password must be at least 6 characters.  ");
		System.out.println("assertion validation ends...");
	}

	public void SignUPvalidation() {
		WebElement nameError = SignUpPOM.nameError();
		System.out.println(nameError);
		WebElement emailError = SignUpPOM.emailError();
		System.out.println(emailError);
		WebElement passwordError = SignUpPOM.passwordError();
		System.out.println(passwordError);
		System.out.println("Validation starts...............");
		if (!(nameError.equals(null) && emailError.equals(null) && passwordError.equals(null))) {
			System.out.println("NAME, EMAIL and PASSWORD Fields are required...");
		} else {
			if (!nameError.equals(null)) {
				System.out.println("NAME Field is left EMPTY...");
			} else {
				if (!emailError.equals(null)) {
					System.out.println("EMAIL field is left EMTPY or EMAIL must be a Valid Email address...");
				} else {
					if (!passwordError.equals(null)) {
						System.out.println("PASSWORD field is left EMPTY or It should be atleast 6 characters...");
					}
				}
			}
		}
	}

	public void checkLoginStatus() throws InterruptedException {
		System.out.println("Validating login");
		Thread.sleep(10000);
		if (GlobalVars.Module_TestCase_Name.contains("Google")) {
			GlobalVars.Web_Driver.switchTo().window(parentwindow);
			System.out.println("Parent window switched in google...");
		}
		WebElement loginCnf = LoginPOM.confirmLogin();
		System.out.println("login confirmation is:-" + loginCnf);
		if (loginCnf != null) {
			System.out.println("Login successfull...");
			waitForElement(2);

			// new Action().logout();
		} else {
			System.out.println("Login not successfull...");
			Thread.sleep(2000);
			if (GlobalVars.Module_TestCase_Name.contains("Google")) {
				System.out.println("login with google going on..");
				GlobalVars.Web_Driver.close();
				GlobalVars.Web_Driver.switchTo().window(parentwindow);
				System.out.println("switched back to parent window");
			}
			LoginPOM.closeLoginDialog().click();
		}
	}

	public void checkFacebookLoginStatus() {
		GlobalVars.Web_Driver.close();
		GlobalVars.Web_Driver.switchTo().window(parentwindow);
		System.out.println("parent window title is:--" + GlobalVars.Web_Driver.getTitle());

		LoginFBPOM.closeLoginDialog().click();

	}

	public Object removeScientificNotation(Object number) {

		System.out.println("length of Number before parsing " + number.toString().length());

		if (number.toString().contains("E") && number.toString().contains(".")) {
			System.out.println("Number contains scientific notation...");
			System.out.println(String.format("%.0f", Integer.valueOf(number.toString())));
			return String.format("%.0f", Integer.valueOf(number.toString()));
		} else {
			return number;
		}

	}

	public void handleWindow() throws InterruptedException {
		// TODO Auto-generated method stub
		Set<String> windHandles = GlobalVars.Web_Driver.getWindowHandles();
		System.out.println("Total window handles are:--" + windHandles);
		parentwindow = windHandles.iterator().next();
		System.out.println("Parent window handles is:-" + parentwindow);

		List<String> list = new ArrayList<String>(windHandles);
		waitForElement(3);
		GlobalVars.Web_Driver.switchTo().window((list.get(list.size() - 1)));
		System.out.println("current window title is:-" + GlobalVars.Web_Driver.getTitle());
		return;
	}

	public String checkLastLogin(Object email) {
		// TODO Auto-generated method stub
		try {
			List<WebElement> list = LoginGooglePOM.alreadyLogged();
			System.out.println("already logged users are:--" + list);

			for (WebElement webElement : list) {
				if (webElement.getText().contains(email.toString())) {
					webElement.click();
					return "Yes";
				}

			}
			return "No";
		} catch (Exception e) {
			return "No";
		}
	}

	public void capturePassScreenShot() throws IOException {

		File src = ((TakesScreenshot) GlobalVars.Web_Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/ahmedjaved/Desktop/" + GlobalVars.PROJ_NAME + "/"
				+ GlobalVars.SUITE_NAME + "/Snapshots/Pass Images/" + GlobalVars.SCREEN_SHOT_NAME + " .png"));

	}

	public void captureFailScreenShot() throws IOException {

		File src = ((TakesScreenshot) GlobalVars.Web_Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/ahmedjaved/Desktop/" + GlobalVars.PROJ_NAME + "/"
				+ GlobalVars.SUITE_NAME + "/Snapshots/Fail Images/" + GlobalVars.SCREEN_SHOT_NAME + " .png"));

	}
}
