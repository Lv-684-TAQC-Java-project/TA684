package com.ita.speakukrainian.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderMenuComponent {
    protected WebDriver driver;

    @FindBy(xpath = "//div[@id='root']/section/header/div[3]/div[2]/span[2]")
    private WebElement userProFileButton;
    @FindBy(xpath = "//li[2]/span/div")
    private WebElement singInButton;
    @FindBy(xpath = "//*[@id='root']/section/header/div[1]/a/div")
    private WebElement homePageButton;
    // @FindBy(xpath = "//*[@id=\"root\"]/section/header/div[3]/div[2]/span[1]/img")
    @FindBy(css = "[title='Розширений пошук']")
    private WebElement extendedSearchButton;
    @FindBy(how = How.CSS, using= "[class*='ant-dropdown-menu-item']")
    // @FindAll(how = How.CSS, using= "[class*='ant-dropdown-menu-item']")
    private WebElement addClubButton;

    private final String avatarSelector = "//div[contains(@class,'user-profile')]//img";

    @FindBy(xpath = avatarSelector)
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

    public WebElement getExtendedSearchButton() {
        return extendedSearchButton;
    }

    public WebElement getAddClubButton(){
        return  addClubButton;
    }

    public HeaderMenuComponent clickUserProFileButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isDisplayedUserProFileButton()) {
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
        if (isDisplayedSingInButton()) {
            getSingInButton().click();
        }
        return new SingInPopup(driver);
    }

    public boolean isDisplayedSingInButton() {
        return singInButton.isDisplayed();
    }

    public HomePage cliHomePage() {
        homePageButton.click();
        return new HomePage(driver);
    }

    public String getAvatarImgPath() {
        Wait wait = new WebDriverWait(driver, 10 * 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(avatarSelector)));
        return avatar.getAttribute("src");
    }
    public ClubsPage clickExtendedSearchButton(){
        getExtendedSearchButton().click();
        return new ClubsPage(driver);
    }

    public AddClubPage clickAddClubButton() {
        getAddClubButton().click();
        return new AddClubPage(driver);
    }
}


