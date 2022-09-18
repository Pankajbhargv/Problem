package SpicejetAutomation;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
//	FileInputStream fis;
//	Properties prop;
//	Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

	
	public void wait(int wt) {	
		try {
			Thread.sleep(wt);
		} catch (InterruptedException e) {
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
	  driver.findElement(PassTxtBox).sendKeys("An);
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
	  By DeptDate = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]/div[2]");
	  By ReturnDate = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div[2]/div[1]");
	  By Passenger = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]");
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
	 														
	 Date date1=new Date();															//for date stuff 
	System.out.println(date1);
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	String date2= dateFormat.format(date1);
	System.out.println(date2);
	String date3="10/12/2022";
	System.out.println("1");
	if(date2.compareTo(date3)<0);
	System.out.println("date is less than today");
	wait(2000);
	System.out.println("11");
	 driver.findElement(DeptDate).click();	//------------------------------------------------yha problem ari hai--------------------
	 wait(900);
	 System.out.println("111");
//	 driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[6]/div")).click();
//	 WebElement month = driver.findElement(month combo locator);
//	 Select monthCombo = new Select(month);
//	 monthCombo.selectByVisibleText("March");
//
//	 WebElement year = driver.findElement(year combo locator);
//	 Select yearCombo = new Select(year);
//	 yearCombo.selectByVisibleText("2015");
//
//	 driver.click(By.linkText("31"));
//	 driver.findElement(By.linkText("15"));
	 
		Actions actions = new Actions(driver);		//for mouse hover to select date
		actions.moveToElement(driver.findElement(By.xpath(date3)));
		actions.click();
		actions.build().perform();
	 
	 
	 wait(800);
	 System.out.println("1111");
	if( driver.findElement(ReturnDate).isEnabled()==false)
	{
		System.out.print("It is one way Ticket");
	}
	System.out.println("11111");
//	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(Passenger));
	actions.click();
																	// for passenger stuff
	By adultmore = By.xpath("");
	By adultless = By.xpath("");
	By childmore = By.xpath("");
	By childless = By.xpath("");
	By infantmore = By.xpath("");
	By infantless = By.xpath("");
	By doneBTN = By.xpath("");
	wait(900);
	for(int i =0; i<2; i++) {
	actions.click(driver.findElement(adultmore));
	}
	wait(900);
	for(int i =0 ; i<2; i++) {
		actions.click(driver.findElement(childmore));
	}
	wait(900);
//	 WebElement Element = driver.findElement(By.linkText("Linux"));
//
//     //This will scroll the page till the element is found		
//     js.executeScript("arguments[0].scrollIntoView();", Element);	
	
	 WebElement Element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[2]/div"));

     //This will scroll the page till the element is found		
//     js.executeScript("arguments[0].scrollIntoView();", Element);
     wait(1000);
     actions.build().perform();
     
     driver.findElement(Currency).click();					//for currency 
     driver.findElement(By.linkText("INR")).click();
     wait(2000);
     driver.findElement(searchFlightBtn).click();
     wait(8000);
     
  }
  
  
  
  
//  @Test(priority=3)
//	 public void SelectFlight() {
//	  By AllFlightsRB = By.xpath("//*[@id=\"list-results-section-0\"]/div[1]/div[2]/div[2]/div/div[2]/div");
//	  List<WebElement> flights = driver.findElements(By.tagName(null))
//	  
//	  
//	  driver.findElement(AllFlightsRB).click();
//	  driver
		 
//	 }
  
  
}




































