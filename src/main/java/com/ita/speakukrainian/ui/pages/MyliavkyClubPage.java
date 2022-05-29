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
    public boolean isContain(){
        scrollToElement(content);
       return content.getText().equals("Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.\n" +
               "\n" +
               "У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.");
    }
    @Step("Read data about the children's age from the site and compare with the data")
    public boolean isCorrectAge(){
        return age.getText().equals("від " + "4" + " до " + "6" + " років");
    }

    @Step("Read phone number from the site and compare with the data")
    public boolean isCorrectPhone(){
        return phone.getText().equals("+380934444444");
    }

}
