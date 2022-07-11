package com.ita.speakukrainian.api.models.center;

import lombok.Data;

@Data
public class Location {
    public int id;
    public String name;
    public String address;
    public String cityName;
    public String coordinates;
    public double longitude;
    public double latitude;
    public String phone;
}
