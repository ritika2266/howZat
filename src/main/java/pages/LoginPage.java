package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.ExtentTestManager;

public class LoginPage extends BasePage{

	public LoginPage(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	
	/***********************Methods************************************/

	public void login(String username, String password) {
		//Enter UserName
		driver.findElement(By.xpath("//input[@placeholder='Email or mobile']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Email or mobile']")).sendKeys(username);

		//Enter Password
		driver.findElement(By.xpath("//input[@placeholder='Password")).click();
		driver.findElement(By.xpath("//input[@placeholder='Password")).sendKeys(username);
		
		//Click on 'Register forFree' button
		driver.findElement(By.xpath("//button/span[contains(., 'Login')]")).click();

	}
}
