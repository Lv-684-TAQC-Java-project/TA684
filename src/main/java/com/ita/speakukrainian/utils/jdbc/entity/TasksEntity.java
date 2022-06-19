package com.ita.speakukrainian.utils.jdbc.entity;


import com.ita.speakukrainian.utils.jdbc.dao.ManagerDao;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Data
public class TasksEntity {
    public static final String SELECT_ALL = "SELECT * FROM tasks ORDER BY id";

    public static final String SELECT_BY_DESCRIPTION = "SELECT description FROM tasks WHERE description like '%s'";

    public static final String SELECT_ALL_WHERE_NAME = "SELECT * FROM tasks WHERE name = '%s'";


    private String description;
    private long id;
    private String name;
    private long challengeId;
    private String  headerText;
    private String picture;
    private String date;

    public TasksEntity(){
        this.id=0L;
        this.name=null;
        this.challengeId=0L;
        this.headerText=null;
        this.picture=null;
        this.date=null;
        this.description=null;

    }



    public static TasksEntity getTask(List<String> row){
        TasksEntity tasks = new TasksEntity();
        tasks.setId(Long.parseLong(row.get(0)));
        tasks.setDescription(row.get(1));
        tasks.setName(row.get(2));
        tasks.setPicture(row.get(3));
        tasks.setDate(row.get(4));
        tasks.setChallengeId(Long.parseLong(row.get(5)));
        tasks.setHeaderText(row.get(6));
        return tasks;
    }
    public static List<TasksEntity> getTasks(List<List<String>> rows) {
        List<TasksEntity> tasks = new ArrayList<>();
        for (List<String> row : rows) {
            tasks.add(getTask(row));
        }
        return tasks;
    }
    public static TasksEntity getDescription(List<String> row) {
        TasksEntity task = new TasksEntity();
        task.setDescription(row.get(0));
        return task;
    }
    public static List<TasksEntity> getDescriptions(List<List<String>> rows) {
        List<TasksEntity> tasks = new ArrayList<>();
        for (List<String> row : rows) {
            tasks.add(getDescription(row));
        }
        return tasks;
    }

}
