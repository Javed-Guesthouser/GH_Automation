package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Experiment {

	public static void main(String[] str) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.com");
	}
}
