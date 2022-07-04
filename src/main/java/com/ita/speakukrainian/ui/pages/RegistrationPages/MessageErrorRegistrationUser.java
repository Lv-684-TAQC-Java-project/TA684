package com.ita.speakukrainian.ui.pages.RegistrationPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessageErrorRegistrationUser extends RegistrationPage {
    @FindBy(xpath = "//div[3]/div[2]/div[1]/div[2]/div[1]/div/span/span/span[@class='ant-form-item-feedback-icon ant-form-item-feedback-icon-success']")
    private WebElement correctFilledLastName;
    @FindBy(xpath = "//div[3]/div[2]/div[2]/div[2]/div/div/span/span/span[@class='ant-form-item-feedback-icon ant-form-item-feedback-icon-success']")
    private WebElement correctFilledFirstName;
    @FindBy(xpath = "//div[3]/div[2]/div[3]/div[2]/div/div/span/span[2]/span[2]")
    private WebElement correctFilledPhone;
    @FindBy(xpath = "//div[3]/div[2]/div[4]/div[2]/div/div/span/span/span[2]")
    private WebElement correctFilledEmail;
    @FindBy(xpath = "//div[3]/div[2]/div[5]/div[2]/div/div/span/span/span[2]/span")
    private WebElement correctPassword;
    @FindBy(xpath = "//div[3]/div[2]/div[6]/div[2]/div/div/span/span/span[2]/span")
    private WebElement correctConfirm;


    public MessageErrorRegistrationUser(WebDriver driver) {
        super(driver);
    }

    @Step("Get isDisplayed()  when we correct filled in valid LastName ")
    public boolean isCorrectFilledLastNameDisplayed() {
        saveScreenshot();
        return correctFilledLastName.isDisplayed();
    }

    @Step("Get isDisplayed()  when we correct filled in valid FirstName ")
    public boolean isCorrectFilledFirstNameDisplayed() {
        saveScreenshot();
        return correctFilledFirstName.isDisplayed();
    }

    @Step("Get isDisplayed()  when we correct filled in valid Phone ")
    public boolean isCorrectFilledPhoneDisplayed() {
        saveScreenshot();
        return correctFilledPhone.isDisplayed();
    }

    @Step("Get isDisplayed()  when we correct filled in valid Email ")
    public boolean isCorrectFilledEmailDisplayed() {
        saveScreenshot();
        return correctFilledEmail.isDisplayed();
    }
    @Step("Get isDisplayed()  when we correct filled in valid correct Password ")
    public boolean isCorrectFilledPasswordDisplayed() {
        saveScreenshot();
        return correctPassword.isDisplayed();
    }
    @Step("Get isDisplayed()  when we correct filled in valid correct Confirm ")
    public boolean isCorrectFilledConfirmDisplayed() {
        saveScreenshot();
        return correctConfirm.isDisplayed();
    }


}
