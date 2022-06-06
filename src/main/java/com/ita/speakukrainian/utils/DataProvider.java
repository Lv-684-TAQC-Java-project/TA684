package com.ita.speakukrainian.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProvider {
    private final Properties properties;

    public DataProvider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/data.properties");
        properties = new Properties();
        properties.load(fileInputStream);
    }

    public String getJDBCLogin() {

        return properties.getProperty("jdbc_login");
    }

    public String getJDBCPassword() {
        return properties.getProperty("admin_password");

    }

    public String getJDBCUrl() {
        return properties.getProperty("jdbc_url");

    }
}
