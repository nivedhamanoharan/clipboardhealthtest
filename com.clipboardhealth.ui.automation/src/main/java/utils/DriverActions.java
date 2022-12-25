package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DriverActions {
    public static Builder builder(WebDriver driver) {
        return new Builder(driver);
    }
    public static class Builder {
        private static WebDriver driver;

        Builder(WebDriver driver) {
            this.driver = driver;
        }

        public WebDriver build() {
            return driver;
        }

        public WebDriver initializeBrowser() throws Exception {
            WebDriverManager
                    .chromedriver()
                    .browserVersion(DataHolder.getChromeBrowserVersion())
                    .setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");

            if(DataHolder.getBrowser().equalsIgnoreCase("chrome")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "UNKNOWN");
                capabilities.setCapability("browserVersion", "");
                capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
                driver = new RemoteWebDriver(
                        new URI("http://selenoid:4444/wd/hub").toURL(),
                        capabilities
                );
            } else if(DataHolder.getBrowser().equalsIgnoreCase("localchrome")) {
                driver = new ChromeDriver(options);
            } else {
                throw new Exception("Unknown Browser");
            }

            DataHolder.setDriver(driver);
            return driver;
        }

        public Builder switchToNextTab(int tab) {
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tab));
            Utils.saveScreenshot(driver);
            return this;
        }
    }
}
