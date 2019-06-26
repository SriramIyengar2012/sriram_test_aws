package Utilities;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {



    @BeforeSuite
    public void getBrowser() throws Exception {
        if (System.getenv("browser").equals("chrome")) {
            DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
            capabilities.setCapability("version", "");
            capabilities.setPlatform(Platform.LINUX);

            VariableDefinitions.setDriver(new RemoteWebDriver(new URL("http://grid:4444/wd/hub"), capabilities));
            VariableDefinitions.getDriver().manage().window().maximize();

        }
        if (System.getenv("browser").equals("firefox")) {
            DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
            capabilities.setCapability("version", "");
            capabilities.setPlatform(Platform.LINUX);

            VariableDefinitions.setDriver(new RemoteWebDriver(new URL("http://grid:4444/wd/hub"), capabilities));
            VariableDefinitions.getDriver().manage().window().maximize();

        }

    }
        @AfterSuite
        public void closeBrowser() {
            VariableDefinitions.getDriver().quit();

        }


    }

