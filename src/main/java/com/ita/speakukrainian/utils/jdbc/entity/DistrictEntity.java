package com.ita.speakukrainian.utils.jdbc.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DistrictEntity {

    public static final String SELECT_ALL = "SELECT * FROM districts ORDER BY id";
    private long cityId;
    private long id;
    private String name;

    public DistrictEntity(){
        this.cityId = 0L;
        this.id =  0L;
        this.name = null;
    }
    public static DistrictEntity getDistrictOFCity(List<String> row) {
        DistrictEntity district = new DistrictEntity();
        district.setId(Long.parseLong(row.get(0)));
        district.setName(row.get(1));
        district.setCityId(Long.parseLong(row.get(2)));
        return district;
    }

    public static List<DistrictEntity> getDistricts(List<List<String>> rows) {
        List<DistrictEntity> district = new ArrayList<>();
        for (List<String> row : rows) {
            district.add(getDistrictOFCity(row));
        }
        return district;
    }



}
