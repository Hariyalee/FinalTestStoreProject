package Buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationtesting.co.uk/popups.html");

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("[onclick='alertTrigger\\(\\)']")).click();

		Thread.sleep(2000);

		driver.switchTo().alert().accept();

		System.out.println("Completed Sucessfully");

		driver.quit();
	}

}
