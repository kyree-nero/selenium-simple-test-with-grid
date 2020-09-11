package sample;

import java.net.URL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleRemoteIT {
	@Test
	@DisplayName("simple google grid test")
	public void test() throws Exception{
		String nodeURL = "http://localhost:4545/wd/hub"; //http://192.168.50.136:4545/grid/console
		FirefoxOptions ffOptions = new FirefoxOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.LINUX);
		WebDriver driver = new RemoteWebDriver(new URL(nodeURL), capabilities);   
		driver.get("http://www.google.com");
		driver.quit();
	}
}

