package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ProductDetailsPageObjects;
import utils.Utils;

import java.time.Duration;

public class ProductDetailsPage {
    public static Builder builder(WebDriver driver) {
        return new Builder(driver);
    }

    public static class Builder {
        private WebDriver driver;
        private ProductDetailsPageObjects productDetailsPageObjects;
        private WebDriverWait wait;

        Builder(WebDriver driver) {
            this.driver = driver;
            this.productDetailsPageObjects = new ProductDetailsPageObjects(driver);
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public WebDriver build() {
            return driver;
        }

        public String getAboutThisItemText() {
            Utils.saveScreenshot(driver);
            return wait.until(ExpectedConditions.presenceOfElementLocated(productDetailsPageObjects.getAbout_this_item())).getText();
        }
    }
}
