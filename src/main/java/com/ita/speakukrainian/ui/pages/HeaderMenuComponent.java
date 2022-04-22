package com.ita.speakukrainian.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenuComponent {
    protected WebDriver driver;

    @FindBy(xpath = "//div[@id='root']/section/header/div[3]/div[2]/span[2]")
    private WebElement userProFileButton;
    @FindBy(xpath = "//li[2]/span/div")
    private WebElement singInButton;
    @FindBy(xpath = "//*[@id='root']/section/header/div[1]/a/div")
    private WebElement homePageButton;
    @FindBy(xpath = "//*[@id=\"root\"]/section/header/div[3]/div[2]/span[1]/img")
    private WebElement avatar;



    public HeaderMenuComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * UserProFileButton
     */
    public WebElement getUserProFileButton() {
        return userProFileButton;
    }

    public HeaderMenuComponent clickUserProFileButton() {
        if (isDisplayedUserProFileButton()){
            getUserProFileButton().click();
        }
        return this;
    }

    public boolean isDisplayedUserProFileButton() {
        return userProFileButton.isDisplayed();
    }

    /**
     * SingInButton
     */
    public WebElement getSingInButton() {
        return singInButton;
    }

    public SingInPopup clickSingInButton() {
        if(isDisplayedSingInButton()) {
            getSingInButton().click();
        }
        return new SingInPopup(driver);
    }

    public boolean isDisplayedSingInButton() {
        return singInButton.isDisplayed();
    }

    public HomePage cliHomePage(){
        homePageButton.click();
        return new HomePage(driver);
    }
    public String getAvatarImgPath() {
        return avatar.getAttribute("src");
    }

}
