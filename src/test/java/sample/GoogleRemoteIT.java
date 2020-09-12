package sample;

import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleRemoteIT {
	
	String nodeURL = "http://localhost:4545/wd/hub"; //http://192.168.50.136:4545/grid/console
	
	WebDriver fireFoxWebDriver = null;
	WebDriver chromeWebDriver = null;
	
	@BeforeEach public void setup() throws Exception {
		DesiredCapabilities fireFoxCapabilities = DesiredCapabilities.firefox();
		fireFoxCapabilities.setBrowserName("firefox");
		fireFoxCapabilities.setPlatform(Platform.LINUX);
		fireFoxWebDriver = new RemoteWebDriver(new URL(nodeURL), fireFoxCapabilities);   
		
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		chromeCapabilities.setBrowserName("chrome");
		chromeCapabilities.setPlatform(Platform.LINUX);
		chromeWebDriver = new RemoteWebDriver(new URL(nodeURL), chromeCapabilities);   
	}
	
	@Test
	@DisplayName("simple google ff grid test")
	public void testFirefox() throws Exception{
		fireFoxWebDriver.get("http://www.google.com");
	}
	
	@Test
	@DisplayName("simple google chr grid test")
	public void testChrome() throws Exception{
		chromeWebDriver.get("http://www.google.com");
	}
	
	@AfterEach public void teardown() {
		fireFoxWebDriver.quit();
		chromeWebDriver.quit();
	}
}

