package com.ita.speakukrainian.ui.components;

import com.ita.speakukrainian.ui.pages.HomePage;
import com.ita.speakukrainian.ui.pages.MyProfilePage;
import com.ita.speakukrainian.ui.popup.SingInPopup;
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

    @FindBy(xpath = "/html/body/div[5]/div/div/ul/li[3]")
    private WebElement myProfileButton;



    public HeaderMenuComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * UserProFileButton
     */


    public HeaderMenuComponent clickUserProFileButton() {
        userProFileButton.click();
        return this;
    }

    public boolean isDisplayedUserProFileButton() {
        return userProFileButton.isDisplayed();
    }

    /**
     * SingInButton
     */

    public SingInPopup clickSingInButton() {
        if(isDisplayedSingInButton()) {
            singInButton.click();
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

    /**
     * MyProfile
     * @return MyProfilePage
     */
    public MyProfilePage clickMyProfileButton() {
        if(isDisplayedMyProfileButton()) {
            myProfileButton.click();
        }
        return new MyProfilePage(driver);
    }

    public boolean isDisplayedMyProfileButton() {
        return myProfileButton.isDisplayed();
    }

}
