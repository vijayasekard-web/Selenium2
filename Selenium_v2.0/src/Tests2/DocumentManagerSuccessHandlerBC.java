package Tests2;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DocumentManagerSuccessHandlerBC {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
  
  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	@Parameters({"serverURL","loginEmail","password"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String serverURL, String loginEmail, String password) throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(serverURL);
    driver.findElement(By.id("login_password")).clear();
    driver.findElement(By.id("login_password")).sendKeys(password);
    driver.findElement(By.id("login_username")).clear();
    driver.findElement(By.id("login_username")).sendKeys(loginEmail);
    driver.findElement(By.id("login-submit")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    //This line is only for test3, when using other url, comment it out
  	driver.findElement(By.linkText("ECONVEYANCE")).click();
    
  }

	@Parameters ({"lawyername", "filenumber", "filetype", "username"})
	@Test
	public void testDocManager(String lawyerName, String fileNumber, String fileType, String username ) throws Exception {

		
		driver.findElement(By.linkText("FILE")).click();
		driver.findElement(By.linkText ("Create File")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("ec_file_lawyer_file_number")).clear();
		driver.findElement(By.id("ec_file_lawyer_file_number")).sendKeys(fileNumber);
		Select droplist2 = new Select(driver.findElement(By.id("ec_file_lawyer_individual_id")));   
		droplist2.selectByVisibleText(lawyerName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select droplist1 = new Select(driver.findElement(By.id("new_file_param_lawyer_type")));   
		droplist1.selectByVisibleText(fileType);  
		driver.findElement(By.xpath("(//a[contains(text(),'Next')])[2]")).click();
		driver.findElement(By.id("jqi_state0_buttonYes")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[4]/form/div[5]/a[2]")).click();
		

    
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/ul/li[10]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/ul/li[10]/ul/li[1]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[1]/table/tbody/tr[2]/td[1]/div/div/div[7]/table/tbody/tr[7]/td[1]/div")).click();

	    
	    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[1]/table/tbody/tr[2]/td[2]/div/input[2]")).click();
	    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[1]/table/tbody/tr[1]/td[2]/div/img")).click();
	    driver.findElement(By.xpath("html/body/div[4]/div[4]/form/div[5]/a[1]")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div/div/div[7]/table/tbody/tr[1]/td[2]/div/a")).click();
	    
	    driver.findElement(By.id("634__cInvoiceNumber")).clear();
	    driver.findElement(By.id("634__cInvoiceNumber")).sendKeys("2413543432132");
	    driver.findElement(By.id("635__lcomp_date")).click();
	    
	    driver.findElement(By.xpath("html/body/div[4]/div[4]/form/div[5]/a[1]")).click();
	    
	   
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   
	    //assertTrue(isElementPresent(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[3]/div/div/div[7]/table/tbody/tr/td[2]/div/a")));
	    //assertTrue(isElementPresent(By.linkText("Account Buyer")));
	  }
	    @AfterClass(alwaysRun = true)
	    public void tearDown() throws Exception {
	      driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[1]/a/span[1]")).click();
          driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[1]/ul/li[2]/a")).click();
	      driver.quit();
	      String verificationErrorString = verificationErrors.toString();
	      if (!"".equals(verificationErrorString)) {
	        fail(verificationErrorString);
	      }
	    }

	    private boolean isElementPresent(By by) {
	      try {
	        driver.findElement(by);
	        return true;
	      } catch (NoSuchElementException e) {
	        return false;
	      }
	    }

	    
	    }
