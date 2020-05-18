package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TxtReadLineUtils;

public class EditProducts {

	// Method for navigate to Edit Products page by clicking on Edit button from Products menu
	public static void clickEditBtn(WebDriver wd) {
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(35))).click();
	}

	// Method for selecting price field
	public static String getProductPrice(WebDriver wd, String locator) {
		WebElement priceField = wd.findElement(By.cssSelector(locator));
		priceField.click();
		String currentPrice = priceField.getAttribute("value");
		return currentPrice;
	}

	// Method for input to field price
	public static void editPrice(WebDriver wd, String price, String locator) {
		WebElement priceField = wd.findElement(By.cssSelector(locator));
		priceField.click();
		priceField.clear();
		priceField.sendKeys(price);
	}

	// Method for clicking on Save Product Changes button
	public static void clickSaveChanges(WebDriver wd) {
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(43))).click();
	}

	// Method for viewing all existing products 
	public static void clickViewBtn(WebDriver wd) {
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(46))).click();
	}

	// Method for selecting delete checkbox on existing product
	public static void selectDeleteCheckbox(WebDriver wd, String locator) {
		wd.findElement(By.xpath(locator)).click();
	}

	// Method for click on Delete products button
	public static void clickDeleteProducts(WebDriver wd) {
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(53))).click();
	}

	// Method for click on Confirm deletion button
	public static void clickConfirmDeletion(WebDriver wd) {
		WebDriverWait wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TxtReadLineUtils.readLine(54))));
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(54))).click();
	}
}