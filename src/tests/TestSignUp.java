package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import objects.HomePage;
import objects.SignUp;
import utils.TxtReadLineUtils;

public class TestSignUp extends WebdriverSuperClass {

	private static String about = "I don't have a website";

	@Test(priority = 1) // Test method for Sign Up page opening
	public void testOpenSignUpPage() {
		HomePage.openHome(driver);
		driver.manage().window().maximize();
		SignUp.navigateToSignUp(driver);
		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox/signup";
		Assert.assertEquals(current, expected);
	}

	@Test(priority = 2) // Test method for navigation from home page using SignUp link
	public void navigateToSignUpPage() {
		SignUp.linkNavigateSignUp(driver);
		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox/signup";
		Assert.assertEquals(current, expected);
	}

	@Test(priority = 3) // Test method for registration of one user
	public void testOneUserSignUp() {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TxtReadLineUtils.readLine(15))));

		SignUp.inputRandomUsername(driver);
		SignUp.inputRandomEmail(driver);
		SignUp.inputPassword(driver, "Lela12345");
		SignUp.inputConfirmPassword(driver, "Lela12345");
		SignUp.inputAboutYou(driver, about);
		SignUp.clickSubmitSignUp(driver);

		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		Assert.assertEquals(currentURL, expectedURL);
	}

	@Test(priority = 4) // Test method for registration without field Username
	public void testSignUpWithoutUsername() {

		SignUp.navigateToSignUp(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TxtReadLineUtils.readLine(16))));
		SignUp.inputRandomEmail(driver);
		SignUp.inputPassword(driver, "Lela12345");
		SignUp.inputConfirmPassword(driver, "Lela12345");
		SignUp.inputAboutYou(driver, about);
		SignUp.clickSubmitSignUp(driver);

		// expected result is unsuccessful registration
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		Assert.assertNotEquals(currentURL, expectedURL);
	}

	@Test(priority = 5) // Test method for registration without field email
	public void testSignUpWithoutEmail() {

		SignUp.navigateToSignUp(driver);
		SignUp.inputRandomUsername(driver);
		SignUp.inputPassword(driver, "Lela12345");
		SignUp.inputConfirmPassword(driver, "Lela12345");
		SignUp.inputAboutYou(driver, about);
		SignUp.clickSubmitSignUp(driver);

		// expected result is unsuccessful registration
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		Assert.assertNotEquals(currentURL, expectedURL);
	}

	@Test(priority = 6) // Test method for registration without field password
	public void testSignUpWithoutPassword() {

		SoftAssert sa = new SoftAssert();

		SignUp.navigateToSignUp(driver);
		SignUp.inputRandomUsername(driver);
		SignUp.inputRandomEmail(driver);
		SignUp.inputAboutYou(driver, about);
		SignUp.clickSubmitSignUp(driver);

		// expected result is unsuccessful registration
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		sa.assertNotEquals(currentURL, expectedURL);

		SignUp.inputConfirmPassword(driver, "Lela12345");
		SignUp.clickSubmitSignUp(driver);
		currentURL = driver.getCurrentUrl();
		expectedURL = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		sa.assertNotEquals(currentURL, expectedURL);

		sa.assertAll();
	}

	@Test(priority = 7) // Test method for registration without field confirm password
	public void testSignUpWithoutConfirmPassword() {

		SignUp.navigateToSignUp(driver);
		SignUp.inputRandomUsername(driver);
		SignUp.inputRandomEmail(driver);
		SignUp.inputPassword(driver, "Lela12345");
		SignUp.inputAboutYou(driver, about);
		SignUp.clickSubmitSignUp(driver);

		// expected result is unsuccessful registration
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		Assert.assertNotEquals(currentURL, expectedURL);
	}

	@Test(priority = 8) // Test method for registration without field 'Tell us about yourself'
	public void testSignUpWithoutAboutYou() {

		SignUp.navigateToSignUp(driver);
		SignUp.inputRandomUsername(driver);
		SignUp.inputRandomEmail(driver);
		SignUp.inputPassword(driver, "Lela12345");
		SignUp.inputConfirmPassword(driver, "Lela12345");
		SignUp.clickSubmitSignUp(driver);

		// expected result is unsuccessful registration
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		Assert.assertNotEquals(currentURL, expectedURL);
	}

}