package com.ita.speakukrainian.utils.jdbc.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TasksEntity {
    public static final String SELECT_ALL = "SELECT * FROM tasks ORDER BY id";

    private String description;
    private long id;
    private String name;
    private long challengeId;
    private String  headerText;
    private String picture;
    private String date;

    public static TasksEntity getTask(List<String> row){
        TasksEntity tasks = new TasksEntity();
        tasks.setId(Long.parseLong(row.get(0)));
        tasks.setDescription(row.get(1));
        tasks.setName(row.get(2));
        tasks.setPicture(row.get(3));
        tasks.setDate(row.get(4));
//        tasks.setChallengeId(Long.parseLong(row.get(5)));
        tasks.setDescription(row.get(6));
        return tasks;
    }
    public static List<TasksEntity> getTasks(List<List<String>> rows) {
        List<TasksEntity> tasks = new ArrayList<>();
        for (List<String> row : rows) {
            tasks.add(getTask(row));
        }
        return tasks;
    }
}
