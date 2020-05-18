package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.TxtReadLineUtils;

public class AddProducts {

	// Method to navigate to Products page
	public static void navigateToProducts(WebDriver wd) {
		wd.navigate().to(TxtReadLineUtils.readLine(6));
	}

	// Method for navigate to Products page using Products menu button
	public static void clickProductsBtn(WebDriver wd) {
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(24))).click();
	}

	// Method for adding new product
	public static void clickAddNewProduct(WebDriver wd) {
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(26))).click();
	}

	// Method for input to Product Name field
	public static void inputProductName(WebDriver wd, String name) {
		WebElement productName = wd.findElement(By.xpath(TxtReadLineUtils.readLine(28)));
		productName.click();
		productName.sendKeys(name);
	}

	// Method for input to Your Product ID field
	public static void inputProductID(WebDriver wd, String id) {
		WebElement productId = wd.findElement(By.xpath(TxtReadLineUtils.readLine(29)));
		productId.click();
		productId.sendKeys(id);
	}

	// Method for input to Product Price field
	public static void inputProductPrice(WebDriver wd, String price) {
		WebElement productPrice = wd.findElement(By.xpath(TxtReadLineUtils.readLine(30)));
		productPrice.click();
		productPrice.sendKeys(price);
	}

	// Method for click on Save Changes button
	public static void clickSaveChanges(WebDriver wd) {
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(31))).click();
	}

}
