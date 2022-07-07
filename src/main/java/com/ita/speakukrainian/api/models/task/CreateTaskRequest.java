package com.ita.speakukrainian.api.models.task;

import lombok.Data;

@Data
public class CreateTaskRequest {
    //public int id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private String startDate;
    //public int challengeId;
}
