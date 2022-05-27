package com.ita.speakukrainian.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[9]/button")
    private WebElement saveChanges;
    @FindBy(xpath = "//*[@id=\"edit_phone\"]")
    private WebElement phoneField;
    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[4]/div[2]/div[2]/div")
    private WebElement wrongTelephoneFieldFormatAlert;
    @FindBy(xpath = "//*[@id='edit']/div[2]/div[2]//*[@class='ant-form-item-explain-error']")
    private WebElement wrongLastNameFieldFormatAlert;
    @FindBy(id = "edit_lastName")
    private WebElement lastNameField;
    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[4]/div[2]/div[2]/div")
    private WebElement pleasEnterAnyNumberAlert;
    @FindBy(id = "edit_firstName")
    private WebElement firstNameField;
    @FindBy(id = "edit_email")
    private WebElement emailField;
    @FindBy(xpath = "//*[@name=\"checkbox\"]")
    private WebElement changePasswordCheckbox;
    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[9]/div[3]/div/div[2]/div")
    private WebElement confirmYourPasswordAlert;
    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[9]/div[2]/div/div[2]/div[1]")
    private WebElement newPasswordAlert;
    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[9]/div[1]/div/div[2]/div")
    private WebElement currentPasswordAlert;
    @FindBy(xpath = "//*[@id=\"edit_currentPassword\"]")
    private WebElement currentPasswordField;
    @FindBy(xpath = "//*[@id=\"edit_password\"]")
    private WebElement newPasswordField;
    @FindBy(xpath = "//*[@id=\"edit_confirmPassword\"]")
    private WebElement confirmYourPasswordField;
    @FindBy(xpath = "//*[@class=\"ant-btn ant-btn-default submit-button\"]")
    private WebElement submitButton;

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter phone field")
    public EditProfilePage sendKeysPhoneField(String phoneNumber) {
        sleep(1000);
        phoneField.click();
        phoneField.sendKeys(phoneNumber);
        return this;
    }

    @Step("Click change password checkbox")
    public EditProfilePage clickChangePasswordCheckbox() {
        sleep(1000);
        changePasswordCheckbox.click();
        return this;
    }

    @Step("Clear phone field")
    public EditProfilePage clearPhoneField() {
        phoneField.click();
        String delete = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        phoneField.sendKeys(delete);
        return this;
    }
    @Step("set in LastName input value: {lastName}")
    public EditProfilePage sendKeysLastNameField(String lastName) {
        sleep(1000);
        lastNameField.click();
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Click submit button")
    public EditProfilePage clickSubmitButton(){
        submitButton.click();
        return this;
    }


    @Step("fill current password field")
    public EditProfilePage sendKeysCurrentPasswordField(String currentPassword){
        sleep(1000);
        currentPasswordField.click();
        currentPasswordField.sendKeys(currentPassword);
        return this;
    }

    @Step("fill new password field")
    public EditProfilePage sendKeysNewPasswordField(String newPassword){
        sleep(1000);
        newPasswordField.click();
        newPasswordField.sendKeys(newPassword);
        return this;
    }

    @Step("fill confirm password field")
    public EditProfilePage sendKeysConfirmPasswordField(String confirmPassword){
        sleep(1000);
        confirmYourPasswordField.click();
        confirmYourPasswordField.sendKeys(confirmPassword);
        return this;
    }

    @Step("clear last name field")
    public EditProfilePage clearLastNameField(){
        lastNameField.click();
        String delete = Keys.chord(Keys.CONTROL,"a") + Keys.DELETE;
        lastNameField.sendKeys(delete);
        return this;
    }
    @Step("Get error : Wrong last name")
    public String getErrorWrongLastName(){
        sleep(2000);
        return wrongLastNameFieldFormatAlert.getText();
    }

    public boolean isDisplayedSaveButton() {
        return saveChanges.isEnabled();
    }

    @Step("Get error : Wrong number")
    public String getErrorWrongNumber() {
        sleep(2000);
        return wrongTelephoneFieldFormatAlert.getText();
    }

    @Step("Get error : Enter any number")
    public String getEnterAnyNumberAlert() {
        sleep(2000);
        return pleasEnterAnyNumberAlert.getText();
    }

    @Step("Get error : Confirm your password")
    public String getConfirmYourPasswordAlert(){
        sleep(1000);
        return confirmYourPasswordAlert.getText();
    }

    @Step("Get error : Pleas enter new password")
    public String getNewPasswordAlert(){
        sleep(1000);
        return newPasswordAlert.getText();
    }

    @Step("Get error : Pleas enter old password")
    public String getCurrentPasswordAlert(){
        sleep(1000);
        return currentPasswordAlert.getText();
    }

}
