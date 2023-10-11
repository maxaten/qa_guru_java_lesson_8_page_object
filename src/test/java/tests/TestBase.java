package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegistrationPage;
import pages.TestBoxPage;
import pages.components.ModalContentComponent;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    TestBoxPage testBoxPage = new TestBoxPage();
    ModalContentComponent modalContentComponent = new ModalContentComponent();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @AfterAll
    static void tearDown(){
        Selenide.closeWebDriver();
    }
}