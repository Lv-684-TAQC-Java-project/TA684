package com.ita.speakukrainian.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//*[@id='root']/section/section/main/section/div[1]/div[1]/h2")
    private WebElement titleH2;

    private HeaderMenuComponent headerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenuComponent(driver);
    }
    public HeaderMenuComponent header() {
        return headerMenu;
    }

    public String getTitle() {
        return  titleH2.getText();
    }
}
