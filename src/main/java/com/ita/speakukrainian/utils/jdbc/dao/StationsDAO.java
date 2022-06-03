package com.ita.speakukrainian.utils.jdbc.dao;

import com.ita.speakukrainian.utils.jdbc.entity.StationEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StationsDAO {
    public List<StationEntity> selectAll() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(StationEntity.SELECT_ALL);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDao.getInstance().closeStatement(statement);
        return  StationEntity.getStations(rows);
    }
}
