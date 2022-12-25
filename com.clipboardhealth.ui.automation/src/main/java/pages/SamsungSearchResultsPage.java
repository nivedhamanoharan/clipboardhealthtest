package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.SamsungSearchResultsPageObjects;
import utils.DataHolder;
import utils.Utils;

import java.time.Duration;

public class SamsungSearchResultsPage {
    public static Builder builder(WebDriver driver) {
        return new Builder(driver);
    }

    public static class Builder {
        private WebDriver driver;
        private SamsungSearchResultsPageObjects samsungSearchResultsPageObjects;
        private WebDriverWait wait;
        private JavascriptExecutor js;

        Builder(WebDriver driver) {
            this.driver = driver;
            this.samsungSearchResultsPageObjects = new SamsungSearchResultsPageObjects(driver);
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            this.js = (JavascriptExecutor) driver;
        }

        public WebDriver build() {
            return driver;
        }

        public Builder clickOnHighToLowPrice() {
            Select sortDropDown = new Select(driver.findElement(samsungSearchResultsPageObjects.getSort_by()));
            sortDropDown.selectByVisibleText(DataHolder.getDefaultSortOption());
            sortDropDown.selectByVisibleText(DataHolder.getSortOption());
            Utils.saveScreenshot(driver);
            return this;
        }

        public Builder clickOnSecondSearchedResult() {
            wait.until(ExpectedConditions.elementToBeClickable(samsungSearchResultsPageObjects.getSearched_result_2())).click();
            Utils.saveScreenshot(driver);
            return this;
        }
    }
}
