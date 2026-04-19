package TFPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage{
    // Declarations
    private final SHAFT.GUI.WebDriver driver;
    private final By IDC = By.xpath("//button[@class='ButtonClass'][1]");
    private final By EDC = By.xpath("//button[@class='ButtonClass'][2]");
    private final By AP = By.xpath("//button[@class='ButtonClass'][3]");
    private final By ILC = By.xpath("//button[@class='ButtonClass'][4]");
    private final By ELC = By.xpath("//button[@class='ButtonClass'][5]");
    private final By ILG = By.xpath("//button[@class='ButtonClass'][6]");
    private final By ELG = By.xpath("//button[@class='ButtonClass'][7]");

    // Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Navigations
    // Home page navigation

    public LGPage NavigateToILG() {
        driver.element().click(ILG);
        return new LGPage(driver);
    }

    public LGPage NavigateToELG() {
        driver.element().click(ELG);
        return new LGPage(driver);
    }

    public LCPage NavigateToILC() {
        driver.element().click(ILC);
        return new LCPage(driver);
    }

    public LCPage NavigateToELC() {
        driver.element().click(ELC);
        return new LCPage(driver);
    }

    public DCPage NavigateToIBC() {
        driver.element().click(IDC);
        return new DCPage(driver);
    }

    public DCPage NavigateToOBC() {
        driver.element().click(EDC);
        return new DCPage(driver);
    }
    public APPage NavigateToAP() {
        driver.element().click(AP);
        return new APPage(driver);
    }

}
