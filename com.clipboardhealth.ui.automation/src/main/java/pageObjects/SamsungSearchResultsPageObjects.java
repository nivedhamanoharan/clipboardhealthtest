package pageObjects;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadJson;

public class SamsungSearchResultsPageObjects {
    private WebDriver driver;
    private JSONObject xpathJson;

    @Getter @Setter
    private By sort_by, high_to_low_menu_item, searched_result_2;

    public SamsungSearchResultsPageObjects(WebDriver driver) {
        this.driver = driver;
        initializeSamsungSearchResultsPageXPaths();
    }

    private void initializeSamsungSearchResultsPageXPaths() {
        this.xpathJson = ReadJson.readJson("SamsungSearchResultsPage.json");
        this.sort_by = new By.ByXPath(xpathJson.get("sort_by").toString());
        this.high_to_low_menu_item = new By.ByXPath(xpathJson.get("high_to_low_menu_item").toString());
        this.searched_result_2 = new By.ByXPath(xpathJson.get("searched_result_2").toString());
    }
}
