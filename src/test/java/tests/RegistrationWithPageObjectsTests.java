package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {
    String firstName = "Bruce";
    String lastName = "Wayne";
    String email = "wayneinterprise@waine.com";
    String gender = "Male";
    String phoneNumber = "7999999999";
    String[] birthDay = {"10", "November", "1990"};
    String subject1 = "Physics";
    String subject2 = "Computer Science";
    String hobby1 = "Sports";
    String hobby2 = "Reading";
    String hobby3 = "Music";
    String nameImage = "bruce.jpeg";
    String pathImage = "img/" + nameImage;
    String currentAddress = "1007 Mountain Drive, Gotham";
    String state = "Haryana";
    String city = "Karnal";
    String successSubmissionText = "Thanks for submitting the form";

    @Test
    void fillForm() {
        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(email)
                        .setGender(gender)
                        .setUserNumber(phoneNumber)
                        .setDateBirth(birthDay[0], birthDay[1], birthDay[2])
                        .setSubjectsInput(subject1)
                        .setSubjectsInput(subject2)
                        .setHobbies(hobby1)
                        .setHobbies(hobby2)
                        .setHobbies(hobby3)
                        .setImage(pathImage)
                        .setCurrentAddress(currentAddress)
                        .setState(state)
                        .setCity(city)
                        .Submit();

        modalContentComponent.checkVisible()
                        .successFormSubmissionText(successSubmissionText)
                        .checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Student Email", email)
                        .checkResult("Gender", gender)
                        .checkResult("Mobile", phoneNumber)
                        .checkResult("Date of Birth", birthDay[0] + " " + birthDay[1] + "," + birthDay[2])
                        .checkResult("Hobbies", hobby1 + ", " + hobby2 + ", " + hobby3)
                        .checkResult("Picture", nameImage)
                        .checkResult("Address", currentAddress)
                        .checkResult("State and City", state + " " + city);
    }

    @Test
    void fillingRequiredFields(){
        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setGender(gender)
                        .setUserNumber(phoneNumber)
                        .setDateBirth(birthDay[0], birthDay[1], birthDay[2])
                        .Submit();

        modalContentComponent.checkVisible()
                        .successFormSubmissionText(successSubmissionText)
                        .checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Gender", gender)
                        .checkResult("Mobile", phoneNumber)
                        .checkResult("Date of Birth", birthDay[0] + " " + birthDay[1] + "," + birthDay[2]);
    }

    @Test
    void blankFieldsForm(){
        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .Submit();

        modalContentComponent.checkNotBeVisible()
                .NotHaveFilledForm(successSubmissionText);
    }
}
