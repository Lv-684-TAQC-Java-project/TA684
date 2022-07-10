package com.ita.speakukrainian.api.models.challenge;

import lombok.Data;

@Data
public class CreatedChallengeRequest implements ChallengeRequest {
    public String name;
    public String title;
    public String description;
    public String picture;
    public String sortNumber;
}
