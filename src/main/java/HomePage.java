import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By homePageName = By.xpath("//div[@id = 'profile']/h2");

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    //Find the page name
    public String findPageName () {

        return driver.findElement(homePageName).getText();
    }
}
