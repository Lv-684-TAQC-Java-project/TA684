package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.services.ClubsService;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void scrollToElement(WebElement el) {
        Actions action = new Actions(driver);
        action.moveToElement(el).perform();
    }

    public void waitForElement(WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(elem));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }
    public void waitForElementIsClickable(WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    public String saveText(List elements) {
        String a=null;
        if (elements.isEmpty()) {
        ClubsService clubServise = new ClubsService();
        List<ClubsEntity> clubIdCenterIdCheck = clubServise.getByUserIDAndCenterNotNull(264);
            for (int i=0; i<clubIdCenterIdCheck.size();i++) {
                a= clubIdCenterIdCheck.get(i).toString();
            }
            return a;
        }
        else {
            return elements.toString();
        }
    }

    public void deleteText(WebElement elem){
        elem.click();
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        elem.sendKeys(del);
    }
}
