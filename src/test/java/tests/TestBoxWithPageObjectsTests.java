package tests;

import org.junit.jupiter.api.Test;

public class TestBoxWithPageObjectsTests extends TestBase{
    String userName = "Maks Maks";
    String email = "maks@gmail.com";
    String currentAddress = "New York, Wall Street 12";
    String permanentAddress = "New York, Wall Street 12";
    String badEmail = "maks@gmailcom";

    @Test
    void fillForm(){
        testBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .pressSubmitButton();

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
                .setUserName(userName)
                .setUserEmail(badEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .pressSubmitButton();

        testBoxPage.checkMissingFields(
                userName,
                badEmail,
                currentAddress,
                permanentAddress
        );
    }
}
