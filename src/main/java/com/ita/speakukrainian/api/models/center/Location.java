package com.ita.speakukrainian.api.models.center;

import lombok.Data;

@Data
public class Location {
    public int id;
    public String name;
    public String address;
//    public int cityId;
//    public int districtId;
//    public int stationId;
    public String cityName;
//    public String districtName;
//    public String stationName;
    public String coordinates;
    public double longitude;
    public double latitude;
//    public int centerId;
//    public int clubId;
    public String phone;
}
