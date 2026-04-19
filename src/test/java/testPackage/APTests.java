package testPackage;

import TFPages.LoginPage;
import org.testng.annotations.Test;

public class APTests extends BaseTest {
    @Test
    public void APTests() {
        loginPage=new LoginPage(driver);
        homePage=loginPage.Login("enduser","P@ssw0rd");
        apPage=homePage.NavigateToAP();
        apPage.createAP();
    }
}
