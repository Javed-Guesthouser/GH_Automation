package Actions;

import org.openqa.selenium.WebElement;

import PageWisePOM.LoginFBPOM;

public class LoginFacebook {

	public void enterMail(Object email) {
		WebElement element = LoginFBPOM.email();
		element.clear();
		element.sendKeys(email.toString());
	}

	public void enterPassword(Object pass) {
		WebElement element = LoginFBPOM.password();
		element.clear();
		element.sendKeys(pass.toString());
	}

	public void clickLoginButton() {
		WebElement element = LoginFBPOM.loginButton();
		element.click();
	}

	public void clickAlreadyMember() {
		WebElement element = LoginFBPOM.alredyMember();
		element.click();
	}

	public void clickFBIcon() {
		WebElement element = LoginFBPOM.loginWithFacebook();
		element.click();
	}

	public void clicksubmit() {
		WebElement element = LoginFBPOM.submit();
		element.click();
	}
}
