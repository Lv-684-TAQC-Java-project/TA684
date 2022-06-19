package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.CentersDAO;
import com.ita.speakukrainian.utils.jdbc.dao.TasksDAO;
import com.ita.speakukrainian.utils.jdbc.entity.TaskEntity;

import java.util.List;

public class TaskServise {
    private final TasksDAO tasksDAO;
    public TaskServise() {
        tasksDAO = new TasksDAO();
    }

    public List<TaskEntity> getAllByName() {
        return tasksDAO.selectAllByName();
    }
}
