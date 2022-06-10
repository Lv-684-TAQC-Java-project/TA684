package com.ita.speakukrainian.utils.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class StationEntity {
    public static final String SELECT_ALL = "SELECT * FROM stations ORDER BY id";


    private long id;
    private String name;
    private long cityId;
    private long districtId;
   
    public StationEntity() {
        this.id = 0L;
        this.name = null;
        this.cityId = 0L;
        this.districtId = 0L;
    }

    public static StationEntity getStation(List<String> row) {
        StationEntity station = new StationEntity();
        station.setId(Long.parseLong(row.get(0)));
        station.setName(row.get(1));
        station.setCityId(Long.parseLong(row.get(2)));
        if (row.get(3) != null) {
            station.setDistrictId(Long.parseLong(row.get(3)));
        }
        return station;
    }

    public static List<StationEntity> getStations(List<List<String>> rows) {
        List<StationEntity> stations = new ArrayList<>();
        for (List<String> row : rows) {
            stations.add(getStation(row));
        }
        return stations;
    }
}
