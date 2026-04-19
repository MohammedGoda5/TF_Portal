package testPackage;

import TFPages.LoginPage;
import org.testng.annotations.Test;

public class LCTests extends BaseTest {
    @Test
    public void ILCTest(){

        loginPage = new LoginPage(driver);
        homePage = loginPage.Login("enduser","P@ssw0rd");
        lcPage = homePage.NavigateToILC();
        lcPage.createLC();
        assertSuccessfulSendRequest();
        assertSuccessfulSendRequestToChecker("https://qc.tf.customerportal.web.nicedeer.local/Dashboard/Index");

    }
    @Test
    public void ELCTest(){

        loginPage = new LoginPage(driver);
        homePage = loginPage.Login("enduser","P@ssw0rd");
        lcPage = homePage.NavigateToELC();
        lcPage.createLC();
        assertSuccessfulSendRequest();
        assertSuccessfulSendRequestToChecker("https://qc.tf.customerportal.web.nicedeer.local/Dashboard/Index");

    }
}
