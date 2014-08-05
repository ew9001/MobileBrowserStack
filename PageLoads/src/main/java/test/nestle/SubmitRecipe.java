package test.nestle;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.ScreenshotListener;

public class SubmitRecipe {

	private static WebDriver driver;
	  public static final String USERNAME = "earlwillis1";
	  public String browser_type,fail;
	  public String baseUrl = "http://stage.coffee-mate.com";
		public static final String AUTOMATE_KEY = "XsPyFTirN4mH8aCLMB9A";
		static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		String local=(new java.io.File("").getAbsolutePath());
		String data="" + local + "/" + "infoqa.xls";	
		String myTitle;
	    String safe = "http://10.10.10.34:8080/job/TESTNG3/ws/PageLoads";
	  @Test(groups = {"recipe"})
		@Parameters({"browser"})
	  @BeforeClass
	  public void beforeClass(String browser) throws IOException, InterruptedException
	  {	   
		  
		  
		  if (browser.equals("firefox")) {
			  driver=browserFirefox();
			}
		  

		 if (browser.equals("chrome")) {
			  driver=browserChrome();
			}
		  
		 if (browser.equals("ie9")) {
			  driver=browserIE9();
			}
		  

		if (browser.equals("iPad")) {
			  driver=browserIpad();
			}
		  
		  if (browser.equals("safari")) {
			  driver=browserSafari();
			}
		  
		 if (browser.equals("Android")) {
			  driver=browserAndroid();
			}
		  
		
		 
		  String name=""+ browser+"/SubmitRecipe/" + timeStamp + "_" + "Successful-Submited-1.png";
		  System.out.println("This script will Submit a Recipe from a user that is not logged in. Script will log the user in first");
		  fail=""+ browser+"/Failed/" + timeStamp + "_" + "submit_recipe.png";
		    driver.get(baseUrl + "/Recipes/Default.aspx");
		  //  driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRightNav_ucSubmitRecipe_txtTitle")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRightNav_ucSubmitRecipe_txtTitle")).sendKeys("Lemon Pie");
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRightNav_ucSubmitRecipe_imgbtnContinue")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("ctl00_ucLoginMain_txtEmail")).clear();
			long end = System.currentTimeMillis() + 7000;
			 while (System.currentTimeMillis() < end) {
		            WebElement resultsDiv = driver.findElement(By.id("ctl00_ucLoginMain_txtEmail"));

		            // If results have been returned, the results are displayed in a drop down.
		            if (resultsDiv.isDisplayed()) {
		            	System.out.println("I found the element to input text");
		            	driver.findElement(By.id("ctl00_ucLoginMain_txtEmail")).click();
		              break;
		            }
		        }
		    

		    driver.findElement(By.id("ctl00_ucLoginMain_txtEmail")).clear();
			//Thread.sleep(2000);
		    driver.findElement(By.id("ctl00_ucLoginMain_txtEmail")).sendKeys("earl.willis@publicismodem.com");
		  //  driver.findElement(By.id("ctl00_ucLoginMain_txtPassword")).clear();
		    driver.findElement(By.id("ctl00_ucLoginMain_txtPassword")).sendKeys("Zaq12wsx!");
		    driver.findElement(By.id("ctl00_ucLoginMain_btnLogin")).click();
		    driver.findElement(By.cssSelector("#ctl00_ucLoginMain_hCloseThankYou > img[alt=\"Close\"]")).click();
		    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_cddlRecipeType"))).selectByVisibleText("Dessert");
		  //  driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctDescription")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctDescription")).sendKeys("This is my recipe for Lemon Pie");
		    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_cddlServings"))).selectByVisibleText("1");
		  //  driver.findElement(By.id("ctl00_ContentPlaceHolder1_CoffeeMateIngredientControl0_txtAmount")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_CoffeeMateIngredientControl0_txtAmount")).sendKeys("cup");
		    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_CoffeeMateIngredientControl0_ddlProductType"))).selectByVisibleText("Liquid");
			Thread.sleep(3000);
		    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_CoffeeMateIngredientControl0_ddlFlavorType"))).selectByVisibleText("Amaretto");
		   // driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAddCoffeeMateIngredient")).click();
		  //  driver.findElement(By.id("ctl00_ContentPlaceHolder1_CoffeeMateIngredientControl1_txtAmount")).clear();
		  //  driver.findElement(By.id("ctl00_ContentPlaceHolder1_CoffeeMateIngredientControl1_txtAmount")).sendKeys("Cream");
		  //  new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_CoffeeMateIngredientControl1_ddlProductType"))).selectByVisibleText("Powder");
		  //  new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_CoffeeMateIngredientControl1_ddlFlavorType"))).selectByVisibleText("Parisian Almond Crme");
		  //  driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctInstructions")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctInstructions")).sendKeys("This is my recipe for Lemon Pie.");

		  //  driver.findElement(By.id("ctl00_ContentPlaceHolder1_OtherIngredientControl0_txtAmount")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_OtherIngredientControl0_txtAmount")).sendKeys("1 cup");
		  //  driver.findElement(By.id("ctl00_ContentPlaceHolder1_OtherIngredientControl0_txtDescription")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_OtherIngredientControl0_txtDescription")).sendKeys("Vanilla");
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_CoreImageButton")).click();
		    for (int second = 0;; second++) {
		    	if (second >= 60) fail("timeout");
		    	try { if ("Thanks for sharing your recipe. We'll send it through our test kitchen to make sure we can make it just as tasty as you can, before we add it to Coffee-mate.com.".equals(driver.findElement(By.cssSelector("div.popinner.thxmsg > p")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
		    takeScreen(name);

		    Assert.assertEquals("Thanks for sharing your recipe. We'll send it through our test kitchen to make sure we can make it just as tasty as you can, before we add it to Coffee-mate.com.", driver.findElement(By.cssSelector("div.popinner.thxmsg > p")).getText());
		    driver.findElement(By.cssSelector("img[alt=\"Close\"]")).click();
		    driver.findElement(By.id("ctl00_ucProfilePanelMain_btnLogout")).click();
		    driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_pnlRecipeSubmission > div.poptop > span.closer > a > img[alt=\"Close\"]")).click();
		  
		  
		  }



		   
		  

		    	
			      	 
		    
		     	   
		  
	    	//Reporter.log("<a href='"+ local+"/" + name + "'> <img src='"+ local+"/"+ name + " ' height='100' width='100'/>" + "<a href='"+ urlname+"'>'"+ urlname+"'</a> " + " </a>");
	    	//Reporter.log("<a href='"+ safe+"/" + name + "'> <img src='"+ safe+"/"+ name + " ' height='100' width='100'/>" + "<a href='"+  myTitle+"'>'"+  myTitle+"'</a> " + " </a>");
	    	  
		
	  


	 public WebDriver browserFirefox() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run Firefox");
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = DesiredCapabilities.firefox();
		 caps.setCapability("browser", "Firefox");
		 caps.setCapability("browser_version", "29.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		  caps.setCapability("browserstack.debug", "true");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Firefox");
	      browser_type="firefox";
	      System.out.println("Let me see which one get tested" +browser_type);
	      System.out.println("Let me see which one get tested" +driver);
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      return driver;
	   
	    
	 }  

	 public WebDriver browserChrome() throws MalformedURLException  
	 {  
	  
		 browser_type="chrome";
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Chrome");
		 caps.setCapability("browser_version", "35.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Chrome");
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      
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
	      
	      
	      return driver;
	   
	    
	 }
	 
	 public WebDriver browserIpad() throws MalformedURLException  
	 {  
	  

		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "iPad");
		 caps.setCapability("platform", "MAC");
		 caps.setCapability("device", "iPad 3rd (7.0)");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Ipad");
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      
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
	 
	 public WebDriver browserSafari() throws MalformedURLException  
	 {  
	  
		
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Safari");
		 caps.setCapability("browser_version", "6.0");
		 caps.setCapability("os", "OS X");
		 caps.setCapability("os_version", "Lion");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	     
	      
	      return driver;
	   
	    
	 }
	 
	 public WebDriver takeScreen(String name) throws IOException
	 {
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
	     System.out.println("Let me take a screenshot" +name);
		  
		    	
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		    myTitle = driver.getTitle();
		   
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }
	
	  public void tearDown() throws Exception {
	    driver.quit();
	    
	  }
	  
	  @AfterMethod(alwaysRun = true, description = "take screenshot on fail") 
		 public void afterMethod_takeScreenshot(ITestResult result) throws Exception { 
		 if (!result.isSuccess()) { 
			 

			 WebDriver augmentedDriver = new Augmenter().augment(driver);
		     System.out.println("I found a bug placed a screen shot @ " +fail);
			  
			    	
			    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);

			   
			    FileUtils.copyFile(screenshot, new File(fail));
		
		 } 
		 }
	  
	 


	}  
