package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.utils.jdbc.entity.DistrictEntity;
import com.ita.speakukrainian.utils.jdbc.entity.StationEntity;
import com.ita.speakukrainian.utils.jdbc.services.DistrictServise;
import com.ita.speakukrainian.utils.jdbc.services.StationServise;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ExapleTests2 {
    @Test
    public void afterSuite1() {
        DistrictServise districtServise = new DistrictServise();
        List<DistrictEntity> district = districtServise.getALLDistrict();
        DistrictEntity first = district.get(0);
        DistrictEntity second = district.get(1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(first.getId(), 1L);
        softAssert.assertEquals(first.getName(), "Деснянський");
        softAssert.assertEquals(first.getCityId(), 1);
        softAssert.assertEquals(second.getId(), 2);
        softAssert.assertEquals(second.getName(), "Святошинський");
        softAssert.assertEquals(second.getCityId(), 1);
        softAssert.assertAll();
    }
}
