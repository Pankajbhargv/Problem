package SpicejetAutomation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestNG_ClassSpiceJet{
	 WebDriver driver;
	
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
		System.setProperty("webdriver.chrome.driver",".\\UtilitesRequire\\ChromeDriver\\chromedriver105.exe");
		driver = new ChromeDriver(); // FirefoxDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}
	
	
	
  @Test(priority=1)
  public void LogIn() {
	  By LoginBtn = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[1]/div/div");
	  By EmailRBtn = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div[1]/svg/circle");
	  By EmailTxtBox = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[4]/div[2]/input");
	  By PassTxtBox = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[5]/div[1]/div[2]/input");
	  By LoginBtn2 = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[5]/div[3]");
	  
	  driver.findElement(LoginBtn).click();
	  wait(1020);
	  driver.findElement(EmailRBtn).click();
	  wait(900);
	  driver.findElement(EmailTxtBox).sendKeys("anjul.gupta1205@gmail.com");
	  driver.findElement(PassTxtBox).sendKeys("An");
	  driver.findElement(LoginBtn2).click();
	  
	  
	  
	  
	  
	  
  }
}
