package Frameworks;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HybridFramework {

    public static void main(String[] args) {
        try {
           //ebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            Thread.sleep(4000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

            FileInputStream fis = new FileInputStream("D:\\Eclips\\SeleniumProject\\src\\Frameworks\\Data.properties");
            Properties p = new Properties();
            p.load(fis);
            String urlValue = p.getProperty("input.url");
            String userNameValue = p.getProperty("input.username");
            String passwordValue = p.getProperty("input.password");
            String userNameLocator = p.getProperty("locator.username");
            String passwordLocator = p.getProperty("locator.password");
            String loginButtonLocator = p.getProperty("locator.loginbtn");
            String menuButtonLocator = p.getProperty("locator.menubtn");
            String logoutLocator = p.getProperty("locator.logout");

            driver.get(urlValue);
            WebElement userName = driver.findElement(By.xpath(userNameLocator));
            WebElement password = driver.findElement(By.xpath(passwordLocator));
            WebElement loginButton = driver.findElement(By.xpath(loginButtonLocator));
            userName.sendKeys(userNameValue);
            Thread.sleep(2000);
            password.sendKeys(passwordValue);
            Thread.sleep(3000);
            loginButton.click();

            WebElement menuButton = driver.findElement(By.xpath(menuButtonLocator));
            WebElement logout = driver.findElement(By.xpath(logoutLocator));
            Thread.sleep(3000);
            menuButton.click();
            Thread.sleep(2000);
            logout.click();
            Thread.sleep(3000);
            driver.quit();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
