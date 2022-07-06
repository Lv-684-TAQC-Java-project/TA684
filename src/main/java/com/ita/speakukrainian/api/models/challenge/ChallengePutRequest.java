package com.ita.speakukrainian.api.models.challenge;

import lombok.Data;

@Data
public class ChallengePutRequest {
    public  String name;
    public String title;
    public String description;
    public String picture;
    public Integer sortNumber;
    public String headerText;
    public String startDate;
    public int challengeId;
}
