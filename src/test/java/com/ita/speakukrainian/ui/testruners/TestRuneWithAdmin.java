package com.ita.speakukrainian.ui.testruners;

import com.ita.speakukrainian.ui.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestRuneWithAdmin extends BaseTestRunner{

    @BeforeClass
    public void beforeClass() {
        new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton();
    }

    @AfterClass
    public void afterClass() {
        driver.manage().deleteAllCookies();
        WebStorage webStorage = (WebStorage) driver;
        webStorage.getLocalStorage().clear();
        webStorage.getSessionStorage().clear();
    }
}
