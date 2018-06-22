package Actions;

import org.openqa.selenium.WebElement;

import PageWisePOM.LoginGooglePOM;

public class LoginGoogle {

	public void clickLoginButton() {
		WebElement element = LoginGooglePOM.loginButton();
		element.click();
	}

	public void alreadyMember() {
		WebElement element = LoginGooglePOM.alredyMember();
		element.click();
	}

	public void clickGoogleIcon() {
		WebElement element = LoginGooglePOM.loginWithGoogle();
		element.click();
	}

	public void loginWithAnotherUser() {
		WebElement element = LoginGooglePOM.useAnotherAcct();
		element.click();
	}

	public void enterEmail(Object email) {
		WebElement element = LoginGooglePOM.email();
		element.sendKeys(email.toString());
	}

	public void enterPassword(Object pass) {
		WebElement element = LoginGooglePOM.pass();
		element.sendKeys(pass.toString());
	}

	public void clickSignIn() {
		WebElement element = LoginGooglePOM.next();
		element.click();
	}

	public void clickNext() {
		WebElement next = LoginGooglePOM.next();
		next.click();
	}
}
