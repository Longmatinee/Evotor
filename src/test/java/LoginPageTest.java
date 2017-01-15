import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class LoginPageTest {

    WebDriver driver;
    LoginPage objLoginPage;
    HomePage objHomePage;

    @Before
    public void setup() {

        //Путь к вебдрайверу. Необходимо указать свой.
        String PATH_TO_CHROMEDRIVER_EXE = "D:\\Java\\chromedriver\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER_EXE);
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("https://lk.evotor.ru/web/login");
    }

    @Test
    public void loginInvalidData() {

        objLoginPage = new LoginPage(driver);
        objLoginPage.loginAs("80000000001", "TestPassw0rd!");
        Assert.assertTrue(objLoginPage.alertWrongData());
    }

    @Test
    public void loginNoLogin() {

        objLoginPage = new LoginPage(driver);
        objLoginPage.loginAs("", "TestPassw0rd!");
        Assert.assertTrue(objLoginPage.alertNoLogin());
    }

    @Test
    public void loginNoPass() {

        objLoginPage = new LoginPage(driver);
        objLoginPage.loginAs("80000000001", "");
        Assert.assertTrue(objLoginPage.alertNoPass());
    }

    @Test
    public void loginNoData() {

        objLoginPage = new LoginPage(driver);
        objLoginPage.pushLoginButton();
        Assert.assertTrue(objLoginPage.alertNoLogin());
    }

    //Тест с валидными данными. Сделан в таком виде, потому что нет корректных данных.
    @Test
    public void loginValidData() {

        objLoginPage = new LoginPage(driver);
        objLoginPage.loginAs("valid_login", "valid_pass");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.findPageName().contains("profile"));

    }


    @After
    public void closeTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
