package com.ita.speakukrainian.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddClubPage extends BasePage {
    @FindBy(css = "#basic_name")
    private WebElement clubNameInput;
    @FindBy(css = "[type*='checkbox']")
    private List<WebElement> optionCheckboxes;
    @FindBy(css = "#basic_ageFrom")
    private WebElement ageFromInput;
    @FindBy(css = "#basic_ageTo")
    private WebElement ageToInput;
    @FindBy(css = "[class*='add-club-content-next']")
    private WebElement nextStepButton;
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
    @FindBy(css = "#basic_description")
    private WebElement basicDescriptionInput;
    @FindBy(css = "[role='alert']")
    private List<WebElement> alerts;

    public AddClubPage (WebDriver driver){
        super(driver);
    }

    public WebElement getAgeFromInput() {
        return ageFromInput;
    }


    public List<WebElement> getOptionCheckboxes() {
        return optionCheckboxes;
    }

    public WebElement getAgeToInput() {
        return  ageToInput;
    }

    public WebElement getNextStepButton() {
        return nextStepButton;
    }

    public WebElement getContactFacebookInput() {
        return contactFacebookInput;
    }

    public WebElement getClubNameInput() {
        return clubNameInput;
    }

    public WebElement getContactMailInput() {
        return contactMailInput;
    }

    public WebElement getContactWhatsAppInput() {
        return contactWhatsAppInput;
    }

    public List<WebElement> getAlerts() {
        return alerts;
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

    public WebElement getBasicDescriptionInput() {
        return basicDescriptionInput;
    }

    public AddClubPage fillInClubNameInput(String clubName) {
        getClubNameInput().sendKeys(clubName);
        return new AddClubPage(driver);
    }

    public AddClubPage clickOptionCheckboxes(int index) {
        getOptionCheckboxes().get(index).click();
        return new AddClubPage(driver);
    }

    public AddClubPage fillInAgeFromInput(String age) {
        getAgeFromInput().sendKeys(age);
        return new AddClubPage(driver);
    }

    public AddClubPage fillInAgeToInput(String age) {
        getAgeToInput().sendKeys(age);
        return new AddClubPage(driver);
    }

    public AddClubPage clickNextStepButton() {
        getNextStepButton().click();
        return new AddClubPage(driver);
    }

    public AddClubPage fillInContactFacebookInput(String contactFacebook) {
        getContactFacebookInput().sendKeys(contactFacebook);
        return new AddClubPage(driver);
    }

    public AddClubPage fillInContactMailInput(String contactMail) {
        getContactMailInput().sendKeys(contactMail);
        return new AddClubPage(driver);
    }

    public AddClubPage fillInContactWhatsAppInput(String contactWhatsApp) {
        getContactWhatsAppInput().sendKeys(contactWhatsApp);
        return new AddClubPage(driver);
    }

    public AddClubPage fillInContactInput(String contact) {
        getContactContactInput().sendKeys(contact);
        return new AddClubPage(driver);
    }

    public AddClubPage fillInContactSkypeInput(String contactSkype) {
        getContactSkypeInput().sendKeys(contactSkype);
        return new AddClubPage(driver);
    }

    public AddClubPage fillInContactPhoneInput(String contactPhone) {
        getContactPhoneInput().sendKeys(contactPhone);
        return new AddClubPage(driver);
    }


    public AddClubPage fillInBasicDescriptionInput(String description) {
        getBasicDescriptionInput().sendKeys(description);
        return new AddClubPage(driver);
    }

    public boolean isAlertDisplayed() {
        return getAlerts().stream().allMatch(el -> el.isDisplayed());
    }
}