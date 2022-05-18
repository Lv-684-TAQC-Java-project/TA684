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

    @Step("Fill club name field")
    public MainInformation fillInClubNameInput(String clubName) {
        getClubNameInput().sendKeys(clubName);
        return new MainInformation(driver);
    }

    @Step("Click option checkboxes")
    public MainInformation clickOptionCheckboxes(int index) {
        getOptionCheckboxes().get(index).click();
        return new MainInformation(driver);
    }

    @Step("Fill age from field")
    public MainInformation fillInAgeFromInput(String age) {
        getAgeFromInput().sendKeys(age);
        return new MainInformation(driver);
    }

    @Step("Fill age to field")
    public MainInformation fillInAgeToInput(String age) {
        getAgeToInput().sendKeys(age);
        return new MainInformation(driver);
    }

    @Step("Click next step button")
    public Contacts clickNextStepButton() {
        getNextStepButton().click();
        return new Contacts(driver);
    }

}
