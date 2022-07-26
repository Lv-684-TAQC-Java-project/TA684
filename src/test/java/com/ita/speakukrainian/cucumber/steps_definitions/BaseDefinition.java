package com.ita.speakukrainian.cucumber.steps_definitions;

import com.ita.speakukrainian.utils.ValueProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ParameterType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;

public class BaseDefinition {

    protected static WebDriver driver;
    protected static ValueProvider valueProvider;

    @BeforeAll
    public static void beforeAll() throws IOException {
        valueProvider = new ValueProvider();
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before(){
        ChromeOptions options = new ChromeOptions();
        if (valueProvider.getHeadlessMode()) {
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080", "--no-sandbox", "'--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(valueProvider.getBaseURL());
    }

    @After
    public void after() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }

    public static ValueProvider getValueProvider() {
        return valueProvider;
    }

    public WebDriver getDriver(){
        return driver;
    }

    @ParameterType("([^\"]*)")
    public String [] ages(String ages) {
        return ages.split(",");
    }

    @ParameterType("([^\"]*)")
    public String [] expected(String expected) {
        return expected.split(",");
    }
}
