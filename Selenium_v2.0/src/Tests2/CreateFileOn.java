package Tests2;


import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFileOn {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	@Parameters({"serverURL","loginEmail","password"})
	@BeforeClass(alwaysRun = true)
	
	public void setUp (String serverURL, String loginEmail, String password) throws Exception {
		driver = (WebDriver) new FirefoxDriver();
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

	@Parameters ({"lawyername", "filenumber", "username"})
	@Test

	public void testCreatefile(String lawyerName, String fileNumber, String username) throws Exception {

	  
    
    driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/ul/li[2]/a/span[1]")).click();
    driver.findElement(By.linkText("ON")).click();
    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div[2]/div/ul/li[4]/a/span")).click();
	driver.findElement(By.linkText ("Create File")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.id("ec_file_lawyer_file_number")).clear();
	driver.findElement(By.id("ec_file_lawyer_file_number")).sendKeys(fileNumber);
	Select droplist2 = new Select(driver.findElement(By.id("ec_file_lawyer_individual_id")));   
	droplist2.selectByVisibleText(lawyerName);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Select droplist1 = new Select(driver.findElement(By.id("new_file_param_lawyer_type")));   
	droplist1.selectByVisibleText("Purchase");  
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//a[contains(text(),'Next')])[2]")).click();
	
	//this next line is for the file number that already exists
	driver.findElement(By.id("jqi_state0_buttonYes")).click();
	username = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/ul/li[1]")).getText();
	Assert.assertEquals(username, username);
	System.out.print("\n assertion_method_1() -> User logged in");
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


 
  }
