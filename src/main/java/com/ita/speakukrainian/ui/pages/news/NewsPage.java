package com.ita.speakukrainian.ui.pages.news;

import com.ita.speakukrainian.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BasePage {
    @FindBy(xpath = "/html/body/div[1]/section/section/main/section/div[2]/div[1]/div[1]/div[1]")
    private WebElement firstNewsCardImagine;
    //*[@id="newsImage"]

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click first news card imagine")
    public NewsPage clickFirstNewsCardImagine(){
        firstNewsCardImagine.click();
        return this;
    }

}
