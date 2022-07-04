package com.ita.speakukrainian.ui.pages.ChallengesPages;

import com.ita.speakukrainian.ui.pages.BasePage;
import com.ita.speakukrainian.ui.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengesPage extends BasePage {
    @FindBy(xpath = "//section/main/div/button/a")
    private WebElement  addChallengesButton;


    public ChallengesPage(WebDriver driver) {
        super(driver);
}

    @Step("Click add challenges button")
    public AddChallengePage clickAddChallengesButton() {
        addChallengesButton.click();
        return new AddChallengePage(driver);
    }
}
