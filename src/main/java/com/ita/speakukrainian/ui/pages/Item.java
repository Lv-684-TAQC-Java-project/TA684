package com.ita.speakukrainian.ui.pages;

import com.ita.speakukrainian.ui.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Item extends BaseComponent {
    @FindBy(how = How.XPATH, using = "./div/div[1]/div[1]")
    WebElement name;
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'description')]")
    WebElement description;

    public Item(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public String getName() {
        sleep(1000);
        return name.getText();
    }

    public String getDescription() {
        return description.getText();
    }


}
