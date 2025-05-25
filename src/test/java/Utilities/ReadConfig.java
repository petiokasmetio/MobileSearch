package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties prop;

    public ReadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/java/Configuration/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Cannot read from config.properties: " + e.getMessage());
        }
    }

    public String getApplicationURL() {
        return prop.getProperty("baseURL");
    }

    public String getCookiesAction() {
        return prop.getProperty("cookiesAction");
    }
}