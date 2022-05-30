package com.ita.speakukrainian.ui.pages.AddClubPages;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import java.util.stream.Collectors;

public class Explanation extends BasePage {

    @FindBy(css = "#basic_description")
    private WebElement basicDescriptionInput;
    @FindBy(css = "[role='alert']")
    private WebElement alerts;
    @FindBy(xpath = "//*[@id=\"basic\"]/div[4]/div[2]/div[2]/div[1]")
    private WebElement wrongDescriptionAlert;
    @FindBy(xpath = "//form/div[4]/div[2]/div[2]/div")
    private WebElement wrongDescriptionDownAlert;
    @FindBy(css = "#basic [class$='ant-form-item-feedback-icon-success']")
    private WebElement successIcon;
    @FindBy(css = "#basic [class$='ant-form-item-feedback-icon-error']")
    private WebElement successIconError;

    @FindBy(xpath = "//*[@id='basic']/div[5]/button[2]")
    private WebElement toComplete;

    public Explanation(WebDriver driver) {
        super(driver);
    }

    public WebElement getBasicDescriptionInput() {
        return basicDescriptionInput;
    }

    public WebElement getSuccessIcon() {
        return successIcon;
    }

    @Step("Get alert wrong description")
    public String getWrongDescriptionAlert() {
        return wrongDescriptionAlert.getText();
    }

    @Step("Get text massage when we have error")
    public String TextWrongDescriptionDownAlert() {
        saveScreenshot();
        return wrongDescriptionDownAlert.getText();
    }

    @Step("Fill in basic description")
    public Explanation fillInBasicDescriptionInput(String description) {
        getBasicDescriptionInput().sendKeys(description);
        sleep(2000);
        return new Explanation(driver);
    }

    @Step("IS Error Messages Displayed")
    public String isErrorMessageDisplayed() {
        return alerts.getText();
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

    @Step("Clear description field")
    public void clearDescriptionField() {
        getBasicDescriptionInput().clear();
    }
    @Step("Click button 'Завершити' to complete registration of new club")
    public HomePage toCompleteClubsRegistration(){
        toComplete.click();
        return new HomePage(driver);
    }
}
