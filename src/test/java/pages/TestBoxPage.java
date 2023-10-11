package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBoxPage {

    String uri = "/text-box";

    SelenideElement
            titleLabel = $(".body-height"),
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("[placeholder='Current Address']"),
            permanentAddressInput = $("textarea#permanentAddress"),
            submitButton = $("#submit"),
            outputName = $("#output").$("#name"),
            outputEmail = $("#output").$("#email"),
            outputCurrentAddress = $("#output").$("#currentAddress"),
            outputPermanentAddress = $("#output").$("#permanentAddress"),
            bodyHeightPage = $(".body-height");

    public TestBoxPage openPage(){
        open(uri);
        titleLabel.shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#app footer').remove()");
        return this;
    }

    public TestBoxPage setUserName(String value){
        userNameInput.setValue(value);
        return this;
    }

    public TestBoxPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public TestBoxPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public TestBoxPage setPermanentAddress(String value){
        permanentAddressInput.setValue(value);
        return this;
    }

    public void pressSubmitButton(){
        submitButton.click();
    }

    public void checkTextBox(String name, String email, String curAddress, String perAddress){
        outputName.shouldHave(text(name));
        outputEmail.shouldHave(text(email));
        outputCurrentAddress.shouldHave(text(curAddress));
        outputPermanentAddress.shouldHave(text(perAddress));
    }

    public void checkMissingFields(String name, String email, String curAddress, String perAddress){
        bodyHeightPage.shouldNotHave(text(name));
        bodyHeightPage.shouldNotHave(text(email));
        bodyHeightPage.shouldNotHave(text(curAddress));
        bodyHeightPage.shouldNotHave(text(perAddress));
    }
}
