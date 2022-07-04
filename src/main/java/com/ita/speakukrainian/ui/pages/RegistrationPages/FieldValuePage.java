package com.ita.speakukrainian.ui.pages.RegistrationPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class FieldValuePage extends RegistrationPage {


    public FieldValuePage(WebDriver driver) {
        super(driver);

    }
    @Step("get Attribute Last Name Value")
    public String getLastNameValue() {
        return enterLastName.getAttribute("value");
    }
    @Step("get Attribute First Name Value")
    public String getFirstNameValue() {

        return enterFirstName.getAttribute("value");
    }
    @Step("get Attribute Phone Value")
    public String getPhoneValue() {

        return enterPhone.getAttribute("value");
    }
    @Step("get Attribute Email Value")
    public String getEmailValue() {

        return enterEmail.getAttribute("value");
    }
    @Step("get Attribute Password Value")
    public String getPasswordValue() {

        return enterPassword.getAttribute("value");
    }
    @Step("get Attribute Confirm Value")
    public String getConfirmValue() {

        return enterConfirm.getAttribute("value");
    }

}
