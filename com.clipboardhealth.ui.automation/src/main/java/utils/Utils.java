package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static String getWorkingDirectory() {
        String workingDir = System.getProperty("user.dir");
        return workingDir + System.getProperty("file.separator");
    }

    @Attachment
    public static byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String log(String message) {
        return message;
    }
}
