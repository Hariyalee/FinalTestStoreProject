package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {

	public static WebDriver driver;
	private String url;
	private Properties prop;

	// Created constructor
	public BasePage() throws IOException {

	prop = new Properties();
	FileInputStream data = new FileInputStream(
	System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
	prop.load(data);
	
	}

	public WebDriver getDriver() throws IOException {

	if (prop.getProperty("browser").equals("edge")) {

	WebDriverManager.chromedriver().setup();
	//new lines
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	//My line//WebDriver driver = new ChromeDriver(options);
	driver = new ChromeDriver(options);
	} else if (prop.getProperty("browser").equals("firefox")) {

	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	} else {

	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	}

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	return driver;
	}

	public String getUrl() throws IOException {
	url = prop.getProperty("url");
	return url;
	}
	}
	
