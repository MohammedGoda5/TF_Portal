package TFPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final SHAFT.GUI.WebDriver driver;
    private final By userName = By.id("UserName");
    private final By password = By.id("Password");
    private final By login = By.xpath("//button[@class='btn btn-teal']");

    public HomePage Login(String username, String Password) {
        driver.element().type(userName,"enduser");
        driver.element().type(password,"P@ssw0rd");
        driver.element().click(login);
        return new HomePage(driver);
    }
}
