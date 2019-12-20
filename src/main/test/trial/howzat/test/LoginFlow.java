package trial.howzat.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HowzatHomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import util.BaseTest;

public class LoginFlow extends BaseTest{
	private final static Logger logger = LogManager.getLogger(LoginFlow.class);

	@DataProvider(name = "registerationData")
	public static Object[][] registerationData() {
		return new Object[][] { { "howzatTest@yopmail.com", "Data@123" } };
	}
	
	/** REQUIREMENTS
	 * 1. Open a new mobile browser instance and hit “https://www.howzat.com.”
     * 2. Click on “Download App” CTA to download the APK file on a mobile device. 
     *  That should happen without manual interaction.
	 */
	@Test
	public void downloadApp() {
		HowzatHomePage homePage = new HowzatHomePage(driver);
		homePage.downloadApk();
        
	}
	
	/**]
	 * REQUIREMENTS
	 * 3. Click on “Register Now” CTA, which takes you to a new page with Sign Up form. 
	 * Register a new user by filling random( but keep that in memory/disk to be used later ) — 
	 * close this browser instance.
	 * @param loginEmail
	 * @param loginPassword
	 */
	@Test(dataProvider="registerationData")
	public void register(String loginEmail, String loginPassword) {
		HowzatHomePage homePage = new HowzatHomePage(driver);
		homePage.clickRegisterButton();
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.register(loginEmail, loginPassword);
	}

	/**
	 * REQUIREMENTS:
	 * 4. Open a new mobile browser instance and hit “https://www.howzat.com.”
     * 5. Click on “Login” CTA, which takes you to a new page with a login form. 
     * Use the credentials used during Sign Up and make user login.
	 * @param loginEmail
	 * @param loginPassword
	 */
	@Test(dataProvider="registerationData")
	public void login(String loginEmail, String loginPassword) {
		
		HowzatHomePage homePage = new HowzatHomePage(driver);
		homePage.clickLoginButton();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(loginEmail, loginPassword);
	}

}
