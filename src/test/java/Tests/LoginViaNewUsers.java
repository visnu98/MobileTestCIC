package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import helper.BaseTest;
import org.testng.annotations.Test;


public class LoginViaNewUsers extends BaseTest {




    @Test
    public void loginViaNewUsers(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.navigateToNewUsers();
        loginPage.peformLogin("USER605","eLounge2019BP!");
    }

    @Test
    public void loginViaNewUsersWrongCredentials(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.navigateToNewUsers();
        loginPage.peformLogin("USER605","eLounge2019BP!");
    }

    @Test
    public void loginViaNewUsersSaveCredentials(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.navigateToNewUsers();
        loginPage.peformLogin("USER605","eLounge2019BP!");
    }



}
