
package poynt.qa.automation.execution;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

/**
 * 
 * @author adharwa
 *
 */
public class Application {

	private final static Logger logger = LogManager.getLogger(Application.class);

	/**
	 * This will initiate test execution based on properties of device.yml &
	 * testng.xml
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		List<XmlSuite> suites;
		String xmlSuiteFile = null;
		try {
				xmlSuiteFile = System.getProperty("xmlSuiteFile", "src/main/resources/testng.xml");

			if (StringUtils.isNotEmpty(xmlSuiteFile)) {
				suites = new Parser(xmlSuiteFile).parseToList();
			//	suites.get(0).getParameters().put("configFilePath", configFilePath == null ? "" : configFilePath);

				TestNG testNGRun = new TestNG();
				testNGRun.setXmlSuites(suites);
				testNGRun.run();
			} else {
				logger.error("Error starting the application. testNG.xml file is not supplied. Stopping the app.");
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.error("Error starting the application.", e);
		}

	}

}
