package Tests.Clients;

import Pages.Login.LandingPage;
import Pages.Login.LoginPage;
import Pages.Login.MainPage;
import helper.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ElementWaitHandler;


public class LoginViaNewUsers extends BaseTest {


    @Test(groups = {"regression", "login"} )
    public void loginViaNewUsers(){
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

    @Test(groups = {"regression"} )
    public void loginViaNewUsersSaveCredentials(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.navigateToNewUsers();
        loginPage.performLogin("USER605","eLounge2019BP!");
    }



}
