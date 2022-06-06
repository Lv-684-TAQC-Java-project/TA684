package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.services.ClubsService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestInfoForMaliavkyClub {
    String descriptionOfMaliavky = "Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.\n" +
            "\n" +
            "У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.";

    @Test
    public void GetClubFromBase(){
        ClubsService clubService = new ClubsService();
        List<ClubsEntity> club = clubService.getByName("Малявки");
        ClubsEntity maliavky = club.get(0);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(maliavky.getAge_from(), 4);
        softAssert.assertEquals(maliavky.getAge_to(), 6);
        softAssert.assertEquals(maliavky.getName(), "Малявки");
        System.out.println(maliavky.getDescription());
        softAssert.assertEquals(maliavky.getDescription(), descriptionOfMaliavky);
    }
}
