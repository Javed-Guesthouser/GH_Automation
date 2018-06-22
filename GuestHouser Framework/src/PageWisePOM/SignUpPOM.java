package PageWisePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProject.myPack.Finder;
import com.TestProject.myPack.Browser.GlobalVars;

public class SignUpPOM {
	static WebDriverWait wait = new WebDriverWait(GlobalVars.Web_Driver, 20);

	public static WebElement signUpButton() {
		return Finder.findWebElement("//li//a[@title='login']");
	}

	public static WebElement signUpWithEmail() {
		// return Finder.findWebElement("//div[@class='signup-with signup']");
		return Finder.findWebElement("//div[@class='content']//*[text()=' Sign up with Email']");
	}

	public static WebElement name() {
		// WebElement element = Finder.findWebElement("//input[@class='form-control
		// user-name' and @name='email']");
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		System.out.println("element found is:--" + element);
		if (element == null) {
			element = Finder.findWebElement("//input[@id='name']");
		}
		System.out.println("Element found is:-" + element);
		return element;
	}

	public static WebElement lName() {
		return Finder.findWebElement("//input[@id='lastname']");
	}

	public static WebElement email() {
		return Finder.findWebElement("//input[@id='email']");
	}

	public static WebElement password() {
		return Finder.findWebElement("//input[@id='pwd']");
	}

	public static WebElement submit() {
		return Finder.findWebElement("//button//span[text()='Sign up']");

	}

	public static WebElement validateSignUp() {
		// WebElement element =
		// Finder.findWebElement("//div[@class='modal-content']//div[@class='varify' and
		// @id='profile-section']");
		// WebElement element =
		// Finder.findWebElement("//div[@class='container']//nav/ul/li/a/span");

		WebElement element = null;
		System.out.println("validating singnUp in POM");
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='modal-content']//div[@class='varify' and @id='profile-section']")));
		} catch (Exception e) {
			return null;
		}

		return element;
	}

	public static WebElement emailError() {
		return Finder.findWebElement("//span[@id='signup_email_error']");
	}

	public static WebElement nameError() {
		return Finder.findWebElement("//span[@id='signup_name_error']");
	}

	public static WebElement passwordError() {
		return Finder.findWebElement("//span[contains(text(),'  The password must be at least 6 characters.  ')]");
		// return Finder.findWebElementById("signup_passord_error");
	}

	public static WebElement closeSignUpDialog() {
		return Finder.findWebElement("(//button[@type='button' and @class='close'])[1]");
	}

	public static WebElement logOutButton() {
		// return Finder.findWebElement("//div[@class='container']//nav/ul/li/a/span");
		WebDriverWait wait1 = new WebDriverWait(GlobalVars.Web_Driver, 30);
		WebElement element = wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']//nav/ul/li/a/span")));
		return element;

	}

	public static WebElement logOut() {
		return Finder.findWebElement("//a[text()='Logout']");

	}

	public static WebElement fillPhoneNumber() {
		return Finder.findWebElement("//input[@id='contact_otp_call']");
	}

	public static WebElement completeProfile() {
		return Finder.findWebElement("//button[@id='complete_profile_save']");
	}

}
