package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExtendedSearchComponent {
    protected WebDriver driver;


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
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    /**
     * Check advanced search if is opened
     */
    public boolean isDisplayedadvancedSearch() {
        return advancedSearch.isDisplayed();
    }

    public List<WebElement> getcard() {
        return card;
    }

    public List<WebElement> getcardCentr() {
        return cardCentr;
    }

    public ExtendedSearchComponent clickArrowUpButton() {
        arrowUpButton.click();
        return this;
    }

    public ExtendedSearchComponent clickArrowDownButton() {
        arrowdownButton.click();
        return this;
    }

 }

