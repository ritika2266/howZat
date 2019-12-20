package util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import pages.HowzatHomePage;

public class BaseTest {
	public AndroidDriver driver;
 
	public HowzatHomePage homePage;
    public  AndroidDriver getDriver() {
        return driver;
    }
 
    @BeforeClass
    public void classLevelSetup() {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("platformVersion", "6.0"); 
		capabilities.setCapability("deviceName","OnePlus6");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("browserName", "Chrome");
		//capabilities.setCapability("udid", "ZY2224KTHF");


	   
	 //  capabilities.setCapability("appPackage", "org.isoron.uhabits");
	// This package name of your app (you can get it from apk info app)
	//	capabilities.setCapability("appActivity","org.isoron.uhabits.MainActivity");
		   try {
			   RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				   


			//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.get("https://www.howzat.com");


		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
 
    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HowzatHomePage(driver);
    }
 
    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
