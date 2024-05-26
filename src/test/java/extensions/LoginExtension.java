package extensions;

import api.AuthorizationApi;
import io.qameta.allure.Step;
import models.login.*;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.Cookie;
import tests.TestData;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginExtension implements BeforeEachCallback {
    @Override
    @Step("Войдите в систему и установите файлы cookie")
    public void beforeEach(ExtensionContext context) {
        AuthorizationApi userApi = new AuthorizationApi();
        LoginRequestModel loginRequest = new LoginRequestModel(TestData.USERNAME, TestData.PASSWORD);
        LoginResponseModel loginResponse = userApi.authorize(loginRequest);

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
    }
}

