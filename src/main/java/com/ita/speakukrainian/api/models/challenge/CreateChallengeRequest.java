package com.ita.speakukrainian.api.models.challenge;

import lombok.Data;



@Data
public class CreateChallengeRequest implements ChallengeRequest {

    public  String name;
    public String title;
    public String description;
    public String picture;
    public Integer sortNumber;

}