package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import io.qameta.allure.Step;


public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();




    @BeforeAll
    @Step("Открыть страницу https://demoqa.com в разрешении 1920x1080")
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
