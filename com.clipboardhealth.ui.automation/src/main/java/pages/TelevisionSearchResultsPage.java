package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.TelevisionSearchResultsPageObjects;
import utils.Utils;

import java.time.Duration;

public class TelevisionSearchResultsPage {
    public static Builder builder(WebDriver driver) {
        return new Builder(driver);
    }

    public static class Builder {
        private WebDriver driver;
        private TelevisionSearchResultsPageObjects televisionSearchResultsPageObjects;
        private WebDriverWait wait;
        private JavascriptExecutor js;

        Builder(WebDriver driver) {
            this.driver = driver;
            this.televisionSearchResultsPageObjects = new TelevisionSearchResultsPageObjects(driver);
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            this.js = (JavascriptExecutor) driver;
        }

        public WebDriver build() {
            return driver;
        }

        public Builder scrollIntoBrandsFilter() {
            wait.until(ExpectedConditions.presenceOfElementLocated(televisionSearchResultsPageObjects.getBrands_filter()));
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(televisionSearchResultsPageObjects.getBrands_filter()));
            Utils.saveScreenshot(driver);
            return this;
        }

        public Builder clickOnSamsungMenu() {
            wait.until(ExpectedConditions.elementToBeClickable(televisionSearchResultsPageObjects.getSamsung_menu())).click();
            Utils.saveScreenshot(driver);
            return this;
        }
    }
}
