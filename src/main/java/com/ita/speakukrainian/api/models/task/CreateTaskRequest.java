package com.ita.speakukrainian.api.models.task;

import lombok.Data;

@Data
public class CreateTaskRequest {
    public int id;
    public String name;
    public String headerText;
    public String description;
    public String picture;
    public String startDate;
    public int challengeId;
}
