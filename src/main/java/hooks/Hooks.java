package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Generic_Utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public WebDriver driver;
	Properties p;

	@Before
	public void setup() throws IOException {
		driver = Generic_Utilities.BaseClass.initilizeBrowser();

		p = Generic_Utilities.BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@After
	public void tearDown() throws InterruptedException {

		
            driver.quit();
            Thread.sleep(5000);
     

	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		// this is for cucumber junit report
		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

	}

}
