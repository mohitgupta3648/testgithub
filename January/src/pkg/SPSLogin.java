package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SPSLogin {
	@Test(dataProvider="SPS_Data")
	public static void main(String[] args) throws Exception
	{	
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		driver.get("https://brakes-uat.sps-ocs.co.uk/");
		driver.manage().window().maximize();
		
		WebElement Login = driver.findElement(By.xpath(".//*[@id='homelogin-option']"));
		Login.click();
		Thread.sleep(5000);
		WebElement user=driver.findElement(By.xpath(".//*[@id='login-username-txt']"));
		user.sendKeys("super@no.mail");
		WebElement password=driver.findElement(By.xpath(".//*[@id='login-password-txt']"));
		password.sendKeys("Password$1234");
		Thread.sleep(3000);
		WebElement Login_Submit = driver.findElement(By.xpath(".//*[@id='quick-login-submit-btn']"));
		Login_Submit.click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.quit();
	}
	@DataProvider(name="SPS_Data")
	public Object[][] passData()
	{
		Object [][] data=new Object[3][2];
		data[0][0]="Final";
		data[0][1]="Espire@123";
		
		data[1][0]="Create2";
		data[1][1]="Espire@123";
		
		data[2][0]="Create3";
		data[2][1]="Espire@123";
		
		return data;
	}
}
