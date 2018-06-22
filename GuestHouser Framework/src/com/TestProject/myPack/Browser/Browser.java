package com.TestProject.myPack.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {

	public static void openBrowser(String browserName,String URL,String driverPath) throws InterruptedException {
		WebDriver driver = null;
		System.out.println("Browser to invoke sent by user :--"+browserName);
		if (browserName.toLowerCase().contains("chrome")) {
			System.out.println("Browser Request sent is chrome...");
			System.out.println("driver path obtained is:-"+driverPath);
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.get(URL);
			Thread.sleep(2000);
		} else if (browserName.toLowerCase().contains("firefox")) {
			System.out.println("Firefox yet to be implemented");
		} else if (browserName.toLowerCase().contains("safari")) {
			System.out.println("Browser Request sent is safari...");
			driver = new SafariDriver();
			driver.get("http://qa3.guesthouser.com/");
			driver.manage().window().maximize();
		}
		GlobalVars.Web_Driver = driver;
	}
}
