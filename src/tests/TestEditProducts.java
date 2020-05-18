package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.AddProducts;
import objects.EditProducts;
import objects.HomePage;
import utils.TxtReadLineUtils;

public class TestEditProducts extends WebdriverSuperClass {

	@Test(priority = 1) // Test method for Edit Products page opening
	public void testOpenEditProductsPage() {
		
		AddProducts.clickProductsBtn(driver);
		EditProducts.clickEditBtn(driver);

		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.2checkout.com/sandbox/products/edit_products";
		Assert.assertEquals(currentURL, expectedURL);
	}

	@Test(priority = 2) // Test method for editing price on all existing products

	public void editprice() {

		String[] locations = new String[5];
		for (int i = 0; i < 5; i++) {
			locations[i] = TxtReadLineUtils.readLine(37 + i);
			String price = EditProducts.getProductPrice(driver, locations[i]);
			double currentPrice = Double.valueOf(price);
			double editedPrice = currentPrice + 100;
			String finalPrice = Double.toString(editedPrice);
			EditProducts.editPrice(driver, finalPrice, locations[i]);
		}
		EditProducts.clickSaveChanges(driver);

		WebElement successful = driver.findElement(By.xpath(TxtReadLineUtils.readLine(43)));
		boolean ok = successful.isDisplayed();
		Assert.assertTrue(ok);
	}

	

}
