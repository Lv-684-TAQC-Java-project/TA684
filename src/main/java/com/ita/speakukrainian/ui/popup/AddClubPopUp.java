package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddClubPopUp extends BasePage {

@FindBy(xpath = "//*[@id=\"basic_name\"]")
private WebElement nameField;
@FindBy(xpath = "//*[@id=\"basic_categories\"]/label[13]/span[1]/input")
private WebElement categoryOther;
@FindBy(xpath = "//*[@id=\"basic_categories\"]/label[1]/span[1]/input")
private WebElement categorySportSection;
@FindBy(xpath = "//*[@id=\"basic_ageFrom\"]")
private WebElement ageFromField;
@FindBy(xpath = "//*[@id=\"basic_ageTo\"]")
private WebElement ageToField;
@FindBy(xpath = "//*[@id=\"basic\"]/div[5]/button[2]")
private WebElement nextStepFirstStageButton;
@FindBy(xpath = "//*[@id=\"basic\"]/div[4]/button[2]")
private WebElement nextStepSecondStageButton;
@FindBy(xpath = "//*[@id=\"basic_contactТелефон\"]")
private WebElement phoneField;
@FindBy(xpath = "//*[@id=\"basic\"]/div[5]/button[2]")
private WebElement completeButton;
@FindBy(xpath = "//*[@id=\"basic_description\"]")
private WebElement descriptionField;
@FindBy(xpath = "//*[@id=\"basic\"]/div[4]/div[2]/div[2]/div[1]")
private WebElement wrongDescriptionAlert;


    public AddClubPopUp(WebDriver driver) {
        super(driver);
    }

    public String getWrongDescriptionAlert(){
        return  wrongDescriptionAlert.getText();
    }

    public AddClubPopUp fillAgeField(){
        ageFromField.sendKeys("6");
        ageToField.sendKeys("18");
        return this;
    }

    public AddClubPopUp fillNameField(){
        nameField.sendKeys("Best club ever");
        return this;
    }

    public AddClubPopUp clickCategory(){
        categorySportSection.click();
        categoryOther.click();
        return this;
    }

    public AddClubPopUp fillPhoneField(String phone){
        phoneField.sendKeys(phone);
        return this;
    }

    public AddClubPopUp fillDescriptionField(String text){
        descriptionField.sendKeys(text);
        return this;
    }

    public AddClubPopUp clickNextStepFirstStageButton(){
        nextStepFirstStageButton.click();
        return this;
    }

    public AddClubPopUp clickNextStepSecondStageButton(){
        nextStepSecondStageButton.click();
        return this;
    }

    public AddClubPopUp clickCompleteButton(){
        completeButton.click();
        return this;
    }

}
