package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.TasksDAO;
import com.ita.speakukrainian.utils.jdbc.entity.TasksEntity;

import java.util.List;

public class TasksServise {
    private final TasksDAO tasksDao;
    public TasksServise() {
        tasksDao = new TasksDAO();
    }

    public List<TasksEntity> getAllTasks() {
        return tasksDao.selectAll();
    }
    public List<TasksEntity> getDescription(String s) {

        return tasksDao.selectDescription(s);
    }
}
