package testPackage;

import TFPages.LoginPage;
import org.testng.annotations.Test;

public class DCTests extends BaseTest{

    @Test
    public void createInwardDC(){
        loginPage = new LoginPage(driver);
        homePage = loginPage.Login("enduser","P@ssw0rd");
        dcPage = homePage.NavigateToIBC();
        dcPage.createIDC();
        assertSuccessfulSendRequest();
        assertSuccessfulSendRequestToChecker("https://qc.tf.customerportal.web.nicedeer.local/Dashboard/Index");
    }
    @Test
    public void createOutwardDC(){
        loginPage = new LoginPage(driver);
        homePage = loginPage.Login("enduser","P@ssw0rd");
        dcPage = homePage.NavigateToOBC();
        dcPage.createODC();
        assertSuccessfulSendRequest();
        assertSuccessfulSendRequestToChecker("https://qc.tf.customerportal.web.nicedeer.local/Dashboard/Index");
    }
}
