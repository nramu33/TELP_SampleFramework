//Author:Ramu Nimmana
package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.qa.listener.TestListener;
import com.qa.util.Log;
import com.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({TestListener.class})
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String runStartTime;
	public TestBase() {
		readConfigPropertiesFile();
	}

	@BeforeSuite
	public void setUp() {
		setTimeStamp();
		readConfigPropertiesFile();
		initialization();
	}
	private void setTimeStamp() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		runStartTime = currentDateTime.toString();
	}

	private void readConfigPropertiesFile() {
		try {
			prop= new Properties();
			String fileSep = File.separator;
			String currentDir = System.getProperty("user.dir");
			//Platform independent path for E:\MyWorkSpace\TestNgPOM_SE_Test\src\main\java\com\qa\config\config.properties
			String propFilepath = currentDir+fileSep+"src"+fileSep+"main"+fileSep+"java"+fileSep+"com"+fileSep+"qa"+fileSep+"config"+fileSep+"config.properties";
			FileInputStream ip = new FileInputStream(propFilepath);
			prop.load(ip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void initialization() {
		String browser = prop.getProperty("browser");
		if(browser.toLowerCase().contains("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(browser.toLowerCase().contains("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "E:\\GeckoDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			//WebDriver Manager automatically manages the chromedriver for you
			driver = new FirefoxDriver();
		}
		//We need to import Log class 
		//Eg:import com.qa.util.Log;
		Log.info("Launching Browser");
		driver.manage().window().maximize();
		Log.info("Maximizing Browser");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Log.info("Page Load Timeout set to: "+TestUtil.PAGE_LOAD_TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		Log.info("Implicit Timeout set to: "+TestUtil.IMPLICT_WAIT);
		driver.get(prop.getProperty("url"));
		Log.info("Opening url: "+prop.getProperty("url"));
	}
	@AfterSuite
	public static void tearDown() {
		driver.quit();
		renameLogFile();
	}

	private static void renameLogFile() {
		File srcFile = new File("application.log");
		// File (or directory) with new name
		File destFile2 = new File("log_"+runStartTime+".log");
		srcFile.renameTo(destFile2);
	}
}