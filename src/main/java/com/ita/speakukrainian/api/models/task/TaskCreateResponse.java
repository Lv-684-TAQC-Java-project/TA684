package com.ita.speakukrainian.api.models.task;

import lombok.Data;

import java.util.List;

@Data
public class TaskCreateResponse {
    private int id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private List<Integer> startDate;
    private Integer challengeId;
}
