package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private static Properties prop = new Properties();

    public static String browser; // optional, only needed if you're using it

    static {
        try (FileInputStream ip = new FileInputStream("./src/test/resources/Config/config.properties")) {
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
