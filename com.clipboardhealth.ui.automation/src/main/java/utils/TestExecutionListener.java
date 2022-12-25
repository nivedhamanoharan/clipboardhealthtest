package utils;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestExecutionListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Utils.log(iTestResult.getMethod().getConstructorOrMethod().getName() + "failed.");
        WebDriver driver = DataHolder.getDriver();
        Utils.saveScreenshot(driver);
    }

    @SneakyThrows
    @Override
    public void onStart(ITestContext context) {
        FileUtils.deleteDirectory(new File("target/allure-results"));
    }
}
