package testPackage;

import TFPages.LoginPage;
import org.testng.annotations.Test;

public class LGTests extends BaseTest{
    @Test
    public void ILGTest(){
        loginPage = new LoginPage(driver);
        homePage = loginPage.Login("enduser","P@ssw0rd");
        lgPage=homePage.NavigateToILG();
        lgPage.createLG();
        assertSuccessfulSendRequest();
        assertSuccessfulSendRequestToChecker("https://qc.tf.customerportal.web.nicedeer.local/Dashboard/Index");
    }
    @Test
    public void ELGTest(){
        loginPage = new LoginPage(driver);
        homePage = loginPage.Login("enduser","P@ssw0rd");
        lgPage=homePage.NavigateToELG();
        lgPage.createLG();
        assertSuccessfulSendRequest();
        assertSuccessfulSendRequestToChecker("https://qc.tf.customerportal.web.nicedeer.local/Dashboard/Index");
    }
}
