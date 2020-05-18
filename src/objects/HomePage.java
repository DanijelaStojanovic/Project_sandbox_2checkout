package objects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TxtReadLineUtils;

public class HomePage {

	// Method for opening HomePage
	public static void openHome(WebDriver wd) {
		wd.get(TxtReadLineUtils.readLine(3));
	}

	// Method for navigation to HomePage from other page
	public static void navigateToHome(WebDriver wd) {
		wd.navigate().to(TxtReadLineUtils.readLine(3));
	}

	// Method to find Username input field
	public static WebElement getUsername(WebDriver wd) {
		return wd.findElement(By.xpath(TxtReadLineUtils.readLine(9)));
	}

	// Method to click on Username input field
	public static void clickUsername(WebDriver wd) {
		getUsername(wd).click();
	}

	// Method to set random Username
	public static void inputUsername(WebDriver wd) {
		WebElement elem = getUsername(wd);
		elem.click();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(30);
		elem.sendKeys("danijela" + randomInt);
	}

	// Method to find Password input field
	public static WebElement getPassword(WebDriver wd) {
		return wd.findElement(By.xpath(TxtReadLineUtils.readLine(10)));
	}

	// Method to click on Password input field
	public static void clickPassword(WebDriver wd) {
		getPassword(wd).click();
	}

	// Method to set random Password
	public static void inputPassword(WebDriver wd) {
		WebElement elem = getPassword(wd);
		elem.click();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(30);
		elem.sendKeys("Lelilija" + randomInt);
	}
	// Method for click on Log In to your account button
		public static void clickLogInBtn(WebDriver wd) {
			wd.findElement(By.xpath(TxtReadLineUtils.readLine(11))).click();
		}
}