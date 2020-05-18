package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import objects.HomePage;
import objects.SignUp;
import utils.ExcelUtils;

public class TestSignUpLogInMultipleUsers extends WebdriverSuperClass {

	@BeforeClass
	public void setupPage() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		HomePage.openHome(driver);
		driver.manage().window().maximize();

	}

	@Test(priority = 1) // Test method to input registration data from provided excel file
	public void testSignUpFromExcelFile() {

		ExcelUtils.setExcel("SignUpData.xls");
		ExcelUtils.setWorkSheet(0);

		for (int i = 1; i < 31; i++) {

			SignUp.linkNavigateSignUp(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			SignUp.inputUsername(driver, ExcelUtils.getDataAt(i, 1));
			SignUp.inputEmail(driver, ExcelUtils.getDataAt(i, 2));
			SignUp.inputPassword(driver, ExcelUtils.getDataAt(i, 3));
			SignUp.inputConfirmPassword(driver, ExcelUtils.getDataAt(i, 4));
			SignUp.inputAboutYou(driver, ExcelUtils.getDataAt(i, 5));

			SignUp.clickSubmitSignUp(driver);

			String currentURL = driver.getCurrentUrl();
			String expectedURL = "https://sandbox.2checkout.com/sandbox/home/dashboard";
			Assert.assertEquals(currentURL, expectedURL);

			SignUp.clickAvatarIcon(driver);
			SignUp.clickLogOutBtn(driver);
		}
		ExcelUtils.closeExcel();

	}

	@Test(priority = 2) // Test method to input login data from provided excel file
	public void testLogInFromExcelFile() {

		ExcelUtils.setExcel("SignUpData.xls");
		ExcelUtils.setWorkSheet(0);

		for (int i = 1; i < 31; i++) {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement username = HomePage.getUsername(driver);
			username.click();
			username.sendKeys(ExcelUtils.getDataAt(i, 1));

			WebElement password = HomePage.getPassword(driver);
			password.click();
			password.sendKeys(ExcelUtils.getDataAt(i, 3));
			HomePage.clickLogInBtn(driver);

			String currentURL = driver.getCurrentUrl();
			String expectedURL = "https://sandbox.2checkout.com/sandbox/home/dashboard";
			Assert.assertEquals(currentURL, expectedURL);

			SignUp.clickAvatarIcon(driver);
			SignUp.clickLogOutBtn(driver);
		}
		ExcelUtils.closeExcel();

	}

}
