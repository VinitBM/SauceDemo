package Framework;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.service.DriverFinder;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenFramework{
	public static void main(String[]args) {
		try {
			 ChromeDriver driver = new ChromeDriver();
			//ChromeDriver driver = new ChromeDriver();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(0, Navigation(10));
			
			FileInputStream fis = new FileInputStream("D:\\Eclips\\SeleniumProject\\src\\Framework\\properties.java");
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String un = p.getProperty("username");
			String pw = p.getProperty("password");
			driver.get(url);
WebElement userName=driver.findElement(By.xpath("//div[@id='login_credentials']"));
WebElement password=driver.findElement(By.xpath("//div[@class='login_password']"));
WebElement loginButoon = driver.findElement(By.xpath("//input@id='login button']"));
userName.sendKeys(un);
Thread.sleep(2000);
password.sendKeys(pw);
Thread.sleep(3000);
WebElement loginButton = null;
loginButton.click();
WebElement menuButton= driver.findElement(By.xpath("button[@id='react-burger-menu=btn']"));
WebElement logout=driver.findElement(By.xpath("//a[@id='logout_sideba r_lin']"));

Thread.sleep(3000);
menuButton.click();
Thread.sleep(4000);
logout.click();
driver.quit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static TimeUnit Navigation(int i) {
		// TODO Auto-generated method stub
		return null;
	}


					
			
		
	}
