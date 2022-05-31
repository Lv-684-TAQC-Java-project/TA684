package com.ita.speakukrainian.ui.pages;

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
    @FindBy(xpath = "//span[contains(.,'за алфавітом')]")
    private WebElement sortedAlphabeticallyButton;


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

    @Step("get card centr ")
    public List<WebElement> getcardCentr() {
        sleep(1000);
        return cardCentr;
    }

    @Step("click Arrow Up Button ")
    public ExtendedSearchComponent clickArrowUpButton() {
        arrowUpButton.click();
        return this;
    }
    @Step("click Arrow Down Button ")
    public ExtendedSearchComponent clickArrowDownButton() {
        arrowdownButton.click();
        return this;
    }
    @Step("go to class Club Page")
    public ClubsPage getClubsPage() {
        arrowdownButton.click();
        return new ClubsPage(driver);
    }
    @Step("click Sorted Alphabetically Button ")
    public ExtendedSearchComponent clickSortedAlphabeticallyButton() {
        sortedAlphabeticallyButton.click();
        return this;
    }


}

