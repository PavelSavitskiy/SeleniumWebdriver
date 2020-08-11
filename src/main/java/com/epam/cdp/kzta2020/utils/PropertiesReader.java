package com.epam.cdp.kzta2020.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private String propertyPath = "src/main/resources/configs/config.properties";

    public String getProperties(String propertyKey) {
        FileInputStream fis;
        Properties property = new Properties();
        String propertyValue = null;
        try {
            fis = new FileInputStream(propertyPath);
            property.load(fis);
            propertyValue = property.getProperty(propertyKey);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return propertyValue;
    }
}