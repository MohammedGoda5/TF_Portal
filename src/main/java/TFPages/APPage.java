package TFPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class APPage {
    private final SHAFT.GUI.WebDriver driver;
    private final By receivedFromRef = By.id("ReceivedFromRef");
    private final By collectionAmount = By.id("CollectionAmount");
    private final By directorySuffix = By.id("DirectorySuffix");
    private final By facilitySource = By.id("FacilitySourceEnum");
    private final By selectFacilitySource = By.xpath("//select[@id='FacilitySourceEnum']/option[@value='1']");
    private final By commercialRegistrationNumber = By.id("CommercialRegistrationNumber");
    private final By saveUpdates = By.xpath("//input[@class='btn btn-white colored-red ']");

    public APPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void createAP(){
        driver.element().type(receivedFromRef,"111");
        driver.element().type(collectionAmount,"111");
        driver.element().type(directorySuffix,"0010-601258-111");
        driver.element().click(facilitySource);
        driver.element().click(selectFacilitySource);
        driver.element().type(commercialRegistrationNumber,"11111");
        driver.element().click(saveUpdates);
    }
}
