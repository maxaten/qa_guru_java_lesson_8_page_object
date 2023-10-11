package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginWithPageObjectsTests extends TestBase{
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    String userName = "Maks";
    String password = "123Qwerty!";
    String badPassword = "123";
    String alertText = "Invalid username or password!";

    @Test
    void fillLoginForm(){
        loginPage.openPage()
                .setUserName(userName)
                .setPassword(password)
                .pressLoginButton();

        profilePage.checkUserName(userName);
    }

    @Test
    void incorrectPassword(){
        loginPage.openPage()
                .setUserName(userName)
                .setPassword(badPassword)
                .pressLoginButton();

        loginPage.checkAlert(alertText);
    }
}
