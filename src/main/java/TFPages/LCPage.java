package TFPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LCPage {
    private final SHAFT.GUI.WebDriver driver;
    private final By expiryPlace = By.id("ExpiryPlace");
    private final By expiryDateId = By.name("ExpiryDate");
//    private final By selectDate = By.xpath("(//div[contains(@class, 'datepicker--cell-day') and text()='27'])[1]");
    private final By lCAmount = By.id("LCAmount");
    private final By requestSubType = By.id("RequestSubType");
    private final By selectSubType=By.xpath("//select[@id='RequestSubType']/option[@value='1']");
    private final By source = By.id("Source");
    private final By selectedSource = By.xpath("//select[@id='Source']/option[@value='1']");
    private final By beneficiaryId =  By.id("BeneficiaryId");
    private final By selectBeneficiaryId = By.xpath("//select[@id='BeneficiaryId']/option[@value='42']");
    private final By saveUpdates = By.xpath("//input[@class='btn btn-white colored-red ']");

    public LCPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void createLC(){
        driver.element().type(expiryPlace,"11");
        driver.element().click(source);
        driver.element().click(selectedSource);
        driver.element().click(requestSubType);
        driver.element().click(selectSubType);
        driver.element().click(beneficiaryId);
        driver.element().click(selectBeneficiaryId);
        driver.element().type(lCAmount,"100");
        driver.element().type(expiryDateId,"12202027");
//        driver.element().click(selectDate);
        driver.element().click(saveUpdates);

    }
}
