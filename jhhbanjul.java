package SpicejetAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_ClassSpiceJet{
	
//	login->flight finder->select flight->book flight->flight confirmation		
	
	
	public static WebDriver driver;
//	Actions actions = new Actions(driver);		//don't declare obj outside of class
  //  JavascriptExecutor js = (JavascriptExecutor) driver;			//use for scroll of the element but mouse hover(move to element) do work here

	//METHOD 1 : for wait
	public void wait(int wt) {	
		try {
			Thread.sleep(wt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//METHOD2
	public void captureScreenshot(String msg) {							// FOR SCREEENSHOT

		System.out.println("Screenshot for " + msg);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss"); //yyyy-MM-dd
		String dateTime = sdf.format(date);
		String fileName = "screenshot_" + dateTime;
		
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\src\\test\\resources\\Screenshots\\" + fileName + ".png");		// EXPLAIN PATH!   . FOR CURRENT PROJECT FOLDER -> src->test-> resources -> screenshot
		
		
			try {
				FileUtils.copyFile(srcFile, destFile);										// TO COPY SCREENSHOT FILE IN DESTINATION FILE 
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
	
	
	@BeforeClass
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver",".\\UtilitesRequire\\ChromeDriver\\chromedriver105.exe");
		
//		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
// YOU NEED TO ADD JAR OF WEBDRIVER MANAGER
//		// to launch chrome browser
		WebDriverManager.chromedriver().setup();
//		
//		// to launch firefox browser
//		WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver(); // FirefoxDriver();
		driver.get("https://www.spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		System.out.println("Test Step:  LOGIN -> FLIGHT FINDER -> SELECT FLIGHT -> BOOK FLIGHT -> FLIGHT CONFIRMATION -> LOGOUT");
		
	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}
	
	
	
  @Test(priority=1)
  public void LogIn() {
	  By LoginBtn = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[1]/div/div");
	  By EmailRBtn = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div/div[2]/div[2]/div/div[2]");
	  By EmailTxtBox = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[4]/div[2]/input");
	  By PassTxtBox = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[5]/div[1]/div[2]/input");
	  By LoginBtn2 = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[5]/div[3]");
	  By VisibilityTest = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div/div[2]/div[2]/div");
	  driver.findElement(LoginBtn).click();
	  wait(2020);
//	  WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(VisibilityTest));
//	  Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[1]/div[1]/input")));
//	 WebElement visiTest = driver.findElement(VisibilityTest);
//	 if(visiTest.isDisplayed()==true)
	  driver.findElement(EmailRBtn).click();
	  wait(900); 
	  driver.findElement(EmailTxtBox).sendKeys("anjulgupta1205@gmail.com");
	  driver.findElement(PassTxtBox).sendKeys("Anjul12$");
	  wait(500);
	  driver.findElement(LoginBtn2).click();
	  wait(6000);
	  
  }
  
  
  
  
  
  @Test(priority=2)
  public void FlightFinder() {
	  
	  By FlightOption = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[1]/div[2]");
	  By OneWayRB = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[1]");
	  By FromTB = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div");
	  By ToTB = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div/div[2]/input");
//	  By DeptDate = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]");
	  By ReturnDate = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div[2]/div[1]");
	  By Passenger = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div");
	  By Currency = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[2]/div/div[2]");
	  By searchFlightBtn = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div");

	 driver.findElement(FlightOption).click();
	 wait(500);
	 driver.findElement(OneWayRB).click();
	 wait(500);
	 driver.findElement(FromTB).sendKeys("Dehradun (DED)");
	 wait(500);
	 driver.findElement(ToTB).sendKeys("Mumbai (BOM)");
	 wait(500);
	 			
//	 driver.findElement(DeptDate).click();															//no need of clicking this it opens automatically
//	 wait(900); 
	 WebElement dateChoice = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div"));
		Actions actions = new Actions(driver);														//for mouse hover to select date
		actions.moveToElement(dateChoice).click().build().perform();								//used "actions" since 
		
	 
	 
	 wait(800);
	if( driver.findElement(ReturnDate).isEnabled()==false)
	{
		System.out.print("It is one way Ticket");
	}
	
//	Actions actions = new Actions(driver);
	WebElement Passengers = driver.findElement(Passenger);
	actions.moveToElement(Passengers).click().build().perform();									// for passenger stuff
	
	
	WebElement adultmore = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]"));
	WebElement adultless = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[1]"));
	WebElement childmore = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[3]"));
	WebElement childless = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]"));
	WebElement infantmore = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[3]"));
	WebElement infantless = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[1]"));
	WebElement doneBTN = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[2]/div"));
	wait(900);
	for(int i =0; i<2; i++) {
	actions.moveToElement(adultmore).click();
	wait(1000);
	}
	actions.build().perform();
	wait(900);
	for(int i =0 ; i<2; i++) {
		actions.moveToElement(childmore).click();
		wait(1000);
	}
	actions.build().perform();
	wait(900);
	
	actions.moveToElement(doneBTN).click().perform();
	wait(500);

	driver.findElement(Currency).click();
	wait(1000);
    
     WebElement INR = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[2]/div[2]/div[2]/div/div[1]"));
     actions.moveToElement(INR).click().build().perform();
     wait(2000);
     driver.findElement(searchFlightBtn).click();
     wait(8000);
     
     WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20));
 	waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-container\"]/div/div[3]/div/div[1]/div[1]/div/div[1]")));
 	 
  }
  
  
  
  
  @Test(priority=3)
	 public void SelectFlight() {
	  
		Actions actions = new Actions(driver);	
		System.out.println("1");
		driver.findElement(By.xpath("//*[@id=\"list-results-section-0\"]/div[1]/div[2]/div[2]/div/div[2]/div")).click();
		wait(1000);
		System.out.println("11");
		WebElement FirstFlight = driver.findElement(By.xpath("//*[@id=\"list-results-section-0\"]/div[5]/div/div/div[2]/div[1]/div/div/div/div[1]/div[1]/svg/circle"));
		System.out.println("111");
		if(FirstFlight.isDisplayed()==true)
		{
			actions.moveToElement(FirstFlight).click().build().perform();
			wait(1000);
			System.out.println("1111a");
		}
		else
		{
			System.out.print("There is no flight Available");
			System.out.println("1111b");
			driver.quit();
		}
		
		System.out.println("11111");
		WebElement ContinueBTN = driver.findElement(By.xpath("//*[@id=\"replacedbutton\"]"));
		wait(2000);
		actions.moveToElement(ContinueBTN).click().build().perform();
		System.out.println("71");
		
	 }
  
  
}




































