package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginWithPageObjectsTests extends TestBase{

    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();


    @Test
    void fillLoginForm(){
        loginPage.openPage()
                .setUserName("Maks")
                .setPassword("123Qwerty!")
                .pressLoginButton();

        profilePage.checkUserName("Maks");
    }

    @Test
    void incorrectPassword(){
        loginPage.openPage()
                .setUserName("Maks")
                .setPassword("123")
                .pressLoginButton()

                .checkAlert("Invalid username or password!");
    }

}
