package tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverSuperClass {
	//Superclass for initializing and closing the WebDriver for all testNG classes
	
	
  	public static WebDriver driver;
  	
  	@BeforeSuite
	public void welcome() {
		System.out.println(
				"Welcome to testing website  https://sandbox.2checkout.com/sandbox using Selenium WebDriver and TestNG");
	}
  	
	@BeforeTest
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterTest
	public static void closeDriver() {
		driver.close();
	}
	

	@AfterSuite
	public void goodbye() {
		System.out.println("Thank you for testing with us!");
	}
}
