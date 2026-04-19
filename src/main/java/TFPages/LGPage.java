package TFPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LGPage {
    private final SHAFT.GUI.WebDriver driver;
    private final By expiryPlace = By.id("ExpiryPlace");
    private final By expiryDateId = By.id("ExpiryDateId");
    private final By selectDate = By.xpath("(//div[contains(@class, 'datepicker--cell-day') and text()='27'])[2]");
    private final By lGAmount = By.id("LGAmount");
    private final By relatedReference = By.id("RelatedReference");
    private final By beneficiaryId = By.id("BeneficiaryId");
    private final By selectBeneficiaryId = By.xpath("//select[@id='BeneficiaryId']/option[@value='42']");
    private final By saveUpdates = By.xpath("//input[@class='btn btn-white colored-red']");
    private final By applicationRuleId = By.id("ApplicationRuleId");
    private final By selectApplicationRule = By.xpath("//select[@id='ApplicationRuleId']/option[@value='93']");

    public LGPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void createLG() {
        driver.element().type(relatedReference,"111");
        driver.element().type(expiryPlace, "11");
        driver.element().click(beneficiaryId);
        driver.element().click(selectBeneficiaryId);
        driver.element().type(lGAmount, "100");
        driver.element().click(applicationRuleId);
        driver.element().click(selectApplicationRule);
        driver.element().click(expiryDateId);
        driver.element().click(selectDate);
        driver.element().click(saveUpdates);

    }
}
