import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemSortTest {
    WebDriver driver;
    private LoginPage loginPage;
    private ItemSortPage itemSortPage;

    @BeforeClass
    public void setup() {
        System.setProperty("chromedriver.exe","C:\\Users\\Vinit\\Documents\\Selenium\\src\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.Seconds);
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(driver);
        itemSortPage = new ItemSortPage(driver);
    }
    @Test
    public void testSorting() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        itemSortPage.selectSortOption("Price (high to low)");
        double firstItemPrice = itemSortPage.getItemPrice(1);
        double secondItemPrice = itemSortPage.getItemPrice(2);
        Assert.assertTrue(firstItemPrice > secondItemPrice, "The first item price is not higher than second item price");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
