package com.ita.speakukrainian.ui.pages.AddClubPages;

import com.ita.speakukrainian.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class Description extends BasePage {

    @FindBy(css = "#basic_description")
    private WebElement basicDescriptionInput;
    @FindBy(css = "[role='alert']")
    private List<WebElement> alerts;
    @FindBy(xpath = "//*[@id=\"basic\"]/div[4]/div[2]/div[2]/div[1]")
    private WebElement wrongDescriptionAlert;
    @FindBy(xpath = "//form/div[4]/div[2]/div[2]/div")
    private WebElement wrongDescriptionDownAlert;
    @FindBy(css = "#basic [class$='ant-form-item-feedback-icon-success']")
    private WebElement successIcon;
    @FindBy(css = "#basic [class$='ant-form-item-feedback-icon-error']")
    private WebElement successIconError;

    public Description(WebDriver driver) {
        super(driver);
    }

    public WebElement getBasicDescriptionInput() {
        return basicDescriptionInput;
    }

    public List<WebElement> getAlerts() {
        return alerts;
    }

    public WebElement getSuccessIcon() {
        return successIcon;
    }

    @Step("Get alert wrong description")
    public String getWrongDescriptionAlert() {
        return wrongDescriptionAlert.getText();
    }

    @Step("Get text massage whan we have error")
    public String TextWrongDescriptionDownAlert() {
        saveScreenshot();
        return wrongDescriptionDownAlert.getText();
    }

    @Step("Fill in basic description")
    public Description fillInBasicDescriptionInput(String description) {
        getBasicDescriptionInput().sendKeys(description);
        sleep(200);
        return new Description(driver);
    }

    public boolean isAlertDisplayed() {
        return getAlerts().stream().allMatch(el -> el.isDisplayed());
    }

    @Step("Get isDisplayed() massage")
    public boolean isSuccessIconDisplayed() {
        saveScreenshot();
        return getSuccessIcon().isDisplayed();
    }

    @Step("Get isDisplayed() massage whan we have error")
    public boolean issuccessIconErrorDisplayed() {
        saveScreenshot();
        return successIconError.isDisplayed();
    }
}
