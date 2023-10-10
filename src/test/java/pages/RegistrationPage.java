package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    String uri = "/automation-practice-form";

    CalendarComponent calendar = new CalendarComponent();


    SelenideElement titleLabel = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    genderWrapper = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    dateBirth = $("#dateOfBirthInput"),
                    subjectsInput =$("#subjectsInput"),
                    hobbies = $("#hobbiesWrapper"),
                    image = $("#uploadPicture"),
                    currentAddress = $("#currentAddress"),
                    state = $("#stateCity-wrapper"),
                    city = $("#stateCity-wrapper"),
                    submitButton = $("#submit"),
                    submitText = $("#example-modal-sizes-title-lg"),
                    infoUserBody = $(".table-responsive"),
                    bodyPage = $(".body-height");


    public RegistrationPage openPage(){
        open(uri);
        titleLabel.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#app footer').remove()");

        return this;
    }


    ///Actions
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setDateBirth(String day, String month, String year){
        dateBirth.click();
        calendar.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubjectsInput(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbies.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setImage(String value){
        image.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage setCurrentAddress(String value){
        currentAddress.setValue(value);

        return this;
    }
    public RegistrationPage setState(String value){
        $("#state").click();
        state.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setCity(String value){
        $("#city").click();
        city.$(byText(value)).click();

        return this;
    }
    public RegistrationPage Submit(){
        submitButton.click();

        return this;
    }
    public RegistrationPage successFormSubmissionText(String value){
        submitText.shouldHave(text(value));

        return this;
    }
    public RegistrationPage checkResult(String key, String value){
        infoUserBody.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
    public RegistrationPage NotHaveFilledForm(String value){
        bodyPage.shouldNotHave(text(value));

        return this;
    }

}
