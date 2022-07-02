package com.ita.speakukrainian.api.models.club;

import lombok.Data;

import java.util.List;

@Data
public class Root {
    private int id;
    private int ageFrom;
    private int ageTo;
    private String name;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String urlBackground;
    private List<UrlGallery> urlGallery;
    private String workTime;
    private List<Category> categories;
    private User user;
    private Center center;
    private int rating;
    private List<Location> locations;
    private boolean isApproved;
    private boolean isOnline;
}
