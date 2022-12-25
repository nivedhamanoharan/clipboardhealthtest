package utils;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public class DataHolder {

    @Getter @Setter
    private static String chromeBrowserVersion, baseUrl, textForAssertion, sortOption, defaultSortOption, browser;

    @Getter @Setter
    private static WebDriver driver;

    static  {
        init();
    }

    public static void init() {
        try {
            PropertiesFile configFile = new PropertiesFile(Utils.getWorkingDirectory() + "//src//test//resources//config.properties");
            baseUrl = configFile.getProperty("base.url");
            chromeBrowserVersion = configFile.getProperty("chrome.browser.version");
            textForAssertion = configFile.getProperty("text.for.assertion");
            defaultSortOption = configFile.getProperty("default.sort.option");
            sortOption = configFile.getProperty("sort.option");
            browser = System.getProperty("browser.name");
        } catch (Exception e) {
            Utils.log("DataHolder Initialization Failed");
        }
    }
}
