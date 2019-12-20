package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.ExtentTestManager;

public class HowzatHomePage extends BasePage{

	public HowzatHomePage(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	/********************Object Repositories***************************/
	@AndroidFindBy(xpath = "//android.view.View[contains(@text, 'Register Now')]")
    private AndroidElement registerButton;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@text, 'Download App')]")
    private AndroidElement downloadButton;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@text, 'Login')]")
    private AndroidElement loginButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'Continue')]")
    private AndroidElement continueButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'button_primary')]")
    private AndroidElement downloadOkButton;
	/***********************Methods************************************/

	public void clickRegisterButton() {
		registerButton.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Register button successfully clicked.");
    }

	public void downloadApk() {
		//Click the download button
		downloadButton.click();
		try {
		if(continueButton.isDisplayed()) 
		continueButton.click();
		 String webContext = ((AndroidDriver)driver).getContext();
		    Set<String> contexts = ((AndroidDriver)driver).getContextHandles();
		    for (String context: contexts){
		        if (context.contains("NATIVE_APP")){
		            ((AndroidDriver)driver).context(context);
		            break;
		        }
		    }
		    driver.findElement(By.id("android:id/button1")).click();
		    contexts = ((AndroidDriver)driver).getContextHandles();
		    for (String context: contexts){
		        if (context.contains("NATIVE_APP")){
		            ((AndroidDriver)driver).context(context);
		            break;
		        }
		    }
		    driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'permission_allow_button')]")).click();
		    ((AndroidDriver)driver).context(webContext);
		    
		}
		catch(Exception e) {
			System.out.println("Permission to download is already allowed");
		}
		
		//Accept the apk download warning and click ok
		downloadOkButton.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "APK successfully downloaded.");
    }
	
	public void clickLoginButton() {
		loginButton.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Login button successfully clicked.");
    }
	
}
