package pageObjects;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadJson;

public class HomePageObjects {
    private WebDriver driver;
    private JSONObject xpathJson;

    @Getter @Setter
    private By all_hamburger_menu, shop_by_category_section, tv_appliance_electronics_menu, televisions_menu;

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
        initializeHomePageXPaths();
    }

    private void initializeHomePageXPaths() {
        this.xpathJson = ReadJson.readJson("HomePage.json");
        this.all_hamburger_menu = new By.ByXPath(xpathJson.get("all_hamburger_menu").toString());
        this.shop_by_category_section = new By.ByXPath(xpathJson.get("shop_by_category_section").toString());
        this.tv_appliance_electronics_menu = new By.ByXPath(xpathJson.get("tv_appliance_electronics_menu").toString());
        this.televisions_menu = new By.ByXPath(xpathJson.get("televisions_menu").toString());
    }
}
