package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.utils.jdbc.entity.StationEntity;
import com.ita.speakukrainian.utils.jdbc.services.StationServise;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ExampleTests {

//    private void sleep(long s) {
//        try {
//            Thread.sleep(s * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void includesElementExampleTest() {
//        driver.findElement(By.xpath("//*[@id='root']/section/header/div[2]/ul/li[1]/span/a")).click();
//        sleep(1);
//        driver.findElement(By.xpath("//*[@id='root']/section/section/main/section/div/div[2]/div[2]/span[2]")).click();
//        sleep(1);
//        List<WebElement> names = driver.findElements(By.xpath("//div[contains(@class, 'title')]/div[contains(@class, 'name')]"));
//        for (WebElement element : names) {
//            System.out.println(element.getText());
//        }
//
//        List<WebElement> card = driver.findElements(By.xpath("//*[@id='root']/section/section/main/section/section/main/div[2]/./div"));
//
//        for (WebElement element : card) {
//            String name1 = element.findElement(By.xpath(".//div[contains(@class, 'name')]")).getText();
//            String name2 = element.findElement(By.xpath("./div/div[1]/div[1]")).getText();
//
//            System.out.println(name1);
//            // System.out.println(name2);
//        }
//
//
//        List<Item> cardsItem = new ArrayList<>();
//        for (WebElement element : card) {
//            cardsItem.add(new Item(driver, element));
//        }
//        for (Item item : cardsItem) {
//            System.out.println(item.getName() + " " + item.getDescription());
//        }
//
//    }

    @Test
    public void afterSuite() {
        StationServise stationServise = new StationServise();
        List<StationEntity> stations = stationServise.getALLStations();
        StationEntity first = stations.get(0);
        StationEntity second = stations.get(1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(first.getId(), 1L);
        softAssert.assertEquals(first.getName(), "Академмістечко", "bad name");
        softAssert.assertEquals(first.getCityId(), 1, "bad CityId()");
        softAssert.assertEquals(first.getDistrictId(), 2, "bad CityId()");
        softAssert.assertEquals(second.getId(), 2, "second bad id");
        softAssert.assertEquals(second.getName(), "Арсенальна", "second bad name");
        softAssert.assertEquals(second.getCityId(), 1, "second bad CityId()");
        softAssert.assertEquals(second.getDistrictId(), 0, "second bad CityId()");
        softAssert.assertAll();
    }
}
