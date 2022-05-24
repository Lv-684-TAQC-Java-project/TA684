package com.ita.speakukrainian.ui.testruners;

import com.ita.speakukrainian.ui.pages.AddClubPages.Explanation;
import com.ita.speakukrainian.ui.pages.ClubsPage;
import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.utils.ValueProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

public class RunnerForTUA_210 {

    protected static WebDriver driver;
    protected static ValueProvider valueProvider;


    @BeforeSuite
    public void beforeSuite(ITestContext context) throws IOException {

        if (valueProvider == null) {
            valueProvider = new ValueProvider();
        }

    }

    @BeforeClass
    public void beforeClass(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        context.setAttribute("myDriver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseURL());

        new HomePage(driver)
                .header()
                .clickExtendedSearchButton();

    }

    @AfterMethod
    public void afterMethod() {
        ClubsPage clubsPage = new ClubsPage(driver);
        clubsPage.doubleClickAgeField();

    }

    @AfterSuite
    public void afterSuite() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }
}

