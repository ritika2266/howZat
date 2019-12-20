**********Pre-requisite**********
- Fork the repo from poynt/appium
- Clone repository from git@github.com:<username>/appium.git
- Java home and Maven home should be setup.
- Android sdk tool and adb should be setup locally: https://stackoverflow.com/questions/31374085/installing-adb-on-macos
- Download any IDE Eclipse or IntelliJ
- Download Appium Desktop or command line version: https://github.com/appium/appium-desktop/releases/tag/v1.10.0
- Go to /mobile-tests-automation/src/main/resources/locators/web via terminal app and run the following command `chmod +x chromedriver` for mission control cases.

**********Setup**********
- Export project as Maven project.
- Run Maven install to download all dependencies (For eclipse only)
- If you are running from IDE, then Download and export [Lombok jar](https://projectlombok.org/download) explicitly.

**********IntelliJ Setup**********
 - After running through the setup, in order to add Lombok jar explicitly in Intellij, after importing right click on the mobile-tests-automation project, click on Module Settings, Click on the Dependencies tab, the plus sign and link to the lombok jar you downloaded.
 - IntelliJ will default associate the src/main/tests directory as a proper test source directory -- you have to change it to an actual source directory for the rest of the code to compile. In order to do this, in the Module Settings, under Sources, right click on the src/main/test directory and select Sources, and you should see it get added under Sources to the right.
 - Build within IntelliJ, not using maven.

**********Running test cases**********
- Setup deviceId and sdkPath to serial number of device and adb path respectively in src/main/resources>>device.yml.
- Set details of group, classes & package you want to run in src/main/resources >>testng.xml.
- Start Appium server (from Appium desktop application)
- Run Application.java available in poynt.qa.automation.execution under src/main/test.
- Report will generate under target/logs/ExtentReports

**********Creating test cases**********
- Run Appium inspector or Uiautomatorviewer to locate any object/element in device.
- Create property file under src/main/resources >> locators>> android and Add any locator identifier (i.e. Xpath, id, CSS) for desire object.
- Create java file under  src/main/test>> poynt.qa.automation.device.screen (note: follow naming convention of java file ended with Screen.java)
- Add constructor to java file with parameter of driver.
- Add page object respective to the locator identifier added in property file.
- Add mapping of property file and XXXscreen.java file in enum of src/main/test>> poynt.qa.automation.device.screen >> Screen.java
- Create java file under any  src/main/test>> poynt.qa.automation.device.tests.XXX and extend to BaseTest.java
- Initialize all screen classes in @beforeClass for object/element require for testing
- Write your test cases with assertion and events.
- Add your test class in src/main/resources >>testng.xml.
- Run Application.java

