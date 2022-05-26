package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExtendedSearchComponent extends BasePage {


    @FindBy(css = ".ant-layout-has-sider")
    private WebElement advancedSearch;
    @FindBy(xpath = "//*[@id='root']/section/section/main/section/section/main/div[2]/./div")
    private List<WebElement> card;
    @FindBy(xpath = "//*[@id='root']/section/section/main/section/section/section/div[2]/./div")
    private List<WebElement> cardCentr;
    @FindBy(css = ".anticon-arrow-up > svg")
    private WebElement arrowUpButton;
    @FindBy(css = ".anticon-arrow-down > svg")
    private WebElement arrowdownButton;


    ExtendedSearchComponent(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);

    }


    /**
     * Check advanced search if is opened
     */
    @Step("get i sDisplayed advanced Search ")
    public boolean isDisplayedadvancedSearch() {
        saveScreenshot();
        return advancedSearch.isDisplayed();
    }
    @Step("get card ")
    public List<WebElement> getcard() {
        sleep(1000);
        return card;
    }

    @Step("get carc centr ")
    public List<WebElement> getcardCentr() {
        sleep(1000);
        return cardCentr;
    }

    @Step("click Arrow Up Button ")
    public ExtendedSearchComponent clickArrowUpButton() {
        arrowUpButton.click();
        return this;
    }

    public ExtendedSearchComponent clickArrowDownButton() {
        arrowdownButton.click();
        return this;
    }

}

