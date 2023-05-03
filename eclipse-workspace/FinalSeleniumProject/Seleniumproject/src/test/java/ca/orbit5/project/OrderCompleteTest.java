package ca.orbit5.project;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import base.BasePage;
import pageObjects.HomePage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomePage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners (resources.Listeners.class)
public class OrderCompleteTest extends BasePage {

	public OrderCompleteTest() throws IOException {
		super();
		
	}

	@BeforeTest
	public void setup() throws IOException, InterruptedException {
	driver=getDriver();
	driver.get(getUrl());
	Thread.sleep(10000);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
	@Test
	public void endtoEndTest() throws InterruptedException {
		//System.out.println("My test is running fine");
		/*HomePage homepage= new HomePage(driver);*/
		/*Thread.sleep(6000);
		getabc().click();*/
		

		ShopHomePage shopHome = new ShopHomePage(driver);
		shopHome.getProdOne().click();
		
		ShopProductPage shopProd = new ShopProductPage(driver);
		Select option= new Select(shopProd.getSizeOption());
		Thread.sleep(7000);
		option.selectByVisibleText("M");
		Thread.sleep(7000);
		shopProd.getQuantIncrease().click();
		Thread.sleep(7000);
		shopProd.getAddToCartBtn().click();
		
		
		ShopContentPanel cPanel = new ShopContentPanel(driver);
		Thread.sleep(7000);
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart(driver);
		cart.getHavePromo().click();
		Thread.sleep(5000);
		cart.getPromoTextbox().sendKeys("20OFF");
		Thread.sleep(5000);
		cart.getPromoAddBtn().click();
		Thread.sleep(5000);
		cart.getProceedCheckoutBtn().click();
		Thread.sleep(5000);
		
		OrderFormPersInfo pInfo= new OrderFormPersInfo(driver);
		pInfo.getGenderMr().click();
		pInfo.getFirstNameField().sendKeys("Hariyalee");
		pInfo.getLastnameField().sendKeys("Patel");
		pInfo.getEmailField().sendKeys("hariyaleepatel@test.com");
		pInfo.getTermsConditionsCheckbox().click();
		Thread.sleep(7000);
		pInfo.getContinueBtn().click();
		
		OrderFormDelivery orderDelivery = new OrderFormDelivery(driver);
		orderDelivery.getAddressField().sendKeys("123 John Street");
		orderDelivery.getCityField().sendKeys("Houston");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderDelivery.getPostcodeField().sendKeys("77021");
		Thread.sleep(7000);
		orderDelivery.getContinueBtn().click();

		// creating an object of the shipping method page
		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod(driver);
		shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
		Thread.sleep(7000);
		shipMethod.getContinueBtn().click();

		// creating an object of the payment options page
		OrderFormPayment orderPay = new OrderFormPayment(driver);
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		Thread.sleep(7000);
		orderPay.getOrderBtn().click();
		
	}

	
}
