package com.ita.speakukrainian.ui;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.utils.ValueProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

public class SpeakUkrainianLoginMainPageRunner {

    protected static WebDriver driver;
    protected static ValueProvider valueProvider;


    @BeforeSuite
    public void beforeSuite(ITestContext context) throws IOException {

        if (valueProvider == null) {
            valueProvider = new ValueProvider();
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        context.setAttribute("myDriver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseURL());


        HomePage errorMassage = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton();

    }

    @AfterSuite
    public void afterSuite() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }
}

