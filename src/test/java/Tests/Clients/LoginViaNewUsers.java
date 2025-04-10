package Tests.Clients;

import Driver.AppDriver;
import Pages.Common.PinPage;
import Pages.Login.LandingPage;
import Pages.Login.LoginPage;
import Pages.Login.MainPage;
import Pages.Navigation.MenuStackPage;
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

    @Test(groups = {"regression", "login"} )
    public void loginViaNewUsersWrongCredentials() throws InterruptedException {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.navigateToNewUsers();
        loginPage.performLogin(JsonReader.getUserName("wrongUser"),JsonReader.getPassword("wrongUser"));
        Assert.assertEquals(ElementWaitHandler.waitUntilElementVisibleE(loginPage.alertBanner,10).getText(),"The entered access data are incorrect.");
    }

    @Test(groups = {"regression", "login", "envTST"} )
    public void
    loginViaNewUsersSavedCredentials() throws Exception {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        PinPage pinPage = new PinPage();
        LandingPage landingPage = new LandingPage();
        loginPage.navigateToMainPage();
        mainPage.savedCredentials.click();
        pinPage.enterPin(Integer.parseInt(DeviceHandler.getCurrentDeviceDetail("devicePin")));
        landingPage.validateLandingPage();
    }


    @Test(groups = {"regression", "login","new"})
    public void loginViaNewUsersSaveCredentials() throws Exception {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = new LandingPage();
        PinPage pinPage = new PinPage();
        MenuStackPage menuStackPage = new MenuStackPage();
        mainPage.navigateToNewUsers();
        loginPage.performLoginAndSaveCredentials(JsonReader.getUserName("financeUser"),JsonReader.getPassword("financeUser"));
        pinPage.enterPin(Integer.parseInt(DeviceHandler.getCurrentDeviceDetail("devicePin")));
        while (!menuStackPage.logoutBtn.isDisplayed()){
            landingPage.menuStack.click();
        }
        menuStackPage.performLogOut();

    }


}
