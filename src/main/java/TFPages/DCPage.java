package TFPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DCPage {
    private final SHAFT.GUI.WebDriver driver;
    private final By documentReleaseList = By.id("DocumentReleaseEnum");
    private final By selectDoc = By.xpath("//select[@id='DocumentReleaseEnum']/option[@value='1']");
    private final By collectionCurrency = By.id("CollectionCurrency");
    private final By selectCurrency = By.xpath("//select[@id='CollectionCurrency']/option[@value='AED']");
    private final By facilitySource = By.id("FacilitySourceEnum");
    private final By selectFacilitySource = By.xpath("//select[@id='FacilitySourceEnum']/option[@value='1']");
    private final By coverLetterDateStr = By.name("CoverLetterDateStr");
    private final By receivedFromRef = By.id("ReceivedFromRef");
    private final By selectDate = By.xpath("(//div[contains(@class, 'datepicker--cell-day') and text()='1'])[2]");
    private final By DirectorySuffix = By.id("DirectorySuffix");
    private final By DocumentKeep = By.id("DocumentKeepEnum");
    private final By selectDocumentKeep = By.xpath("//select[@id='DocumentKeepEnum']/option[@value='1']");
    private final By CollectionAmount = By.id("CollectionAmount");
    private final By commercialRegistrationNumber = By.id("CommercialRegistrationNumber");
    private final By saveUpdates = By.xpath("//input[@class='btn btn-white colored-red']");
    public DCPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void createIDC() {
        driver.element().click(documentReleaseList);
        driver.element().click(selectDoc);
        driver.element().click(collectionCurrency);
        driver.element().click(selectCurrency);
        driver.element().click(facilitySource);
        driver.element().click(selectFacilitySource);
        //the cover letter date added as the current date for now
//        driver.element().click(coverLetterDateStr);
//        driver.element().click(selectDate);
        driver.element().type(receivedFromRef, "111111");
        driver.element().type(DirectorySuffix, "0010-601258-111");
        driver.element().click(DocumentKeep);
        driver.element().click(selectDocumentKeep);
        driver.element().type(CollectionAmount, "100");
        driver.element().type(commercialRegistrationNumber, "1111111");
        driver.element().click(saveUpdates);
    }

    public void createODC() {
        driver.element().click(documentReleaseList);
        driver.element().click(selectDoc);
        driver.element().click(collectionCurrency);
        driver.element().click(selectCurrency);
        driver.element().click(facilitySource);
        driver.element().click(selectFacilitySource);
        //the cover letter date added as the current date for now
//        driver.element().click(coverLetterDateStr);
//        driver.element().click(selectDate);
        driver.element().type(DirectorySuffix, "0010-601258-111");
        driver.element().type(CollectionAmount, "100");
        driver.element().type(commercialRegistrationNumber, "1111111");
        driver.element().click(saveUpdates);
    }

}