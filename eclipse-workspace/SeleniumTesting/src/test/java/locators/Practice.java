package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// TRYING TO TEST GITHUB
		driver.get("https://automationtesting.co.uk/");

		System.out.println("Completed");
		System.out.println("GitHub TestProject2");

		driver.quit();
	}

}
