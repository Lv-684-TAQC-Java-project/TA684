package com.ita.speakukrainian.ui.pages.AddClubPages;

import com.ita.speakukrainian.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contacts extends BasePage {

    @FindBy(css = "#basic_contactFacebook")
    private WebElement contactFacebookInput;
    @FindBy(css = "#basic_contactПошта")
    private WebElement contactMailInput;
    @FindBy(css = "#basic_contactWhatsApp")
    private WebElement contactWhatsAppInput;
    @FindBy(css = "#basic_contactContact")
    private WebElement contactContactInput;
    @FindBy(css = "#basic_contactSkype")
    private WebElement contactSkypeInput;
    @FindBy(css = "#basic_contactТелефон")
    private WebElement contactPhoneInput;
    @FindBy(css = "[class*='add-club-content-next']")
    private WebElement nextStepButton;

    public Contacts(WebDriver driver) {
        super(driver);
    }

    public WebElement getContactFacebookInput() {
        return contactFacebookInput;
    }

    public WebElement getContactMailInput() {
        return contactMailInput;
    }

    public WebElement getContactWhatsAppInput() {
        return contactWhatsAppInput;
    }

    public WebElement getContactContactInput() {
        return contactContactInput;
    }

    public WebElement getContactSkypeInput() {
        return contactSkypeInput;
    }

    public WebElement getContactPhoneInput() {
        return contactPhoneInput;
    }

    public WebElement getNextStepButton() {
        return nextStepButton;
    }

    @Step("Fill in contact facebook")
    public Contacts fillInContactFacebookInput(String contactFacebook) {
        getContactFacebookInput().sendKeys(contactFacebook);
        return new Contacts(driver);
    }

    @Step("Fill in contact e-mail")
    public Contacts fillInContactMailInput(String contactMail) {
        getContactMailInput().sendKeys(contactMail);
        return new Contacts(driver);
    }

    @Step("Fill in contact whatsApp")
    public Contacts fillInContactWhatsAppInput(String contactWhatsApp) {
        getContactWhatsAppInput().sendKeys(contactWhatsApp);
        return new Contacts(driver);
    }

    @Step("Fill in contact")
    public Contacts fillInContactInput(String contact) {
        getContactContactInput().sendKeys(contact);
        return new Contacts(driver);
    }

    @Step("Fill in contact skype")
    public Contacts fillInContactSkypeInput(String contactSkype) {
        getContactSkypeInput().sendKeys(contactSkype);
        return new Contacts(driver);
    }

    @Step("Fill contact phone")
    public Contacts fillInContactPhoneInput(String contactPhone) {
        getContactPhoneInput().sendKeys(contactPhone);
        return new Contacts(driver);
    }

    @Step("Click next step")
    public Explanation clickNextStepButton() {
        getNextStepButton().click();
        return new Explanation(driver);
    }
}
