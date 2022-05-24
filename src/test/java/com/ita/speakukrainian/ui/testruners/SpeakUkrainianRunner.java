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
public class SpeakUkrainianRunner {

    protected static WebDriver driver;
    protected static ValueProvider valueProvider;


    @BeforeSuite
    public void beforeSuite() throws IOException {

        if (valueProvider == null) {
            valueProvider = new ValueProvider();
        }
    }


    @BeforeMethod
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        context.setAttribute("myDriver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseURL());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @AfterSuite
    public void afterSuite() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }
}

