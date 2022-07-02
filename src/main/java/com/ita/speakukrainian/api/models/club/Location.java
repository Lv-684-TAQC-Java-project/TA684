package com.ita.speakukrainian.api.models.club;

import lombok.Data;

@Data
public class Location {
    public String name;
    private String cityName;
    private String districtName;
    private String stationName;
    private String address;
    private String coordinates;
    private String phone;
    private double key;
}
