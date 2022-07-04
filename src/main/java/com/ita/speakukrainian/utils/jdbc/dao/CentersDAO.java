package com.ita.speakukrainian.utils.jdbc.dao;

import com.ita.speakukrainian.utils.jdbc.entity.CenterEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CentersDAO {
    public List<CenterEntity> selectAll() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(CenterEntity.SELECT_ALL);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);
        return CenterEntity.getCenters(rows);
    }
    public List<CenterEntity> selectIdNameRatingByDesc() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(CenterEntity.SELECT_ID_NAME_RATING_DESC);

            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);
        return CenterEntity.getCentersIdNameRating(rows);
    }

    public List<CenterEntity> selectIdNameRatingByAsc() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(CenterEntity.SELECT_ID_NAME_RATING_ASC);

            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);

        return CenterEntity.getCentersIdNameRating(rows);

    }

    public List<CenterEntity> selectIdNameAsc() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(CenterEntity.SELECT_NAME_ID_ASC);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);
        return CenterEntity.getIdNamesAsc(rows);
    }

    public List<CenterEntity> selectIdNameDesc() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(CenterEntity.SELECT_NAME_ID_DESC);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);
        return CenterEntity.getIdNamesDesc(rows);
    }



}
