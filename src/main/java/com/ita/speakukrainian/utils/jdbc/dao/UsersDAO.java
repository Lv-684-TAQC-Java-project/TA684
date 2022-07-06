package com.ita.speakukrainian.utils.jdbc.dao;

import com.ita.speakukrainian.utils.jdbc.entity.CenterEntity;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;
import com.ita.speakukrainian.utils.jdbc.entity.UsersEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsersDAO {
    public List<UsersEntity> selectAllWhereEmail() {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(UsersEntity.SELECT_FROM_USERS_WHERE_EMAIL);
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);
        return UsersEntity.getUsers(rows);
    }

    public List<UsersEntity> selectAllWhereEmailIs(String name) {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(UsersEntity.SELECT_FROM_USERS_WHERE_EMAIL_IS, name));
            rows = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDao.getInstance().closeStatement(statement);
        return UsersEntity.getUsers(rows);
    }
}
