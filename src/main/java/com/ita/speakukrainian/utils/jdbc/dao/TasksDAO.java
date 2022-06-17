package com.ita.speakukrainian.utils.jdbc.dao;

import com.ita.speakukrainian.utils.jdbc.entity.TasksEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TasksDAO {
    public List<TasksEntity> selectAll(){
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(TasksEntity.SELECT_ALL);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);
        return TasksEntity.getTasks(rows);
    }


}