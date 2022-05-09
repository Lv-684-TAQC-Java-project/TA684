package com.ita.speakukrainian.ui.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class BaseComponent {
    protected WebDriver driver;
    protected DefaultElementLocatorFactory parentContext;

    public BaseComponent(WebDriver driver, WebElement element) {
        this.driver = driver;
        parentContext = new DefaultElementLocatorFactory(element);
        PageFactory.initElements(parentContext, this);
    }

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
