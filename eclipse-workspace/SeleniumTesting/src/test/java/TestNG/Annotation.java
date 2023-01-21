package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotation {
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://teststore.automationtesting.co.uk");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[title='Log in to your customer account'] span[class='hidden-sm-down']"))
				.click();
		System.out.println("SignIn Button Clicked");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[class='form-control']")).sendKeys("test@test.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[title='At least 5 characters long']")).sendKeys("test123");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#submit-login")).click();
		Thread.sleep(2000);
		System.out.println("Sucessfully LoggedIN");
	}

	@Test
	public void open() throws InterruptedException {
		driver.findElement(By.linkText("CLOTHES")).click();
		Thread.sleep(2000);
		System.out.println("Clothes link has been clicked");
	}

	@Test
	public void art() throws InterruptedException {
		driver.findElement(By.linkText("ART")).click();
		Thread.sleep(3000);
		System.out.println("Art link has been clicked");
	}

	@AfterSuite
	public void tearDown() throws InterruptedException {
		driver.findElement(By.cssSelector(".logout.hidden-sm-down")).click();
		Thread.sleep(3000);
		System.out.println("Sucessfully Logged Out");
		driver.close();
		driver.quit();
	}
}
