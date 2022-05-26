package com.ita.speakukrainian.ui.pages.RegistrationPages;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//input[@id='lastName']")
    protected WebElement enterLastName;
    @FindBy(xpath = "//input[@id='firstName']")
    protected WebElement enterFirstName;
    @FindBy(xpath= "//input[@id='phone']")
    protected WebElement enterPhone;
    @FindBy(xpath = "//input[@id='email']")
    protected  WebElement enterEmail;
    @FindBy(xpath = "//input[@id='password']")
    protected  WebElement enterPassword;
    @FindBy(xpath = "//input[@id='confirm']")
    protected  WebElement enterConfirm;
    @FindBy(xpath = "//button/span/span")
    protected WebElement closeIconRegistration;




    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in RegistrationPage lastName")
    public RegistrationPage registrationLastName(String lastName) {
        enterLastName.sendKeys(lastName);
        return this;
    }
    @Step("Fill in click on RegistrationPage lastName")
    public RegistrationPage clickRegistrationLastName() {
        enterLastName.click();
        sleep(1000);
        return this;
    }
    @Step("Fill in RegistrationPage firstName")
    public RegistrationPage registrationFirstName(String firstName) {
        enterFirstName.sendKeys(firstName);
        return this;
    }
    @Step("Fill in click on RegistrationPage firstName")
    public RegistrationPage clickRegistrationFirstName() {
        enterFirstName.click();
        return this;
    }
    @Step("Fill in RegistrationPage phone")
    public RegistrationPage registrationPhone(String phone) {
        enterPhone.sendKeys(phone);
        return this;
    }
    @Step("Fill in click on RegistrationPage phone")
    public RegistrationPage clickRegistrationPhone() {
        enterPhone.click();
        return this;
    }
    @Step("Fill in RegistrationPage email")
    public RegistrationPage registrationEmail(String email) {
        enterEmail.sendKeys(email);
        return this;
    }
    @Step("Fill in click on RegistrationPage email")
    public RegistrationPage clickRegistrationEmail() {
        enterEmail.click();
        return this;
    }
    @Step("Fill in RegistrationPage password")
    public RegistrationPage registrationPassword(String password) {
        enterPassword.sendKeys(password);
        return this;
    }
    @Step("Fill in click on RegistrationPage password")
    public RegistrationPage clickRegistrationPassword() {
        enterPassword.click();
        return this;
    }

    @Step("Fill in RegistrationPage confirm")
    public RegistrationPage registrationConfirm(String confirm) {
        enterConfirm.sendKeys(confirm);
        return this;
    }
    @Step("Fill in click on RegistrationPage confirm")
    public RegistrationPage clickRegistrationConfirm() {
        enterConfirm.click();
        return this;
    }
    @Step("Fill in RegistrationPage lastName")
    public HomePage closeRegistrationPage() {
        closeIconRegistration.click();
        return new HomePage(driver);
    }

    public MessageErrorRegistrationUser getMessageErrorRegistrationUser() {
        return new MessageErrorRegistrationUser(driver);
    }
    public FieldValuePage getFieldValuePage() {
        return new FieldValuePage(driver);
    }


    @Step("Fill in RegistrationPage lastName")
    public HomePage getHomePageinRegistrationPage() {
        return new HomePage(driver);
    }

}
