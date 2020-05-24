package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.base.TestBase;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICT_WAIT = 20;
	static WebDriver driver = TestBase.driver;
	static String FILE_SEP = File.separator;
	public static String takeScreenShot(String screenShotName) throws IOException {
		String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") +FILE_SEP+ "test-output" +FILE_SEP+ "screenshots" +FILE_SEP+ screenShotName +"_"+ df + ".png";
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		return path;
	}

}
