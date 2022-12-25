package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePageObjects;
import utils.Utils;

import java.time.Duration;

public class HomePage {
    public static Builder builder(WebDriver driver) {
        return new Builder(driver);
    }

    public static class Builder {
        private WebDriver driver;
        private HomePageObjects homePageObjects;
        private WebDriverWait wait;
        private JavascriptExecutor js;

        Builder(WebDriver driver) {
            this.driver = driver;
            this.homePageObjects = new HomePageObjects(driver);
            this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
            this.js =(JavascriptExecutor)driver;
        }

        public WebDriver build() {
            return driver;
        }

        public Builder clickOnAllHamburgerMenu() {
            wait.until(ExpectedConditions.presenceOfElementLocated(homePageObjects.getAll_hamburger_menu())).click();
            Utils.saveScreenshot(driver);
            return this;
        }

        public Builder scrollIntoShopByCategorySection() {
            wait.until(ExpectedConditions.presenceOfElementLocated(homePageObjects.getShop_by_category_section()));
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(homePageObjects.getShop_by_category_section()));
            Utils.saveScreenshot(driver);
            return this;
        }

        public Builder clickOnTvApplianceElectronicsMenu() {
            wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getTv_appliance_electronics_menu())).click();
            Utils.saveScreenshot(driver);
            return this;
        }

        public Builder clickOnTelevisionsMenu() {
            wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getTelevisions_menu())).click();
            Utils.saveScreenshot(driver);
            return this;
        }
    }
}
