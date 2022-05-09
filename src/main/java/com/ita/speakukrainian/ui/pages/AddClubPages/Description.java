package com.ita.speakukrainian.ui.pages.AddClubPages;

import com.ita.speakukrainian.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Description extends BasePage {

    @FindBy(css = "#basic_description")
    private WebElement basicDescriptionInput;
    @FindBy(css = "[role='alert']")
    private List<WebElement> alerts;
    @FindBy(xpath = "//*[@id=\"basic\"]/div[4]/div[2]/div[2]/div[1]")
    private WebElement wrongDescriptionAlert;
    @FindBy(xpath = "//form/div[4]/div[2]/div[2]/div")
    private WebElement explainErrorAlotSymbols;

    public Description(WebDriver driver) {
        super(driver);
    }

    public WebElement getBasicDescriptionInput() {
        return basicDescriptionInput;
    }

    public List<WebElement> getAlerts() {
        return alerts;
    }

    public String getWrongDescriptionAlert() {
        return wrongDescriptionAlert.getText();
    }

    public Description fillInBasicDescriptionInput(String description) {
        getBasicDescriptionInput().sendKeys(description);
        return new Description(driver);
    }

    public boolean isAlertDisplayed() {
        return getAlerts().stream().allMatch(el -> el.isDisplayed());
    }

    public boolean isDisplayedExplainErrorAlotSymbols() {
        return explainErrorAlotSymbols.isDisplayed();
    }

    public String getTextExplainErrorAlotSymbols() {
        return explainErrorAlotSymbols.getText();
    }


}
