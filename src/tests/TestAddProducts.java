package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.HomePage;
import objects.AddProducts;

import utils.ExcelUtils;
import utils.TxtReadLineUtils;

public class TestAddProducts extends WebdriverSuperClass {

	@Test(priority = 1) // Test method for Products page opening

	public void testOpenProductsPage() {

		HomePage.openHome(driver);
		driver.manage().window().maximize();

		WebElement username = HomePage.getUsername(driver);
		username.click();
		username.sendKeys("Lelilija");

		WebElement password = HomePage.getPassword(driver);
		password.click();
		password.sendKeys("Bat19210");
		HomePage.clickLogInBtn(driver);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TxtReadLineUtils.readLine(24))));
		AddProducts.clickProductsBtn(driver);
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.2checkout.com/sandbox/products/";
		Assert.assertEquals(currentURL, expectedURL);
	}

	@Test(priority = 2) // Test method for click on add new product button
	public void testClickAddNewProduct() {
		AddProducts.clickAddNewProduct(driver);
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.2checkout.com/sandbox/products/create_product";
		Assert.assertEquals(currentURL, expectedURL);
	}

	@Test(priority = 3) // Test method for adding new product using data from excel file
	public void testAddNewProducts() {

		ExcelUtils.setExcel("ProductData.xls");
		ExcelUtils.setWorkSheet(0);

		for (int i = 1; i < 6; i++) {

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			AddProducts.clickProductsBtn(driver);
			AddProducts.clickAddNewProduct(driver);
			AddProducts.inputProductName(driver, ExcelUtils.getDataAt(i, 1));
			AddProducts.inputProductID(driver, ExcelUtils.getDataAt(i, 2));
			AddProducts.inputProductPrice(driver, ExcelUtils.getDataAt(i, 3));
			AddProducts.clickSaveChanges(driver);

			WebElement successful = driver.findElement(By.xpath(TxtReadLineUtils.readLine(32)));
			boolean ok = successful.isDisplayed();
			Assert.assertTrue(ok);

		}
		ExcelUtils.closeExcel();
	}

	
}