package com.ita.speakukrainian.ui.pages.RegistrationPages;

import org.openqa.selenium.WebDriver;

public class FieldValuePage extends RegistrationPage {


    public FieldValuePage(WebDriver driver) {
        super(driver);

    }

    public String getLastNameValue() {
        return enterLastName.getAttribute("value");
    }

    public String getFirstNameValue() {

        return enterFirstName.getAttribute("value");
    }

    public String getPhoneValue() {

        return enterPhone.getAttribute("value");
    }

    public String getEmailValue() {

        return enterEmail.getAttribute("value");
    }

    public String getPasswordValue() {

        return enterPassword.getAttribute("value");
    }

    public String getConfirmValue() {

        return enterConfirm.getAttribute("value");
    }

}
