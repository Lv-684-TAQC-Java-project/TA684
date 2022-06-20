package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.TasksDAO;
import com.ita.speakukrainian.utils.jdbc.entity.TasksEntity;
import org.testng.ITestContext;

import java.util.List;

public class TasksServise {
    private final TasksDAO tasksDao;
    private ITestContext context;


    public TasksServise() {
        tasksDao = new TasksDAO();
    }

    public TasksServise(ITestContext context) {
        this.context=context;
        tasksDao = new TasksDAO();
    }

    public List<TasksEntity> getAllTasks() {
        List<TasksEntity> tasks = tasksDao.selectAll();
        if(context!=null) {
            String tasksRez = "";
            for (TasksEntity task : tasks) {
                tasksRez += task.toString();
            }
            context.setAttribute("dbData", tasksRez);
        }
        return tasks;

    }

    public List<TasksEntity> getDescription(String s) {
        List<TasksEntity> tasks = tasksDao.selectDescription(s);
        if(context!=null) {
            String tasksRez = "";
            for (TasksEntity task : tasks) {
                tasksRez += task.toString();
            }
            context.setAttribute("dbData", tasksRez);
        }
        return tasks;
    }


    public List<TasksEntity> getAllTasksWhereName(String name) {
        List<TasksEntity> tasks =tasksDao.selectAllWhereName(name);
        if(context!=null) {
            String tasksRez = "";
            for (TasksEntity task : tasks) {
                tasksRez += task.toString();
            }
            context.setAttribute("dbData", tasksRez);
        }
        return tasks;
    }
}
