package com.ita.speakukrainian.utils;

import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.services.ClubsService;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestNGListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("myDriver");
        if (driver != null) {
            saveScreenshot(driver);
        }
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
