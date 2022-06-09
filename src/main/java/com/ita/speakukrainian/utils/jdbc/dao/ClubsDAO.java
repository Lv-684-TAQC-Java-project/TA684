package com.ita.speakukrainian.utils.jdbc.dao;

import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClubsDAO {
    public List<ClubsEntity> selectClubs() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(ClubsEntity.SELECT_ALL);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDao.getInstance().closeStatement(statement);
        return  ClubsEntity.getClubs(rows);
    }
//    public List<ClubsEntity> selectAllNames() {
//        Statement statement = ManagerDao.get().getStatement();
//        List<List<String>> rows = null;
//
//        try {
//            ResultSet resultSet = statement.executeQuery(ClubsEntity.SELECT_NAME);
//            rows = ManagerDao.get().parseResultSet(resultSet);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ManagerDao.get().closeStatement(statement);
//        return ClubsEntity.getClubsName(rows);
//    }
    public List<ClubsEntity> selectAllNameClubs() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(ClubsEntity.SELECT_ALL_NAME);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDao.getInstance().closeStatement(statement);
         return ClubsEntity.getClubs(rows);
       // return  ClubsEntity.getIdNames(rows);
    }
    public List<ClubsEntity> selectAllNameClubsUseLike() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(ClubsEntity.SELECT_NAME_USER_WHERE_LIKE);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDao.getInstance().closeStatement(statement);
       // return ClubsEntity.getClubs(rows);
        return  ClubsEntity.getIdNames(rows);
    }

    public List<ClubsEntity> selectByName(String name) {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ClubsEntity.SELECT_BY_NAME, name));
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDao.getInstance().closeStatement(statement);
        return  ClubsEntity.getClubs(rows);
    }
    public ClubsEntity selectById(Long id) {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ClubsEntity.SELECT_BY_ID, id));
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDao.getInstance().closeStatement(statement);
        List<ClubsEntity> clubs = ClubsEntity.getClubs(rows);
        if (clubs.size() == 0 ){
            return null;
        }
        return  ClubsEntity.getClubs(rows).get(0);
    }

    public List<ClubsEntity> selectByUserID(long userId) {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ClubsEntity.SELECT_BY_USER_ID, userId));
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDao.getInstance().closeStatement(statement);
        return  ClubsEntity.getClubs(rows);
    }
}
