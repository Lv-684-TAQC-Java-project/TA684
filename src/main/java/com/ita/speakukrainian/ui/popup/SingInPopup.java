package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingInPopup extends BasePage {
    @FindBy(xpath = "//input[@id='basic_email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@id='basic_password']")
    private WebElement inputPassword;
    @FindBy(css = ".login-button > span")
    private WebElement loginButton;
    @FindBy(css = ".ant-modal-wrap:nth-child(2) .ant-modal-close svg")
    private WebElement closeButton;

    public SingInPopup(WebDriver driver) {
        super(driver);
    }

    @Step("set in email input value: {enterName} {test}")
    public SingInPopup sendKeysEmail(String enterName) {
        inputEmail.sendKeys(enterName);
        return this;
    }
    @Step("set in password input value: {password} ")
    public SingInPopup sendKeysPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }
    @Step("click Login")
    public HomePage clickLoginButton() {
        loginButton.click();
        sleep(5000);
        return new HomePage(driver);
    }

    public HomePage clickCloseButton() {
        closeButton.click();
        return new HomePage(driver);
    }


    public HomePage singIn(String email, String password) {
        return this.sendKeysEmail(email)
                .sendKeysPassword(password)
                .clickLoginButton();
    }

}
