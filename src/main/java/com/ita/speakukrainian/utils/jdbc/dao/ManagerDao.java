package com.ita.speakukrainian.utils.jdbc.dao;

import com.ita.speakukrainian.utils.DataProvider;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerDao {
    public static volatile ManagerDao instance = null;
    private final Map<Long, Connection> connections;
    private final String userName;
    private final String password;
    private final String url;
    private DataProvider property;

    private ManagerDao() {
        connections = new HashMap<>();
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            property = new DataProvider();

        } catch (IOException e) {
            e.printStackTrace();
        }
        userName = property.getJDBCLogin();
        password = property.getJDBCPassword();
        url = property.getJDBCUrl();
    }

    public static ManagerDao getInstance() {
        if (instance == null) {
            synchronized (ManagerDao.class) {
                if (instance == null) {
                    instance = new ManagerDao();
                }
            }
        }
        return instance;
    }

    public static void closeAllConnection() {
        if (instance != null) {
            for (Map.Entry<Long, Connection> entry : instance.connections.entrySet()) {
                try {
                    entry.getValue().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        Long idThread = Thread.currentThread().getId();
        Connection connection = connections.get(idThread);
        if (connection == null) {
            connection = createConnection();
            connections.put(idThread, connection);
        }
        return connection;
    }

    public Statement getStatement() {
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
    public static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<List<String>> parseResultSet(ResultSet resultSet) throws SQLException {
        List<List<String>> result = new ArrayList<>();
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            List<String> row = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(resultSet.getString(i));
            }
            result.add(row);
        }
        return result;
    }

}
