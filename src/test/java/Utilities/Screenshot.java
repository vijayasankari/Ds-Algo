package Utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screenshot {
	static WebDriver driver;
	WebDriverWait wait;
	public Screenshot() {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
public static void takeScreenshot(String stepName) throws IOException, Exception, AWTException {
		
		
		
		try {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		String TCName = "Stack";
		String dir = System.getProperty("user.dir");
		
		//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		LocalDateTime now = LocalDateTime.now();

		// Define the format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");

		// Format the current date and time
		String timestamp = now.format(formatter);

		String path = dir + "/src/test/resources/screenshots/"+TCName+"/screenshot_"+stepName+"_"+timestamp+".jpeg";
		
		File destFile = new File (path);
		
		FileUtils.copyFile(srcFile, destFile);
		}
		catch(Exception e) {
			
			BufferedImage Alertscreenshot = new Robot().createScreenCapture
					(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			String TCName = "TC_001";
			String dir = System.getProperty("user.dir");
			//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			LocalDateTime now = LocalDateTime.now();

			// Define the format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");

			// Format the current date and time
			String timestamp = now.format(formatter);

			String path = dir + "/src/test/resources/screenshots/"+TCName+"/screenshot_"+stepName+"_"+timestamp+".jpeg";
			
			ImageIO.write(Alertscreenshot, "png", new File (path));
		}
		
		
	}

}
