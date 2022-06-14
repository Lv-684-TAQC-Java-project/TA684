package com.ita.speakukrainian.ui.pages.ChallengesPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AddChallengePage extends ChallengesPage{
    @FindBy (xpath = "//*[@id='sortNumber']")
    private WebElement sortNumberChallenge;
    @FindBy(xpath = "//*[@id='name']")
    private WebElement nameChallenge;
    @FindBy(xpath = "//*[@id='title']")
    private WebElement titleChallenge;
    @FindBy(xpath = "//div[@id='root']/section/section/main/div/form/div[4]/div[2]/div/div/div/div/div[2]/div/p")
    private WebElement depictionChallenge;
    @FindBy(xpath = "//div[@id='root']/section/section/main/div/form/div[4]/div[2]/div/div/div/div/div[2]/div/p")
    private List<WebElement> listDepictionChallenge;




    public AddChallengePage(WebDriver driver) {
        super(driver);
    }

    @Step("get Attribute SortNumber Value")
    public String getSortNumberValue() {
        return sortNumberChallenge.getAttribute("value");
    }
    @Step("Click sort Number challenge")
    public AddChallengePage clickSortNumber() {
        sortNumberChallenge.click();
        return this;
    }
    @Step("Fill in AddChallengePage sortNumberChallenge")
    public AddChallengePage addChallengeSortNumber(String sortNumbers) {
        sortNumberChallenge.sendKeys(sortNumbers);
        return this;
    }
    @Step("get Attribute name Challenge Value")
    public String getChallengeNameValue() {
        return nameChallenge.getAttribute("value");
    }
    @Step("Click name Challenge")
    public AddChallengePage clickChallengeName() {
        nameChallenge.click();
        return this;
    }
    @Step("Fill in AddChallengePage name Challenge")
    public AddChallengePage addChallengeName(String names) {
        nameChallenge.sendKeys(names);
        return this;
    }
    @Step("get Attribute title Challenge Value")
    public String getChallengeTitleValue() {
        return titleChallenge.getAttribute("value");
    }
    @Step("Click title Challenge")
    public AddChallengePage clickChallengeTitle() {
        titleChallenge.click();
        return this;
    }
    @Step("Fill in AddChallengePage title Challenge")
    public AddChallengePage addChallengeTitle(String titles) {
        titleChallenge.sendKeys(titles);
        return this;
    }

    @Step("Fill in AddChallengePage title Depiction")
    public AddChallengePage addDepictionChallenge(String depictions) {
        depictionChallenge.sendKeys(depictions);
        return this;
    }

    @Step("Get List Depiction Challenge")
    public List<String> getDepictionChallenge() {
        List<String> list= new ArrayList<>();
        for(int i=1; i<=listDepictionChallenge.size();i++ ){
            list.add(listDepictionChallenge.get(i-1).findElement(By.xpath("//p["+i+"]")).getText());
        }
        return list;
    }


//    From Oleh Vasylyshyn to Everyone 11:15 AM
//    WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
//
//    // enter the file path onto the file-selection input field
//        uploadElement.sendKeys("C:\\newhtml.html");

}
