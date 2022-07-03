package com.ita.speakukrainian.api.models.club;

import lombok.Data;

@Data
public class Station {
    private int id;
    private String name;
    private LocationCity city;
    private District district;
}
