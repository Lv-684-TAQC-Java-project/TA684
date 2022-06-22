package com.ita.speakukrainian.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

public class ExtendedSearchComponent extends BasePage {


    @FindBy(css = ".ant-layout-has-sider")
    private WebElement advancedSearch;
    @FindBy(xpath = "//*[@id='root']/section/section/main/section/section/main/div/./div")
    private List<WebElement> cardFirst;
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
    @FindBy(xpath = "//*[text()=\"за рейтингом\"]")
    private WebElement sortedRatingButton;
    @FindBy(css = "[type='search'][id*=select]")
    private WebElement mainSearchInput;
    @FindBy(css = "[class='clubs-not-found']")
    private WebElement clubsNotFoundMessage;
    @FindBy(css = "[data-icon='search']")
    private WebElement dataIconSearch;
    @FindBy(xpath = "//div[contains(@class,'content-clubs-list content-clubs-block')]/div")
    private List<WebElement> clubItems;
    @FindBy(xpath = "//div[contains(@class,'content-center-list content-center-block')]/div")
    private WebElement centerItems;
    @FindBy(xpath = "//*[@id='basic']/div[2]/div[2]/div/div/div/span[2]")
    private WebElement clearDefaultCityButton;
    @FindBy(xpath = "//*[@class=\"ant-select-clear\"]")
    private WebElement clearDefaultCity;
    @FindBy(xpath = "//div[contains(@class,'content-clubs-list content-clubs-block')]/div")
    private List<WebElement> clubsCard;
    @FindBy(css = ".anticon-search > svg")
    private WebElement clickButtonFindElement;


    public ExtendedSearchComponent(WebDriver driver) {
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
    @Step("get card First First")
    public List<WebElement> getcardFirst() {
        sleep(1000);
        return cardFirst;
    }
    @Step("get card ")
    public List<WebElement> getcard() {
        sleep(3000);
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

    @Step("click on main search field")
    public ExtendedSearchComponent clickMainSearchField() {
        mainSearchInput.click();
        return new ExtendedSearchComponent(driver);
    }
    @Step("fill in main search field ")
    public ExtendedSearchComponent fillInMainSearchField(String text) {
        mainSearchInput.sendKeys(text);
        sleep(2000);
        return new ExtendedSearchComponent(driver);
    }
    @Step("copy text")
    public ExtendedSearchComponent copyText(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        return new ExtendedSearchComponent(driver);

    }
    @Step("paste text")
    public ExtendedSearchComponent controlPlusV() {
        mainSearchInput.sendKeys(Keys.CONTROL + "v");
        return new ExtendedSearchComponent(driver);
    }

    @Step("clear main search field")
    public ExtendedSearchComponent clearMainSearchField() {
        mainSearchInput.sendKeys(Keys.CONTROL + "a");
        mainSearchInput.sendKeys(Keys.DELETE);
        return new ExtendedSearchComponent(driver);
    }
    @Step("read number of characters in main search field")
    public int readMainSearchField() {
        return mainSearchInput.getAttribute("value").length();
    }
    @Step("verify is clubs not found message displayed")
    public boolean isClubsNotFoundMessageDisplayed() {
        return clubsNotFoundMessage.isDisplayed();
    }

    @Step("verify cards has text")
    public boolean verifyCardsHasText(String expectedText) {
    return clubsCard.stream().map(el -> el.getText()).allMatch(el -> el.contains(expectedText));

    }
    @Step("click data icon search")
    public ExtendedSearchComponent clickDataIconSearch() {
        sleep(12000);
        dataIconSearch.click();
        return new ExtendedSearchComponent(driver);
    }
    @Step("click default city")
    public ExtendedSearchComponent clickClearDefaultCity(){
        clearDefaultCity.click();
        return this;
    }

    @Step("click clear default city button")
    public ExtendedSearchComponent clickClearDefaultCityButton() {
        sleep(1000);
        clearDefaultCityButton.click();
        return this;
    }

    @Step("Click sort rating button")
    public ExtendedSearchComponent clickSortedRatingButton() {
        sleep(1000);
        sortedRatingButton.click();
        return this;
    }
    @Step("Click Button Find Element")
    public ExtendedSearchComponent clickClickButtonFindElement() {
        sleep(2000);
        clickButtonFindElement.click();
        return this;
    }
}

