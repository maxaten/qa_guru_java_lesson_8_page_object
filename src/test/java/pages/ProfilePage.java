package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {
    String uri = "/profile";

    SelenideElement userName = $("#userName-value");


    public ProfilePage checkUserName(String value){
        userName.shouldHave(text(value));
        return this;
    }
}
