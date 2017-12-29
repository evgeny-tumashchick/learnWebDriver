package com.tumashchick.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AccessProperties {

    private Properties properties;
    private InputStream inputStream = null;
    private String propertiesFileName;

    public AccessProperties() {
        this.properties = new Properties();
        this.propertiesFileName = "users.properties";
    }

    public String getPropertyValueByName(String propertiesName) {
        String value = null;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
            properties.load(inputStream);
            value = properties.getProperty(propertiesName);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}
