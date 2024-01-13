package   pageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class loginSteps {

    private WebDriver webDriver;

    public loginSteps(){
        super();
        this.webDriver = Hooks.webDriver;
    }

    @Given("user open the web page")
    public void verifyLoginPage (){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.isDisplayed();
    }

    @When("user input \"(.*)\" as userName and \"(.*)\" as password")
    public void inputCredential(String userName,String password){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }

    @Then("user go to inventory page")
    public void verifyInventoryPage() throws InterruptedException {
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        Assert.assertTrue(inventoryPage.displayed());
        Thread.sleep(4000);
    }

    @Then("user will get \"(.*)\" on login page")
    public void verifyErrorMessage(String errorText){
        LoginPage loginPage = new LoginPage(webDriver);
        assertEquals(errorText, loginPage.getErrorMessage());
    }
}
