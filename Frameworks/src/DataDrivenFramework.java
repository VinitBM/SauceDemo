import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import orq.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;






import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class DataDrivenFramework {

	public static void main(String[] args) {
		try {
			WebDriverManager.chromedriver().setup();
			ChromeDriver
			
			driver = new ChromeDriver();
			Thread.sleep(2000);
			driver.manage().timeout().implicityWait(Duration.   ofSeconds(10));
			FileInputStream fis = new FileInputStream("C:ProgramData");
			Properties p =new Properties();
			p.load(fis));
			String url = p.getProperty("url");
			String un = p.getProperty("username");
			String pw = p.getProperty("password");
			get.get(url);
			WebElement userName= driver.findElement(By.xpath("//input[@id='user-  name']"));
			WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
			WebElement loginButton =  driver.findElement(By.xpath("//input[@id='login button']"));
			username.sendKeys(un);
			Thread.sleep(3000);
			Password.sendKeys(pw);
			Thread.sleep(3000);
			loginButton.click();
			WebElement menubutton = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn]"));
			WebElement logout= driver.findElement(By.xpath("//a[@id="logout_sidebar_link]")");
			Thread.sleep(3000);
			menuButton.click();
			Thread.sleep(3000);
			logout.click();
			Thread.sleep(3000);
			driver.quit();
		}
		catch(Exception e)
		
		System.out.println(e.getMessage());
	}
}
}

			
		}

	}

}
