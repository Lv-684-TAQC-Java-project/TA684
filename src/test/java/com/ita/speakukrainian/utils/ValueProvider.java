package com.ita.speakukrainian.utils;

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

    public String getRegistrationLastName() {
        return properties.getProperty("Світлана");
    }

    public String getRegistrationFirstName() {
        return properties.getProperty("Вайтович");
    }

    public String getRegistrationPhone() {
        return properties.getProperty("0671234567");
    }

    public String getRegistrationEmail() {
        return properties.getProperty("svitlanawhite@gmail.com");
    }

    public String getRegistrationPassword() {
        return properties.getProperty("12345678wW@");
    }

    public String getRegistrationConfirm() {
        return properties.getProperty("12345678wW@");
    }

}
