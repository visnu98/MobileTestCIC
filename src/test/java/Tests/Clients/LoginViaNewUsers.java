package Tests.Clients;

import Pages.Common.PinPage;
import Pages.Login.LandingPage;
import Pages.Login.LoginPage;
import Pages.Login.MainPage;
import helper.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ElementWaitHandler;
import utils.JsonReader;


public class LoginViaNewUsers extends BaseTest {


    @Test(groups = {"regression", "login"} )
    public void loginViaNewUsers() throws Exception {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = new LandingPage();
        mainPage.navigateToNewUsers();
        loginPage.performLogin("USER605","eLounge2019BP!");
        landingPage.validateLandingPage();
    }

    @Test(groups = {"regression"} )
    public void loginViaNewUsersWrongCredentials() throws InterruptedException {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.navigateToNewUsers();
        loginPage.performLogin("User555","asd!");
        Assert.assertEquals(ElementWaitHandler.waitUntilElementVisibleE(loginPage.alertBanner,10).getText(),"The entered access data are incorrect.");
    }

    @Test(groups = {"regression","envTST"} )
    public void loginViaNewUsersSavedCredentials() throws Exception {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        PinPage pinPage = new PinPage();
        LandingPage landingPage = new LandingPage();
        loginPage.navigateToMainPage();
        mainPage.savedCredentials.click();
        pinPage.enterPin(123456);
        landingPage.validateLandingPage();
    }



}
