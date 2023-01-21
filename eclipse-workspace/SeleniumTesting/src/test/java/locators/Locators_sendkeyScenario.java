package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators_sendkeyScenario {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://automationtesting.co.uk");
		driver.findElement(By.partialLinkText("CONTACT")).click();
		driver.findElement(By.name("first_name")).sendKeys("Hariyalee");
		Thread.sleep(2500);
		driver.findElement(By.name("last_name")).sendKeys("Patel");
		Thread.sleep(2500);
		driver.findElement(By.name("email")).sendKeys("Hariyalee@gmail.com");
		Thread.sleep(2500);
		driver.findElement(By.name("message")).sendKeys("NoComments");
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("#form_buttons > input:nth-child(2)")).click();

		System.out.println("BYE");
		// Thread.sleep(5000);
		// driver.close();

	}

}
