package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BaseObjectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RedactClubMaliavkyPopUp extends BaseObjectPage {
    @FindBy(id = "basic_name")
    private WebElement clubNameField;

    @FindBy(xpath = "//*[@id='basic_categoryNames']/label[12]/span[1]/input")
    private WebElement developmentCheckBox;

    @FindBy(xpath = "//*[@id='basic_ageFrom']")
    private WebElement ageFromChange;

    @FindBy(xpath = "//*[@id='basic']/div[3]/div[2]/div/div/span/div[1]/div/div/div/div/div[1]/span[2]/span")
    private WebElement ageFromChangeDown;

    @FindBy(xpath = "//*[@id=basic_ageTo]")
    private WebElement ageToChange;

    @FindBy(xpath = "//*[@id='basic']/div[3]/div[2]/div/div/span/div[2]/div/div/div/div/div[1]/span[2]/span")
    private WebElement ageToChangeDown;

    @FindBy(xpath = "//*[@id='basic']/button[1]")
    private WebElement saveAgeChanges;

    @FindBy(xpath = "//*[@id='basic']/div[4]/div[2]/div/div/div/div")
    private WebElement selectNewCenter;

    @FindBy(css=".ant-select-item-option-active >.ant-select-item-option-content")
    private WebElement chooseNewCenter;

    @FindBy(css = "#rc-tabs-0-panel-3 .edit-club-button > span")
    private WebElement saveChanges;

    @FindBy(id = "rc-tabs-0-tab-2")
    private WebElement addressAndContacts;

    @FindBy(xpath = "//*[@id='basic_clubContactТелефон']")
    private WebElement phoneWindow;

    @FindBy(xpath = "//*[@id='basic']/button[1]")
    private WebElement saveMainWindowChangers;

    @FindBy(css=".ant-btn:nth-child(4) > span")
    private WebElement saveContactsWindowChangers;

    @FindBy(xpath = "//*[@id='rc-tabs-0-tab-3']")
    private WebElement clubDescription;

    @FindBy(xpath = "//*[@id='basic_descriptionText']")
    private WebElement descriptionField;

    public RedactClubMaliavkyPopUp(WebDriver driver) {
        super(driver);
    }

    public RedactClubMaliavkyPopUp changeClubNameField(String name){
        deleteText(clubNameField);
        clubNameField.click();
        clubNameField.sendKeys(name);
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp chooseDevelopmentCheckBox(){
        developmentCheckBox.click();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp clickAgeFromChangeDown(){
        Actions act = new Actions(driver);
        act.doubleClick(ageFromChangeDown).perform();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp clickAgeToChangeDown(){
        Actions act = new Actions(driver);
        act.doubleClick(ageToChangeDown).perform();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp saveAgeChanges(){
        saveAgeChanges.click();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp chooseNewCenter(){
        selectNewCenter.click();
        chooseNewCenter.click();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp saveChanges(){
        saveChanges.click();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp addressAndContacts(){
        addressAndContacts.click();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp changePhoneWindow(String phone){
        deleteText(phoneWindow);
        phoneWindow.click();
        phoneWindow.sendKeys(phone);
        return new RedactClubMaliavkyPopUp(driver);
    }
    public RedactClubMaliavkyPopUp saveMainWindowChangers(){
        saveMainWindowChangers.click();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp saveContactWindowChangers(){
        saveContactsWindowChangers.click();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp  clubDescription(){
        clubDescription.click();
        return new RedactClubMaliavkyPopUp(driver);
    }

    public RedactClubMaliavkyPopUp makeNewDescription(String newDescription){
        deleteText(descriptionField);
        descriptionField.click();
        descriptionField.sendKeys(newDescription);
        return new RedactClubMaliavkyPopUp(driver);
    }

}
