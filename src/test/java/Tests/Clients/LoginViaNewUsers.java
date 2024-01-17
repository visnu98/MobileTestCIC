package Tests.Clients;

import Pages.Common.PinPage;
import Pages.Login.LandingPage;
import Pages.Login.LoginPage;
import Pages.Login.MainPage;
import helper.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DeviceHandler;
import utils.ElementWaitHandler;
import utils.JsonReader;


public class LoginViaNewUsers extends BaseTest {


    @Test(groups = {"regression", "login"} )
    public void loginViaNewUsers() throws Exception {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = new LandingPage();
        mainPage.navigateToNewUsers();
        loginPage.performLogin(JsonReader.getUserName("financeUser"),JsonReader.getPassword("financeUser"));
        landingPage.validateLandingPage();
    }

    @Test(groups = {"regression"} )
    public void loginViaNewUsersWrongCredentials() throws InterruptedException {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.navigateToNewUsers();
        loginPage.performLogin(JsonReader.getUserName("wrongUser"),JsonReader.getPassword("wrongUser"));
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
        pinPage.enterPin(Integer.parseInt(JsonReader.getTestData("devicePin", DeviceHandler.getDeviceFilePath(DeviceHandler.getCurrentDevice()))));
        landingPage.validateLandingPage();
    }



}
