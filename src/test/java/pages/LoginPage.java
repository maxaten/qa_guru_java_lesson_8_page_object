package pages;

import com.codeborne.selenide.SelenideElement;
import utils.cutom.FooterAndAdd;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    String uri = "/login";
    FooterAndAdd footerAndAdd = new FooterAndAdd();

    SelenideElement titleLabel = $(".login-wrapper"),
            userNameInput = $("#userName"),
            passwordInput = $("#password"),
            loginButton = $("#login"),
            alertTextOfIncorrectPassOrUserName = $("#name");

    public LoginPage openPage(){
        open(uri);
        return this;
    }

    public LoginPage checkTitle(String value){
        titleLabel.shouldHave(text(value));
        return this;
    }

    public LoginPage deleteFooterAndAdd(){
        footerAndAdd.deleteFooterAndAdd();
        return this;
    }

    public LoginPage setUserName(String value){
        userNameInput.setValue(value);
        return this;
    }

    public LoginPage setPassword(String value){
        passwordInput.setValue(value);
        return this;
    }

    public void pressLoginButton(){
        loginButton.click();
    }

    public void checkAlert(String value){
        alertTextOfIncorrectPassOrUserName.shouldHave(text(value));
    }
}
