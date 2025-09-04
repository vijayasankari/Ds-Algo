package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private static Properties prop = new Properties();
    


	public static String filepath;
    public static String SheetName;
    private static String browserType=null;
    
    static {
        try (FileInputStream ip = new FileInputStream("./src/test/resources/Config/config.properties")) {
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }
    


	public static void setBrowserType(String browser) {
		browserType = browser;
		System.out.println("configReader-setbrowser"+browser);
	}

    public static String getBrowserType() {
    	if (browserType!=null) {
    		System.out.println("configReader-getbrowser"+browserType);
    		return browserType;
    	}
    	else
    		throw new RuntimeException("browser not specified in the testng.xml");
	}


    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
    
    
}
