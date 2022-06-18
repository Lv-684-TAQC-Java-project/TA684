package com.ita.speakukrainian.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyliavkyClubPage extends BaseObjectPage{

    @FindBy(xpath = "//div[@class='content']")
    private WebElement content;

    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/section/section/aside/div/div[2]/span[2]")
    private WebElement age;

    @FindBy (xpath ="//*[@id=\"root\"]/section/section/main/section/section/aside/div/div[4]/div/div/span" )
    private WebElement phone;

    public MyliavkyClubPage(WebDriver driver){
        super(driver);
    }
    @Step("Read data about the club from the site and compare with the data")
    public String TextDescription(){
        scrollToElement(content);
        return content.getText();
    }
    @Step("Read data about the children's age from the site and compare with the data")
    public String AgeData(){
        return age.getText();
    }

    @Step("Read phone number from the site and compare with the data")
    public String PhoneNum(){
        return phone.getText();
    }
}
