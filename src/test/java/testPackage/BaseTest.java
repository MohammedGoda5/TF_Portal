package testPackage;

import TFPages.*;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
        protected SHAFT.GUI.WebDriver driver;
    private final By doneToaster = By.xpath("//div[@class='toast toast-success']");
    private  SHAFT.TestData.JSON testData;
        protected LoginPage loginPage;
        protected HomePage homePage;
        protected DCPage dcPage;
        protected LCPage lcPage;
        protected LGPage lgPage;
        protected APPage  apPage;
    public void assertSuccessfulSendRequestToChecker(String homePage) {
        driver.verifyThat().browser().url().isEqualTo(homePage);
    }
    public void assertSuccessfulSendRequest() {
        driver.element().verifyThat(doneToaster).exists().perform();
    }
        @BeforeClass
        public void beforeClass() {
            testData = new SHAFT.TestData.JSON("simpleJSON.json");
        }

        @BeforeMethod
        public void beforeMethod() {
            driver = new SHAFT.GUI.WebDriver();
            driver.browser().navigateToURL(SHAFT.Properties.web.baseURL());
            driver.element().click(By.id("details-button"));
            driver.element().click(By.id("proceed-link"));

        }

//    @AfterMethod
//    public void afterMethod(){
//        driver.quit();
//    }
}
