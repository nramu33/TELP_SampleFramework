//Author:Ramu Nimmana
package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.qa.listener.TestListener;
import com.qa.util.TestUtil;

@Listeners({TestListener.class})
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	Logger log = Logger.getLogger(TestBase.class);
	public TestBase() {
		readConfigPropertiesFile();
	}

	@BeforeSuite
	public void setUp() {
		readConfigPropertiesFile();
		initialization();
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
			System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browser.toLowerCase().contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		log.info("Launching Browser");
		driver.manage().window().maximize();
		log.info("Maximizing Browser");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		log.info("Page Load Timeout set to: "+TestUtil.PAGE_LOAD_TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		log.info("Implicit Timeout set to: "+TestUtil.IMPLICT_WAIT);
		driver.get(prop.getProperty("url"));
		log.info("Opening url: "+prop.getProperty("url"));
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}