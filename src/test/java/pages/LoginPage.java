package pages;

import com.codeborne.selenide.SelenideElement;
import utils.FooterAndAdd;
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
        titleLabel.shouldHave(text("Login"));
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

    public LoginPage pressLoginButton(){
        loginButton.click();
        return this;
    }

    public LoginPage checkAlert(String value){
        alertTextOfIncorrectPassOrUserName.shouldHave(text(value));
        return this;
    }
}
