package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//*[@id='root']/section/section/main/section/div[1]/div[1]/h2")
    private WebElement titleH2;
    @FindBy(xpath = "//div[5]/div/div[2]/div/div[2]")
    private WebElement registrationPage;

    private final HeaderMenuComponent headerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenuComponent(driver);
    }

    public HeaderMenuComponent header() {
        sleep(4000);
        return headerMenu;
    }

    public String getTitle() {
        return titleH2.getText();
    }

    @Step("Get isDisplayed()  registration page ")
    public boolean isRegistrationPageDisplayed() {
        sleep(500);
        try{
            if( registrationPage.isDisplayed()){
                System.out.println("registrationPage.isDisplayed()");
                return true;
            }
        }catch (NoSuchElementException e){
            System.out.println("registrationPage.isNotDisplayed()");
            return false;
    }
        System.out.println("boolean isRegistrationPageDisplayed()");
        return false;
    }
}
