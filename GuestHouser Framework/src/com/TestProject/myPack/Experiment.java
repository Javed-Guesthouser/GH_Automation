package com.TestProject.myPack;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Experiment {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		System.out.println("first run....");
		 System.setProperty("webdriver.chrome.driver", "/Users/ahmedjaved/Downloads/chromedriver 2"); WebDriver driver = new ChromeDriver();
		//driver = new SafariDriver();
		driver.get("http://qa2.guesthouser.com/");
		driver.manage().window().maximize();
		System.out.println("browser maximised");

		Experiment exp = new Experiment();
		exp.clickSnapForQueryWindow(driver);
		exp.clickSnapShotForLogoutScreen(driver);
		exp.gh_Login(driver);
		 exp.bookTrip(driver, "Goa", "31/05/2018", "15/06/2018");
		Thread.sleep(10000);

		System.out.println("session closed...");
	}

	public void clickSnapForQueryWindow(WebDriver driver) throws InterruptedException, IOException {
		
		//driver.findElement(By.xpath("//div[@class='phpdebugbar phpdebugbar-closed']//a[@class='phpdebugbar-restore-btn']")).click();
		Thread.sleep(5000);
		takeScreenShot(driver, "query");
		Thread.sleep(5000);
		takeScreenShot(driver,"query1");

//		driver.findElement(By.xpath("//div[@class='phpdebugbar-header-right']//a[@class='phpdebugbar-open-btn']")		.click();
		Thread.sleep(5000);
		takeScreenShot(driver,"query3");
		Thread.sleep(10000);
		takeScreenShot(driver,"query4");
	}

	public void clickSnapShotForLogoutScreen(WebDriver driver) throws InterruptedException, IOException {
		driver.navigate().to("http://qa2.guesthouser.com/");
		Thread.sleep(2000);
		takeScreenShot(driver,"logoutscreen");
	}

	public void gh_Login(WebDriver driver) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//li//a[@title='login']")).click();
		takeScreenShot(driver,"login1");
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[text()='Already have an account? Log in']"))));
		takeScreenShot(driver,"login2");
		driver.findElement(By.xpath("//div[text()='Already have an account? Log in']")).click();
		takeScreenShot(driver,"login3");
		driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("jimmyjavid@gmail.com");
		takeScreenShot(driver,"login4");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("Password1");
		takeScreenShot(driver,"login5");
		driver.findElement(By.xpath("//button[@id='login_new_popup']")).click();
		takeScreenShot(driver,"login6");

		System.out.println("Login successfull");
		takeScreenShot(driver,"login7");
	}

	private void bookTrip(WebDriver driver, String place, String checkInDate, String checkOutDate)
			throws InterruptedException, IOException {
		System.out.println("checkindate obtained is:-" + checkInDate);
		String checkInMonth = evaluateMonth(checkInDate);
		System.out.println("Month obtained is:-" + checkInMonth);
		String checkOutMonth = evaluateMonth(checkOutDate);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys(place);
		takeScreenShot(driver,"trip1");
		driver.findElement(By.xpath("//input[@id='checkin']")).click();
		takeScreenShot(driver,"trip2");
		WebElement monthgot = driver
				.findElement(By.xpath("(//table[@class='table-condensed']//tr//th[@class='month'])[1]"));
		takeScreenShot(driver,"trip3");
		
		System.out.println("**" + monthgot.getText().toLowerCase());
		/*while (!monthgot.getText().toLowerCase().contains(checkInMonth)) {
			System.out.println("##" + monthgot.getText().toLowerCase());
			driver.findElement(By.xpath("//th[@class='next available']")).click();
			Thread.sleep(10000);
		}*/
		takeScreenShot(driver,"trip4");
		takeScreenShot(driver,"trip5");
		takeScreenShot(driver,"trip6");
		takeScreenShot(driver,"trip7");

	}

	public void placeshot(WebDriver driver) throws IOException, InterruptedException {
		takeScreenShot(driver,"location1");
		Thread.sleep(2000);
		takeScreenShot(driver,"location2");
		Thread.sleep(2000);
		takeScreenShot(driver,"location3");

	}

	private String evaluateMonth(String date) {
		String[] Date = date.split("/");
		String month = null;
		switch (Date[1]) {
		case "01":
			month = "january";
			break;
		case "02":
			month = "february";
			break;
		case "03":
			month = "march";
			break;
		case "04":
			month = "april";
		case "05":
			month = "may";
		case "06":
			month = "june";
		case "07":
			month = "july";
		case "08":
			month = "august";
		case "09":
			month = "september";
		case "10":
			month = "october";
		case "11":
			month = "november";
		case "12":
			month = "december";

		}
		return month;
	}

	public void takeScreenShot(WebDriver driver,String snapshot) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("/Users/ahmedjaved/Desktop/Screenshots/"+snapshot+".png"));
		System.out.println("Snapshot clicked...");
	}
}
