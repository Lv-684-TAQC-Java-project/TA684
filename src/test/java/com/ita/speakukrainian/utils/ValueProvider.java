package com.ita.speakukrainian.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ValueProvider {
    private final Properties properties;

    public ValueProvider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        properties = new Properties();
        properties.load(fileInputStream);
    }

    public String getAdminEmail() {

        return properties.getProperty("adminEmail");
    }

    public String getAdminPassword() {
        return properties.getProperty("adminPassword");

    }

    public String getContactPhoneNumber() {
        return properties.getProperty("contactPhoneNumber");

    }

    public String getBaseURL() {
        return properties.getProperty("baseURL");
    }


    public String getImage() {
        return properties.getProperty("imageFlower");
    }

    public File getSunFlower() {
        return new File("src/test/resources/img2.png");
    }

    public String getBasePassword(){
        return  properties.getProperty("basePassword");
    }

    public String getBaseEmail(){
        return  properties.getProperty("baseEmail");
    }

    public String getLeaderPassword(){
        return  properties.getProperty("leaderPassword");
    }

    public String getLeaderEmail(){
        return  properties.getProperty("leaderEmail");


    }

}
