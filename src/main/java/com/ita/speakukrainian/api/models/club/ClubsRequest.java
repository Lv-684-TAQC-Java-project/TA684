package com.ita.speakukrainian.api.models.club;

import com.ita.speakukrainian.api.models.club.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class ClubsRequest {
    public List<String> categoriesName;
    public String name;
    public int ageFrom;
    public int ageTo;
    public String urlLogo;
    public String urlBackground;
    public boolean isOnline;
    public String description;
    public String userId;
    public List<Location> locations;
    public String contacts;
    public int centerId;
}
