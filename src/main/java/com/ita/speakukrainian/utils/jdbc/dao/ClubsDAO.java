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
}
