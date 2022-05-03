package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BaseObjectPage extends BasePage{
    private HeaderMenuComponent headerMenu;

    public BaseObjectPage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenuComponent(driver);
    }

}
