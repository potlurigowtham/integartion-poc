package org.mulesoft.salesforce.ui.util;

import org.apache.commons.io.FileUtils;
import org.mulesoft.salesforce.utilities.Util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class WebUtil {

    public static void enterTextIntoTextBox(WebElement textBox, String textToBeEntered) {
        textBox.sendKeys(textToBeEntered);
    }

    public static void clickButton(WebElement clickable) {
        clickable.click();
    }

    public static void selectOptionFromSelectBox(WebElement selectBox, String selection) {
        Select select = new Select(selectBox);
        select.selectByVisibleText(selection);
    }

    public static void waitInSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }

    public static void takeScreenshot(WebDriver driver, TestResult result, String screencastName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File filePath = new File("");
        switch (result) {
            case PASS:
                filePath = new File(Util.properties.getProperty("screenshots_path") + "/pass/");
                break;
            case FAIL:
                filePath = new File(Util.properties.getProperty("screenshots_path") + "/fail/");
                break;
            case EXCEPTION:
                filePath = new File(Util.properties.getProperty("screenshots_path") + "/exception/");
                break;
        }
        FileUtils.copyFileToDirectory(src, filePath);
    }
}
