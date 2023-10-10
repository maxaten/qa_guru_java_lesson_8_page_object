package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterAll
    static void tearDown(){
        Selenide.closeWebDriver();
    }

}