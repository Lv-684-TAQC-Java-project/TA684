import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class SpeakUkrainianRunner {

    protected static WebDriver driver;


    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeClass
    public void SetUpBeforeClass() {
        System.out.println("@BeforeClass");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://speak-ukrainian.org.ua/dev/");

    }

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod");
        driver.get("https://speak-ukrainian.org.ua/dev/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        System.out.println("AfterMethod");
        if (!result.isSuccess()) {
            System.out.println("Test " + result.getName() + " Error");
        }
        driver.get("https://speak-ukrainian.org.ua/dev/");
    }

    @AfterClass
            (alwaysRun = true)
    public void tearDownAfterClass() {
        System.out.println("@AfterClass");
        if (driver != null) {
            driver.quit();
        }
    }

    public HomePage LoadApplication() {
        System.out.println("LoadApplication");
        return new HomePage(driver);
    }
}

