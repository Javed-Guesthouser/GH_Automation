package Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProject.myPack.Browser.GlobalVars;

import PageWisePOM.SignUpPOM;

public class SignUp {

	public void signUp1() {
		System.out.println("Scenario 1 with all valid Entries....");
		WebElement signUp = SignUpPOM.signUpButton();

		signUp.click();

	}

	public void signUpWithEmail() {
		System.out.println("Signing Up with Simple Email...");
		WebElement SEmail = SignUpPOM.signUpWithEmail();
		try {
			SEmail.click();
		} catch (Exception e) {
			System.out.println("Exception occured...");
		}
	}

	public void enterName(Object Name) throws InterruptedException {
		System.out.println("First Name for SignUp");

		WebElement email = SignUpPOM.name();
		try {
			email.clear();
			email.sendKeys(Name.toString());
		} catch (Exception e) {
			System.out.println(e.getClass());
		}
	}

	public void enterLName(Object lName) {
		System.out.println("Last Name for SIgnUp");
		WebElement lname = SignUpPOM.lName();
		lname.clear();
		lname.sendKeys(lName.toString());
	}

	public void enterEmail(Object email) {
		System.out.println("Entering Email ID");
		WebElement Email = SignUpPOM.email();
		Email.clear();
		Email.sendKeys(email.toString());
	}

	public void enterPassword(Object pwd) {
		System.out.println("Entering Password..");
		WebElement password = SignUpPOM.password();
		password.clear();
		password.sendKeys(pwd.toString());
	}

	public void submit() {
		System.out.println("clicking singUp");
		WebElement submit = SignUpPOM.submit();
		submit.click();
	}

	public void logout() {
		System.out.println("Logging out of current session...");
		WebElement logoutButton = SignUpPOM.logOutButton();
		logoutButton.click();
		WebElement logout = SignUpPOM.logOut();
		logoutButton.click();
	}

	public void enterPhoneNumber(Object phNo) {
		WebElement phoneField = SignUpPOM.fillPhoneNumber();
		phoneField.sendKeys(phNo.toString());
	}

	public void submitPhoneNumber() {
		WebElement submitProfile = SignUpPOM.completeProfile();
		submitProfile.click();
	}
}
