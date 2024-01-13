import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit ;

public class FailedLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    WebDriverWait wait;
    @BeforeClass
    public void setup() {
        System.setProperty("chromedriver.exe", "C:\\Users\\Vinit\\Documents\\Selenium\\src\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(driver);
      homePage = new HomePage(driver);
    }
    @Test
    public void failedLoginWithWrongPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        String expectedErrorMessage = "Username and password do not match any user in this service";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error  message displayed");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
