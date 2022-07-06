package com.ita.speakukrainian.api.models.task;


import lombok.Data;

@Data
public class CreateTaskPutRequest {
    public  String name;
    public String headerText;
    public String description;
    public String picture;
    public String startDate;
    public int challengeId;
}
