package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.testruners.BaseTestRunner;
import com.ita.speakukrainian.ui.pages.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleTests extends BaseTestRunner {

    private void sleep(long s) {
        try {
            Thread.sleep(s * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void includesElementExampleTest() {
        driver.findElement(By.xpath("//*[@id='root']/section/header/div[2]/ul/li[1]/span/a")).click();
        sleep(1);
        driver.findElement(By.xpath("//*[@id='root']/section/section/main/section/div/div[2]/div[2]/span[2]")).click();
        sleep(1);
        List<WebElement> names = driver.findElements(By.xpath("//div[contains(@class, 'title')]/div[contains(@class, 'name')]"));
        for (WebElement element : names) {
            System.out.println(element.getText());
        }

        List<WebElement> card = driver.findElements(By.xpath("//*[@id='root']/section/section/main/section/section/main/div[2]/./div"));

        for (WebElement element : card) {
            String name1 = element.findElement(By.xpath(".//div[contains(@class, 'name')]")).getText();
            String name2 = element.findElement(By.xpath("./div/div[1]/div[1]")).getText();

            System.out.println(name1);
            // System.out.println(name2);
        }


        List<Item> cardsItem = new ArrayList<>();
        for (WebElement element : card) {
            cardsItem.add(new Item(driver, element));
        }
        for (Item item : cardsItem) {
            System.out.println(item.getName() + " " + item.getDescription());
        }

    }
}
