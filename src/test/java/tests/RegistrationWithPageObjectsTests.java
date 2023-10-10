package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillForm() {
        registrationPage.openPage()
                        .setFirstName("Bruce")
                        .setLastName("Wayne")
                        .setUserEmail("wayneinterprise@waine.com")
                        .setGender("Male")
                        .setUserNumber("7999999999")
                        .setDateBirth("10", "11", "1990")
                        .setSubjectsInput("Physics")
                        .setSubjectsInput("Computer Science")
                        .setHobbies("Sports")
                        .setHobbies("Reading")
                        .setHobbies("Music")
                        .setImage("img/bruce.jpeg")
                        .setCurrentAddress("1007 Mountain Drive, Gotham")
                        .setState("Haryana")
                        .setCity("Karnal")
                        .Submit()


                        .successFormSubmissionText("Thanks for submitting the form")
                        .checkResult("Student Name", "Bruce Wayne")
                        .checkResult("Student Email", "wayneinterprise@waine.com")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "7999999999")
                        .checkResult("Date of Birth", "10 December,1990")
                        .checkResult("Hobbies", "Sports, Reading, Music")
                        .checkResult("Picture", "bruce.jpeg")
                        .checkResult("Address", "1007 Mountain Drive, Gotham")
                        .checkResult("State and City", "Haryana Karnal");
    }
    @Test
    void fillingRequiredFields(){
        registrationPage.openPage()
                        .setFirstName("Bruce")
                        .setLastName("Wayne")
                        .setGender("Male")
                        .setUserNumber("7999999999")
                        .setDateBirth("10", "11", "1990")
                        .Submit()

                        .successFormSubmissionText("Thanks for submitting the form")
                        .checkResult("Student Name", "Bruce Wayne")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "7999999999")
                        .checkResult("Date of Birth", "10 December,1990");
    }
    @Test
    void blankFieldsForm(){
        registrationPage.openPage()
                        .Submit()

                        .NotHaveFilledForm("Thanks for submitting the form");
    }
}
