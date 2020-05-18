package objects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.TxtReadLineUtils;

public class SignUp {

	// Method to navigate to Sign up/ registration page
	public static void navigateToSignUp(WebDriver wd) {
		wd.navigate().to(TxtReadLineUtils.readLine(5));
	}

	// Method to navigate from Home Page using SignUp link
	public static void linkNavigateSignUp(WebDriver wd) {
		HomePage.navigateToHome(wd);
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(14))).click();
	}

	// Method for input random username for single user to field Username
	public static void inputRandomUsername(WebDriver wd) {
		WebElement user = wd.findElement(By.xpath(TxtReadLineUtils.readLine(15)));
		user.click();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(30);
		user.sendKeys("danijela" + randomInt);
	}

	// Method for input random mail for single user to field email
	public static void inputRandomEmail(WebDriver wd) {
		WebElement mail = wd.findElement(By.xpath(TxtReadLineUtils.readLine(16)));
		mail.click();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(30);
		mail.sendKeys("lela" + randomInt + "@gmail.com");
	}
	//method for input from file to field Username
	public static void inputUsername(WebDriver wd, String username) {
		WebElement user = wd.findElement(By.xpath(TxtReadLineUtils.readLine(15)));
		user.sendKeys(username);
	}
	//method for input from file to field email
		public static void inputEmail(WebDriver wd, String email) {
			WebElement mail = wd.findElement(By.xpath(TxtReadLineUtils.readLine(16)));
			mail.sendKeys(email);
		}

	// Method for input to field Password
	public static void inputPassword(WebDriver wd, String password) {
		WebElement pass = wd.findElement(By.xpath(TxtReadLineUtils.readLine(17)));
		pass.click();
		pass.sendKeys(password);
	}

	// Method for input to field Confirm Password
	public static void inputConfirmPassword(WebDriver wd, String confirmpass) {
		WebElement confirm = wd.findElement(By.xpath(TxtReadLineUtils.readLine(18)));
		confirm.click();
		confirm.sendKeys(confirmpass);
	}

	// Method for choosing option from "Tell us about yourself" dropdown list
	public static void inputAboutYou(WebDriver wd, String option) {
		Select aboutYou = new Select(wd.findElement(By.xpath(TxtReadLineUtils.readLine(19))));
		aboutYou.selectByVisibleText(option);
	}

	// Method for click on Dig In & Start testIng button
	public static void clickSubmitSignUp(WebDriver wd) {
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(20))).click();
	}
	//Method for click on account avatar icon on dashboard page
	public static void clickAvatarIcon (WebDriver wd) {
		wd.findElement(By.xpath(TxtReadLineUtils.readLine(22))).click();
	}
	//Method for click on Log Out button
		public static void clickLogOutBtn (WebDriver wd) {
			wd.findElement(By.xpath(TxtReadLineUtils.readLine(23))).click();
		}
}
