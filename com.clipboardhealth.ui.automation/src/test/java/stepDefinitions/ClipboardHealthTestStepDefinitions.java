package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SamsungSearchResultsPage;
import pages.TelevisionSearchResultsPage;
import utils.DataHolder;
import utils.DriverActions;
import utils.Utils;

public class ClipboardHealthTestStepDefinitions {
    private WebDriver driver;

    public ClipboardHealthTestStepDefinitions() throws Exception {
        this.driver = DriverActions.builder(null).initializeBrowser();
    }

    @Given("User is on Home Page.")
    public void user_is_on_home_page() {
        driver.get(DataHolder.getBaseUrl());
        Utils.saveScreenshot(driver);
    }

    @When("User clicks on hamburger menu in the top left corner.")
    public void user_clicks_on_hamburger_menu_in_the_top_left_corner() {
        HomePage
                .builder(driver)
                .clickOnAllHamburgerMenu();
    }

    @When("Scroll down and then Click on the TV, Appliances and Electronics link under Shop by Category section.")
    public void scroll_down_and_then_click_on_the_tv_appliances_and_electronics_link_under_shop_by_category_section() {
        HomePage
                .builder(driver)
                .scrollIntoShopByCategorySection()
                .clickOnTvApplianceElectronicsMenu();
    }

    @When("Click on Televisions under Tv, Audio & Cameras sub section.")
    public void click_on_televisions_under_tv_audio_cameras_sub_section() {
        HomePage
                .builder(driver)
                .clickOnTelevisionsMenu();
    }

    @When("Scroll down and filter the results by Brand ‘Samsung’.")
    public void scroll_down_and_filter_the_results_by_brand_samsung() {
        TelevisionSearchResultsPage
                .builder(driver)
                .scrollIntoBrandsFilter()
                .clickOnSamsungMenu();
    }

    @When("Sort the Samsung results with price High to Low.")
    public void sort_the_samsung_results_with_price_high_to_low() {
        SamsungSearchResultsPage
                .builder(driver)
                .clickOnHighToLowPrice();
    }

    @When("Click on the second highest priced item")
    public void click_on_the_second_highest_priced_item() {
        SamsungSearchResultsPage
                .builder(driver)
                .clickOnSecondSearchedResult();
    }

    @When("User Switch the Window")
    public void user_switch_the_window() {
        DriverActions.builder(driver).switchToNextTab(1);
    }

    @Then("Assert that About this item section is present and log this section text to report.")
    public void assert_that_about_this_item_section_is_present_and_log_this_section_text_to_report() {
        String resultedText = ProductDetailsPage
                .builder(driver)
                .getAboutThisItemText();

        Assert.assertEquals(resultedText, DataHolder.getTextForAssertion(), "Resulted text does not match");
        Utils.log("The text " + resultedText + " is asserted and logged to the report.");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
