package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.HeaderMenuComponent;
import org.openqa.selenium.WebDriver;

public class BaseObjectPage extends BasePage {
    private final HeaderMenuComponent headerMenu;

    public BaseObjectPage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenuComponent(driver);
    }

}
