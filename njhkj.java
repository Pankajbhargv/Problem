---------------------------HDA.JAVA----------------------------------

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;

public class hda {
   
                WebDriver driver;
                
  @BeforeClass
  public void beforeClass() {
                  System.setProperty("webdriver.chrome.driver", ".//src//HDA//chromedriver.exe");
                  driver = new ChromeDriver();
                  driver.manage().window().maximize();
                  driver.get("the link given in data file");
                  driver.manage().timeouts().implicitlyWait(6500, TimeUnit.MILLISECONDS);          
  }

  @AfterClass  
  public void afterClass() {
                  driver.quit();
  }

  @Test(priority = 1)
  public void consult(String email) throws IOException, InterruptedException {
                  driver.findElement(By.partialLinkText("Consult Our expert")).click();
                  
                  FileInputStream file = new FileInputStream(".//src//HDA//Doctor.xlsx");
                  XSSFWorkbook workbook = new XSSFWorkbook(file);
                  XSSFSheet sheet = workbook.getSheet("Data");
                  int lastRow = sheet.getLastRowNum();
                  
                  for(int i = 1; i<= lastRow; i++) {
                                  String dietitian = sheet.getRow(i).getCell(0).getStringCellValue();
                                  driver.findElement(By.partialLinkText("Consult Our Expert")).click();
                                  Select select = new Select(driver.findElement(By.id("sel1")));
                                  select.selectByVisibleText(dietitian);
                                  Thread.sleep(3000);
                                  driver.findElement(By.id("baa")).click();
                                  Thread.sleep(3000);
                                  String name = sheet.getRow(i).getCell(1).getStringCellValue();
                                  
                                  driver.findElement(By.id("uname")).sendKeys(name);
                                  Thread.sleep(3000);
                                  driver.findElement(By.id("email")).sendKeys(admin123@gmail.com);
                                  Thread.sleep(3000);
                                  String contact = sheet.getRow(i).getCell(i).getCell(2).getRawValue();
                                  driver.findElement(By.id("cno")).sendKeys(contact);
                                  driver.findElement(By.id("book")).click();
                                
                                 Row currentRow = sheet.getRow(i);
                                Cell cell = currentRow.createCell(3);
                                
                                 String bookingConformation = driver.findElement(By.id("suc12")).getText();
                                cell.setCellValue(bookingConfirmation);
                  
                  FileOutputStream OutputFile = new FileOutputStream(".//src//HDA//Doctor.xlsx");
                  workbook.write(OutputFile);
                  workbook.close();
  } }
                  @Test(priority = 2)
                  public void calorie()throws InterruptedException{
                                  driver.findElement(By.partiallinkText("Calorie Chart")).click();
                                  Thread.sleep(3000);
                                  driver.findElement(By.xpath("some /input button")).click();
                                  Thread.sleep(3000);
                                  WebElement element = driver.findElement(By.id("cctable2"));
                                  
                                  List<WebElement> rows  = element.findElements(By.tagName("tr"));
                                  int k =0;
                                  for(WebElement r : rows)
                                  {
                                                  List<WebElement> cols = r.findElements(By.tagName("td"));
                                                  for(int i =0; i< cols.size(); i++)
                                                  {
                                                                  int calories = Integer.valueOf(cols.get(2).getText());
                                                                  if(calories>300)
                                                                                  {k=k+1;
                                                                                  System.out.println("Food Items more than 300 Calories: "+k);
                                                                                  }
                                                                                  }
                                                  }
                                  }
                                  
                  }
                  

