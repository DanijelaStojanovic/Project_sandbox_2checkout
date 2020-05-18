package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import objects.HomePage;
import utils.TxtReadLineUtils;

public class TestHomePage extends WebdriverSuperClass {

	@Test(priority = 1) // Test method for home page opening
	public void openHomePage() {
		HomePage.openHome(driver);
		driver.manage().window().maximize();
		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox";
		Assert.assertEquals(current, expected);
	}

	@Test(priority = 2) // Test method for navigation to home page
	public void navigateHomePage() {
		HomePage.navigateToHome(driver);
		driver.manage().window().maximize();
		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox";
		Assert.assertEquals(current, expected);
	}

	@Test(priority = 3) // method to test logIn attempt without previous registration
	public void LogInWithoutRegistration() {
		HomePage.inputUsername(driver);
		HomePage.inputPassword(driver);
		HomePage.clickLogInBtn(driver);

		// Testing of unsuccessful login. Test should pass for unsuccessful login.

		String current = driver.findElement(By.xpath(TxtReadLineUtils.readLine(12))).getText();
		String expected = "Incorrect username or password.";
		Assert.assertEquals(current, expected);
	}

}
