package com.ita.speakukrainian.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends BasePage{
    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[9]/button")
    private WebElement saveChanges;
    @FindBy(xpath = "//*[@id=\"edit_phone\"]")
    private WebElement phoneField;
    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[4]/div[2]/div[2]/div")
    private WebElement wrongTelephoneFieldFormatAlert;
    @FindBy(id = "//*[@id=\"edit_lastName\"]")
    private WebElement lastNameField;
    @FindBy(xpath ="//*[@id=\"edit\"]/div[2]/div[4]/div[2]/div[2]/div")
    private WebElement pleasEnterAnyNumberAlert;
    @FindBy(id = "//*[@id=\"edit_firstName\"]")
    private WebElement firstNameField;
    @FindBy(id = "//*[@id=\"edit_email\"]")
    private WebElement emailField;

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    public EditProfilePage sendKeysPhoneField(String phoneNumber){
        sleep(1000);
        phoneField.click();
        phoneField.sendKeys(phoneNumber);
        return this;
    }

    public EditProfilePage clearPhoneField(){
        phoneField.click();
        String delete = Keys.chord(Keys.CONTROL,"a") + Keys.DELETE;
        phoneField.sendKeys(delete);
        return this;
    }

    public boolean isDisplayedSaveButton(){
        return saveChanges.isEnabled();
    }

    public String getErrorWrongNumber(){
        sleep(2000);
        return wrongTelephoneFieldFormatAlert.getText();
    }

    public String getEnterAnyNumberAlert() {
        sleep(2000);
        return pleasEnterAnyNumberAlert.getText();
    }
}