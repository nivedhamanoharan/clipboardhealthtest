package pageObjects;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadJson;

public class TelevisionSearchResultsPageObjects {
    private WebDriver driver;
    private JSONObject xpathJson;

    @Getter @Setter
    private By samsung_menu, brands_filter;

    public TelevisionSearchResultsPageObjects(WebDriver driver) {
        this.driver = driver;
        initializeTelevisionSearchResultsPageXPaths();
    }

    private void initializeTelevisionSearchResultsPageXPaths() {
        this.xpathJson = ReadJson.readJson("TelevisionSearchResultsPage.json");
        this.samsung_menu = new By.ByXPath(xpathJson.get("samsung_menu").toString());
        this.brands_filter = new By.ByXPath(xpathJson.get("brands_filter").toString());
    }
}
