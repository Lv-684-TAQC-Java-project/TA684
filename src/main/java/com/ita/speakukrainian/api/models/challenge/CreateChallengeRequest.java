package com.ita.speakukrainian.api.models.challenge;

import lombok.Data;



@Data
public class CreateChallengeRequest {

    public  String name;
    public String title;
    public String description;
 //   public String registrationLink;
    public String picture;
    public Integer sortNumber;

}
