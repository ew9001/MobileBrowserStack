package com.trihonda.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.Sheet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;


public class DealerQuoteTest {

	static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	Sheet s; 	
	WebDriver driver;
	public static final String USERNAME = "earlwillis1";
	public static final String AUTOMATE_KEY = "XsPyFTirN4mH8aCLMB9A";

	String folder = "";
	String name="ResponsivePageLoads/" + timeStamp + "_" + "hondacar.png";
	String local=(new java.io.File("").getAbsolutePath());
	String data="" + local + "/" + "infoqa.xls";	
	String myTitle;
    String urlname ="http://yandex.ru";
   
    @Test(groups = {"first"})
	@Parameters({"param"})
	 public void testMe(String param) throws Exception {
		String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = DesiredCapabilities.firefox();
		  caps.setCapability("browser", "FireFox");
		  caps.setCapability("browser_version", "22.0");
		  caps.setCapability("os", "Windows");
		  caps.setCapability("os_version", "7");
		  caps.setCapability("browserstack.debug", "true");

		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);


		    driver.get("http://trihondas.com");

		

		    
		    WebDriver augmentedDriver = new Augmenter().augment(driver);
		    System.out.println("Faield to find the button " +"1");
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		    myTitle = driver.getTitle();
		    FileUtils.copyFile(screenshot, new File(name));
	    	Reporter.log("<a href='"+ local+"/" + name + "'> <img src='"+ local+"/"+ name + " ' height='100' width='100'/>" + "<a href='"+ urlname+"'>'"+ urlname+"'</a> " + " </a>");
			   
		

  }
  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {


  }
  @AfterClass
  public void afterClass() {
  }

  @AfterTest
  public void afterTest() {
	
  }

}
