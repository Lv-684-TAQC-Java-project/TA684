package com.ita.speakukrainian.ui.testruners;

import com.ita.speakukrainian.ui.pages.AddClubPages.Explanation;
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

public class RunnerForTUA_178 {

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
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickAddClubButton()
                .fillInClubNameInput("Football")
                .clickOptionCheckboxes(2)
                .clickOptionCheckboxes(1)
                .fillInAgeFromInput("2")
                .fillInAgeToInput("18")
                .clickNextStepButton()
                .fillInContactFacebookInput(valueProvider.getContactFacebook())
                .fillInContactMailInput(valueProvider.getContactEmail())
                .fillInContactWhatsAppInput(valueProvider.getContactWhatsUpp())
                .fillInContactInput(valueProvider.getContactName())
                .fillInContactSkypeInput(valueProvider.getContactSkype())
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton();

    }

    @AfterMethod
    public void afterMethod(){
        Explanation explanation = new Explanation(driver);
        explanation.clearDescriptionField();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }
}

