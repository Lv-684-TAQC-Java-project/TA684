package com.ita.speakukrainian.utils.jdbc.dao;

import com.ita.speakukrainian.utils.jdbc.entity.ChallengesEntity;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ChallengesDAO {

    public List<ChallengesEntity> selectByNamePictureSortNumberTitle(String getsortnumber,int getsortnumberint) {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ChallengesEntity.SELECT_ALL,getsortnumber,getsortnumberint));
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDao.getInstance().closeStatement(statement);

        return ChallengesEntity.getChallenges(rows);
    }

    public List<ChallengesEntity> selectByNameWhereId(long getsortnumberint) {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ChallengesEntity.SELECT_NAME_WHERE_ID,getsortnumberint));
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDao.getInstance().closeStatement(statement);

        return ChallengesEntity.getChallengesBYName(rows);
    }


}
