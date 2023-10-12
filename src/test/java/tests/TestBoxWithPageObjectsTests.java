package tests;

import org.junit.jupiter.api.Test;
import pages.TestBoxPage;

public class TestBoxWithPageObjectsTests extends TestBase{
    TestBoxPage testBoxPage = new TestBoxPage();

    String title = "Text Box";
    String userName = "Maks Maks";
    String email = "maks@gmail.com";
    String currentAddress = "New York, Wall Street 12";
    String permanentAddress = "New York, Wall Street 12";
    String badEmail = "maks@gmailcom";

    @Test
    void fillForm(){
        testBoxPage.openPage()
                .deleteFooterAndAdd()
                .setUserName(userName)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .pressButton();

        testBoxPage.checkTextBox(
                userName,
                email,
                currentAddress,
                permanentAddress
        );
    }

    @Test
    void incorrectEmail(){
        testBoxPage.openPage()
                .checkTitle(title)
                .deleteFooterAndAdd()
                .setUserName(userName)
                .setUserEmail(badEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .pressButton();

        testBoxPage.checkMissingFields(
                userName,
                badEmail,
                currentAddress,
                permanentAddress
        );
    }
}
