package log4jtest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class log4jcheck {
	
	WebDriver driver;
	Logger log=Logger.getLogger(log4jcheck.class);
	
	@BeforeMethod
	
	public void setup() {
		log.info("***********test execution starts******************");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saran\\Downloads\\selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		log.info("chrome driver initilized");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		log.info("url passed");
		log.warn("simple warning");
	}
	
	@Test
	public void titlechecktest() {
		
		SoftAssert sa=new SoftAssert();
		log.info("assertion check and initilize");
	
		String title=driver.getTitle();
		System.out.println(title);
		
		sa.assertEquals(title, "Facebook – log in or sign up","title page mismatch");
		sa.assertAll();
		
	}
	@Test
	public void titlechecktest2() {
		SoftAssert sa1=new SoftAssert();
		log.info("assertion check and initilize");
	
		String title=driver.getTitle();
		System.out.println(title);
		
		sa1.assertEquals(title, "Facebook – log in or sign up","title page mismatch");
		sa1.assertAll();
		
	}
	@Test
	public void titlechecktest3() {
		
		SoftAssert sa2=new SoftAssert();
		log.info("assertion check and initilize");
	
		String title=driver.getTitle();
		System.out.println(title);
		log.info("check asser condition");
		sa2.assertEquals(title, "Facebook – log in or sign uphfdg","title page mismatch");
		sa2 .assertAll();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		log.info("************************browser close*********************");
		driver.quit();
	}

}
