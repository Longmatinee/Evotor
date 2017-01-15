import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By username = By.id("j_username");
    By password = By.id("j_password");
    By login = By.cssSelector("#login_form_id > fieldset > div.form-group.buttons-container > button");
    By wrongUserData = By.id("spring_security_user_data.errors");
    By noLogin = By.id("j_username.errors");
    By noPass = By.id("j_password.errors");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!"Эвотор.ЛК".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not Evotor login page");
        }
    }

    public void setUsername(String strUsername) {

        driver.findElement(username).sendKeys(strUsername);
    }

    public void setPassword(String strPassword) {

        driver.findElement(password).sendKeys(strPassword);
    }

    public void pushLoginButton() {

        driver.findElement(login).click();
    }

    public void loginAs(String strUsername, String strPassword) {

        setUsername(strUsername);
        setPassword(strPassword);
        pushLoginButton();
    }

    public boolean alertWrongData() {

        if ("Неверный логин или пароль".equals(driver.findElement(wrongUserData).getText())) {
            return true;

        } else return false;
    }

    public boolean alertNoLogin() {

        if ("Введите телефон".equals(driver.findElement(noLogin).getText())) {
            return true;
        } else return false;
    }

    public boolean alertNoPass() {
        if ("Введите пароль".equals(driver.findElement(noPass).getText())) {
            return true;
        } else return false;
    }
}
