package com.ita.speakukrainian.ui.testruners;

import com.ita.speakukrainian.utils.TestNGListener;
import com.ita.speakukrainian.utils.ValueProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;


@Listeners(TestNGListener.class)
public class BaseTestRunner {

    protected static WebDriver driver;
    protected static ValueProvider valueProvider;


    @BeforeSuite
    public void beforeSuite() throws IOException {

        if (valueProvider == null) {
            valueProvider = new ValueProvider();
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseURL());
    }

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        context.setAttribute("myDriver", driver);
    }


    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }
}

