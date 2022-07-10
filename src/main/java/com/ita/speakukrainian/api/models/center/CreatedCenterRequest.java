package com.ita.speakukrainian.api.models.center;

import lombok.Data;

import java.util.List;

@Data
public class CreatedCenterRequest {
    public String name;
    public List<Location> locations;
    public String description;
    public List<Integer> clubsId;
    public int userId;
    public String contacts;
}