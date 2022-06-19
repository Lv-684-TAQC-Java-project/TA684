package com.ita.speakukrainian.utils.jdbc.dao;


import com.ita.speakukrainian.utils.jdbc.entity.TaskEntity;

import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.entity.TasksEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TasksDAO {


    public List<TaskEntity> selectAllByName() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(TaskEntity.SELECT_ALL_BY_NAME);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);
        return TaskEntity.getTasks(rows);
    }

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


    public List<TasksEntity> selectDescription(String s) {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(TasksEntity.SELECT_BY_DESCRIPTION, s));
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        ManagerDao.getInstance().closeStatement(statement);

        return TasksEntity.getDescriptions(rows);
    }

    public List<TasksEntity> selectAllWhereName(String name) {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(TasksEntity.SELECT_ALL_WHERE_NAME,name));
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);
        return TasksEntity.getTasks(rows);
    }



}
