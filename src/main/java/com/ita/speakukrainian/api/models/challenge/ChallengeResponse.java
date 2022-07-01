package com.ita.speakukrainian.api.models.challenge;

import lombok.Data;

@Data
public class ChallengeResponse {

    public int id;
    public String name;
    public String title;
    public String description;
    public String registrationLink;
    public String picture;
    public int sortNumber;
    public boolean isActive;
    public User user;
}
@Data
 class User{
    public int id;
    public String firstName;
    public String lastName;
    public String urlLogo;
}



