package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ProfilePage {
    String uri = "/profile";

    SelenideElement titleLabel = $(".main-header"),
                    userName = $("#userName-value");

    public ProfilePage openPage(){
        open(uri);
        titleLabel.shouldHave(text("Login"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#app footer').remove()");
        return this;
    }

    public ProfilePage checkUserName(String value){
        userName.shouldHave(text(value));
        return this;
    }
}
