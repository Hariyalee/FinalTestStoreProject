package Buttons;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUp {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationtesting.co.uk/popups.html");

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[onclick='popup()']")).click();
		String MainWindow = driver.getWindowHandle();
		System.out.println(MainWindow);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterate = handles.iterator();

		while (iterate.hasNext()) {

			String child = iterate.next();

			if (!MainWindow.equalsIgnoreCase(child)) {
				Thread.sleep(2000);
				driver.switchTo().window(child);
				driver.close();
			}

		}
		Thread.sleep(2000);
		driver.switchTo().window(MainWindow);
		driver.findElement(By.cssSelector("button[onclick='alertTrigger()']")).click();
		Thread.sleep(2500);
		System.out.println("Completed");
		driver.quit();
	}

}
