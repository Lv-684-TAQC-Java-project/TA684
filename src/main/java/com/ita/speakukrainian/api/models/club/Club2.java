package com.ita.speakukrainian.api.models.club;

import lombok.Data;

import java.util.List;

@Data
public class Club2 {
    private int id;
    private int ageFrom;
    private int ageTo;
    private String name;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String urlBackground;
    private List<String> urlGallery;
    private String workTime;
    private int rating;
    private int feedbackCount;
    private boolean isOnline;
    private List<Location> locations;
    private List<Feedback> feedbacks;
    private List<String> categories;
    private User user;
    private Center center;
    private boolean isApproved;
    private String contacts;
    private int clubExternalId;
    private int centerExternalId;
}
