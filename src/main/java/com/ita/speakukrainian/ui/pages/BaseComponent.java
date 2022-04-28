package com.ita.speakukrainian.ui.pages;

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

    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
