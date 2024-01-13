import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ShoppingCartTest {
    WebDriver driver;
    WebDriverWait wait;
    private LoginPage loginPage;
    private ShoppingCartPage shoppingCartPage;
    @BeforeClass
    public void setup() {
        System.setProperty("chromedriver.exe", "C:\\Users\\Vinit\\Documents\\Selenium\\src\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);}
    @Test
    public void testCheckoutProcess() {
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        shoppingCartPage.addToCart(1);
        shoppingCartPage.addToCart(2);
        shoppingCartPage.goToCart();
        shoppingCartPage.proceedToCheckout();
        shoppingCartPage.fillCheckoutInfo("Vinit", "Pune", "410242");
        shoppingCartPage.finishCheckout();
        Assert.assertEquals(shoppingCartPage.getSuccessHeader(), "Thank You VisiT Again");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
