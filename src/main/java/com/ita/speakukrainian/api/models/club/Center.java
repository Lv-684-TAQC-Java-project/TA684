package com.ita.speakukrainian.api.models.club;

import lombok.Data;

import java.util.List;

@Data
public class Center {
    private int id;
    private String name;
    private String contacts;
    private String urlBackgroundPicture;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private List<String> locations;
    private List<String> clubs;
    private User user;
    private int centerExternalId;
    private int rating;
    private int clubCount;
    private String email;
    private String phones;
    private String socialLinks;
}
