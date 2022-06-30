package com.ita.speakukrainian.api.models.challenge;

import lombok.Data;

@Data
public class CreatedChallengeRequest {
    public String name;
    public String title;
    public String description;
}
