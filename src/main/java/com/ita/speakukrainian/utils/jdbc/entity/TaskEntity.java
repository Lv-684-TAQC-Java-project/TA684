package com.ita.speakukrainian.utils.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TaskEntity {
    public static final String SELECT_ALL_BY_NAME = "SELECT * FROM tasks WHERE name = 'Test_Завдання-=@#+123'";

    private long Id;
    private String Description;
    private String Name;
    private String Picture;
    private String Start_Data;
    private long Challenge_Id;
    private String Header_Text;

    public static TaskEntity getTask(List<String> row) {
        TaskEntity task = new TaskEntity();
        task.setId(Long.parseLong(row.get(0)));
        task.setDescription(row.get(1));
        task.setName(row.get(2));
        task.setPicture(row.get(3));
        task.setStart_Data(row.get(4));
        task.setChallenge_Id(Long.parseLong(row.get(5)));
        task.setHeader_Text(row.get(6));
        return task;
    }

    public static List<TaskEntity> getTasks(List<List<String>> rows) {
        List<TaskEntity> tasks = new ArrayList<>();
        for (List<String> row : rows) {
            tasks.add(getTask(row));
        }
        return tasks;
    }

}

