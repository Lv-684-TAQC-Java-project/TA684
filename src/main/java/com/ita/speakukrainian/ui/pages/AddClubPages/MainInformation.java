package com.ita.speakukrainian.ui.pages.AddClubPages;

import com.ita.speakukrainian.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainInformation extends BasePage {

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

    @FindBy(css="#basic_centerId")
    private WebElement selectCentre;

    @FindBy(xpath="//div[2]/div/div/div/div[4]/div")
    private WebElement academyOfSmartKids;

    public MainInformation(WebDriver driver) {
        super(driver);
    }

    public WebElement getClubNameInput() {
        return clubNameInput;
    }

    public List<WebElement> getOptionCheckboxes() {
        return optionCheckboxes;
    }

    public WebElement getAgeFromInput() {
        return ageFromInput;
    }

    public WebElement getAgeToInput() {
        return ageToInput;
    }

    public WebElement getNextStepButton() {
        return nextStepButton;
    }

    @Step("Fill in club name")
    public MainInformation fillInClubNameInput(String clubName) {
        sleep(1000);
        getClubNameInput().sendKeys(clubName);
        return new MainInformation(driver);
    }

    @Step("Click option checkboxes")
    public MainInformation clickOptionCheckboxes(int index) {
        getOptionCheckboxes().get(index).click();
        return new MainInformation(driver);
    }

    @Step("Choose in center")
    public MainInformation selectCentre() {
        selectCentre.click();
        scrollToElement(academyOfSmartKids);
        academyOfSmartKids.click();
        return new MainInformation(driver);
    }

    @Step("Fill in age from")
    public MainInformation fillInAgeFromInput(String age) {
        getAgeFromInput().sendKeys(age);
        return new MainInformation(driver);
    }

    @Step("Fill in age to")
    public MainInformation fillInAgeToInput(String age) {
        getAgeToInput().sendKeys(age);
        return new MainInformation(driver);
    }

    @Step("Click next step")
    public Contacts clickNextStepButton() {
        getNextStepButton().click();
        return new Contacts(driver);
    }

}
