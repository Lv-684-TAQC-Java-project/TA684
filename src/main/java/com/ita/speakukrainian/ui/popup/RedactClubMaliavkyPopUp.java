package com.ita.speakukrainian.ui.popup;

import com.ita.speakukrainian.ui.pages.BaseObjectPage;
import com.ita.speakukrainian.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RedactClubMaliavkyPopUp extends BaseObjectPage {
    @FindBy(id = "basic_name")
    private WebElement clubNameField;

    @FindBy(xpath = "//*[@id=\"basic_categoryNames\"]/label[12]/span[1]/input")
    private WebElement developmentCheckBox;

    @FindBy(xpath = "//*[@id=\"basic_ageFrom\"]")
    private WebElement ageFromChange;


    public RedactClubMaliavkyPopUp(WebDriver driver) {
        super(driver);
    }
}
