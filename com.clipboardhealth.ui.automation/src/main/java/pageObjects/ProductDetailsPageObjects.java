package pageObjects;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadJson;

public class ProductDetailsPageObjects {
    private WebDriver driver;
    private JSONObject xpathJson;

    @Getter @Setter
    private By about_this_item;

    public ProductDetailsPageObjects(WebDriver driver) {
        this.driver = driver;
        initializeProductDetailsPageXPaths();
    }

    private void initializeProductDetailsPageXPaths() {
        this.xpathJson = ReadJson.readJson("ProductDetailsPage.json");
        this.about_this_item = new By.ByXPath(xpathJson.get("about_this_item").toString());
    }
}
