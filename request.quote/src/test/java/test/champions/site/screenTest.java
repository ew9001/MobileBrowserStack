package test.champions.site;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class screenTest {
	private static WebDriver driver;
	  public static final String USERNAME = "earlwillis1";
	  public String browser_type;
	  public String fail,error,url,rotate;
	  public String baseUrl = "http://stage.coffee-mate.com";
		public static final String AUTOMATE_KEY = "XsPyFTirN4mH8aCLMB9A";
		static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    int counter=0;
		String local=(new java.io.File("").getAbsolutePath());
		String data="" + local + "/" + "qalist.csv";	
		String myTitle;
	    String safe = "http://10.10.10.34:8080/job/TESTNG3/ws/PageLoads";
	  @Test(groups = {"create"})
		@Parameters({"browser"})
	  @BeforeClass
	  public void beforeClass(String browser) throws IOException, InterruptedException
	  {	   
		  
		  
		  if (browser.equals("mobileGalaxyS3")) {
			  driver=mobileGalaxyS3();
			}
		  

		  else if (browser.equals("chrome")) {
			  driver=browserChrome();
			}
		  
		  else if (browser.equals("firefox")) {
			  driver=browserFirefox();
			}
		  
		  else if (browser.equals("mobileiPhone5S")) {
			  driver=mobileiPhone5S();
			}
		  else if (browser.equals("iPhone5S")) {
			  driver=iPhone5S();
			}
		 
		  
		  else if (browser.equals("safari")) {
			  driver=browserSafari();
			}
		  else if (browser.equals("ie8")) {
			  driver=browserIE8();
			}
		  else if (browser.equals("ie9")) {
			  driver=browserIE9();
			}
		  else if (browser.equals("ie10")) {
			  driver=browserIE10();
		  }
			
		  

		  else if (browser.equals("iPad")) {
			  driver=browserIpad();
			}
		  
		  else if (browser.equals("Android")) {
			  driver=browserAndroid();
			}
		  
		  String name=""+ browser+"/" + browser +"_"+ counter + "_" + "Successful-Completed-Capture.png";
		 
			  System.out.println("Let me see which one get tested " +browser);
			  System.out.println("Image Name " +name);

			  
		 
		  System.out.println("Let me run get driver "+driver);
		  fail=""+ browser+"/Failed/" + timeStamp + "_" + "contact_us.png";
			 
		  String csvFileToRead = data;
		    BufferedReader br =null;
		    String line="";
		    String ext = "png";
		    File dir = new File("/users/agolubev1/Desktop/RondAndroid");
		
		    int lineNumber = 0;

		  
		    
		    
		  	  
		       driver.get("http://champion.pkt-tech.com");
		       Thread.sleep(5000);
		    
		        name=""+ browser+"/portrait/" + browser +"_"+ counter + "_" + "Successful-Completed-Capture.png";
		        takeScreenPortrait(name);
		        driver.findElement(By.id("lb-link")).click();
		        Thread.sleep(5000);
		        JavascriptExecutor jse = (JavascriptExecutor)driver;
		        //jse.executeScript("scroll(0, 100)"); //y value '250' can be altered
		        
		        jse.executeScript("document.body.style.zoom='95%'");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       
		        if (browser.equals("firefox")||browser.equals("ie9")||browser.equals("chrome")||browser.equals("ie10")||browser.equals("safari")||browser.equals("ie8")) {
		        driver.findElement(By.id("tile3")).click();
		        }else {
		        	driver.findElement(By.id("mobile-tile3")).click();
		        }
		        driver.manage().timeouts().implicitlyWait(180000, TimeUnit.SECONDS);
		        name=""+ browser+"/portrait/" + browser +"_"+ counter + "_" + "Successful-Completed-Capture.png";
		        takeScreenPortrait(name);
		        while (counter < 14) {
		        	counter+=1;
		        	Thread.sleep(5000);
		        name=""+ browser+"/portrait/" + browser +"_"+ counter + "_" + "Successful-Captured-Product.png";
		        takeScreenPortrait(name);
		        
		      
		     
		        if(driver.findElement(By.cssSelector("span.arrow-right"))!= null){
		        	System.out.println("Element is Present");
		        	Thread.sleep(5000);
		        	}else{
		        	System.out.println("Element is Absent");
		        	}
		        Thread.sleep(5000);
		   

		        driver.findElement(By.cssSelector("span.arrow-right")).click();
		        Thread.sleep(5000);
		        Thread.sleep(5000);
		        
		        }
		    

		      
	
		 
	    	 driver.quit();   
		
	  }
	  @BeforeTest
	  public void beforeTest()
	  {
		  System.out.println("Let me run beforeTest");
	  }  
	  @Test
	  public void f()
	  {
	       //your test code here
		  System.out.println("I'm out here print f");
	  }
	 @AfterTest
	 public void afterTest()
	 {
	 }
	 @AfterClass
	 public void afterClass()
	 {
	     driver.quit();
	 }

	 public WebDriver mobileGalaxyS3() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run mobileGalaxyS3");
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "android");
		 caps.setCapability("platform", "ANDROID");
		 caps.setCapability("device", "Samsung Galaxy S III");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("rotatable", true);
		 caps.setCapability("deviceOrientation", "landscape");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run mobileGalaxyS3");
	      browser_type="mobileGalaxyS3";
	      System.out.println("Let me see which one get tested" +browser_type);
	      System.out.println("Let me see which one get tested" +driver);
	      driver.get("http://m.crest.com");
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      System.out.println(data);
	      driver.get("http://crest.com");
	      return driver;
	   
	    
	      
	 }  
	


	 public WebDriver browserChrome() throws MalformedURLException  
	 {  
	  
		 browser_type="chrome";
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = DesiredCapabilities.firefox();
		 caps.setCapability("browser", "Chrome");
		 caps.setCapability("browser_version", "32.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Chrome");
	      driver.get("http://yahoo.com");
	      driver.manage().window().maximize();
	      return driver;
	 }
	 
	 public WebDriver browserFirefox() throws MalformedURLException  
	 {  
	  
		 browser_type="firefox";
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = DesiredCapabilities.firefox();
		 caps.setCapability("browser", "Firefox");
		 caps.setCapability("browser_version", "30.0");
		 caps.setCapability("os", "OS X");
		 caps.setCapability("os_version", "Mavericks");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Firefox");
	      driver.get("http://yahoo.com");
	      driver.manage().window().maximize();
	      
	      return driver;
	 }
	 
	 public WebDriver mobileiPhone5S() throws MalformedURLException  
	 {  
	  
		 browser_type="iPhone5S";
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities iPhoneCaps = DesiredCapabilities.iphone();
		 iPhoneCaps.setCapability("browserName", "iPhone");
		 iPhoneCaps.setCapability("platform", "MAC");
		 iPhoneCaps.setCapability("device", "iPhone 5S");
		 iPhoneCaps.setCapability("browserstack.debug", "true");
		 iPhoneCaps.setCapability("rotatable", true);
		 iPhoneCaps.setCapability("deviceOrientation","landscape");
		    driver = new RemoteWebDriver(new URL(URL), iPhoneCaps);
		    
	      System.out.println("Let me run iPhone 5S");
	      driver.get("http://champion.pkt-tech.com");

	     
	      
	      
	      return driver;
	 }
	 
	 public WebDriver iPhone5S() throws MalformedURLException  
	 {  
	  
		 browser_type="iPhone5S";
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities iPhoneCaps = DesiredCapabilities.iphone();
		 iPhoneCaps.setCapability("browserName", "iPhone");
		 iPhoneCaps.setCapability("platform", "MAC");
		 iPhoneCaps.setCapability("device", "iPhone 5S");
		 iPhoneCaps.setCapability("browserstack.debug", "true");
		 iPhoneCaps.setCapability("rotatable", true);
		 iPhoneCaps.setCapability("deviceOrientation","landscape");
		    driver = new RemoteWebDriver(new URL(URL), iPhoneCaps);
		    
	      System.out.println("Let me run iPhone 5S");
	      driver.get("http://champion.pkt-tech.com");

	     
	      
	      
	      return driver;
	 }
	 public WebDriver browserSafari() throws MalformedURLException  
	 {  
	  
		 browser_type="safari";
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Safari");
		 caps.setCapability("browser_version", "6.1");
		 caps.setCapability("os", "OS X");
		 caps.setCapability("os_version", "Mountain Lion");
		 caps.setCapability("browserstack.debug", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Safari");
	      driver.manage().window().maximize();
	      
	      return driver;
	   
	    
	 }
	    

	 
	 public WebDriver browserIE9() throws MalformedURLException  
	 {  
	  
		
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "IE");
		 caps.setCapability("browser_version", "9.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run IE9");
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      driver.manage().window().maximize();
	      return driver;
	   
	    
	 }
	 public WebDriver browserIE8() throws MalformedURLException  
	 {  
	  
		
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "IE");
		 caps.setCapability("browser_version", "8.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run IE8");
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      driver.manage().window().maximize();
	      return driver;
	   
	    
	 }
	 public WebDriver browserIE10() throws MalformedURLException  
	 {  
	  
		
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "IE");
		 caps.setCapability("browser_version", "10.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run IE10");
	      driver.get("http://yahoo.com");
	      driver.manage().window().maximize();
	      return driver;
	   
	    
	 }
	 
	 public WebDriver browserIpad() throws MalformedURLException  
	 {  
	  

		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "iPad");
		 caps.setCapability("platform", "MAC");
		 caps.setCapability("device", "iPad 4th Gen");
		 caps.setCapability("browserstack.debug", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Ipad");
	      driver.get("http://champion.pkt.tech.com");
	      
	      return driver;
	   
	    
	 }
	 
	 public WebDriver browserAndroid() throws MalformedURLException  
	 {  
	  
		
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "android");
		 caps.setCapability("platform", "ANDROID");
		 caps.setCapability("device", "Samsung Galaxy Note 10.1");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Android");
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      
	      return driver;
	   
	    
	 }
	 public WebDriver takeScreenLandscape(String rotate) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
	     System.out.println("Let me take a screenshot " +rotate);
	     ((AndroidDriver)driver).getOrientation();
	     ((AndroidDriver)driver).rotate(ScreenOrientation.LANDSCAPE);
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		   
		    myTitle = driver.getTitle();
		   
		    FileUtils.copyFile(screenshot, new File(rotate));
		    
		    return driver;
	 }
	 
	 public WebDriver takeScreenPortrait(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
	     System.out.println("Let me take a screenshot " +name);

		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		   
		    myTitle = driver.getTitle();
		   
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }
	
	 
	 
	 @AfterMethod(alwaysRun = true, description = "take screenshot on fails") 
	 public void afterMethod_takeScreenshot(ITestResult result) throws Exception { 
	 if (!result.isSuccess()) { 
		 

		 WebDriver augmentedDriver = new Augmenter().augment(driver);
	     System.out.println("I found a bug placed a screen shot @ ContactUS");
		  
		    	
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);

		   
		    FileUtils.copyFile(screenshot, new File(fail));
	
	 } 
	 }


}


