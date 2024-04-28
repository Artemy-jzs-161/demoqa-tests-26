package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxPage {

    private final SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputForm = $("#output"),
            textCenter = $(".text-center");

    @Step("Открыть страницу")
    public TestBoxPage openPage() {
        open("/text-box");
        textCenter.shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вввести ФИ пользователя {value}")
    public TestBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    @Step("Вввести email {value}")
    public TestBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Вввести текущий адрес {value}")
    public TestBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Вввести постоянный адрес {value}")
    public TestBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    @Step("Нажать на кнопку Submit")
    public TestBoxPage pressSubmit() {
        submitButton.click();
        return this;
    }

    @Step("Проверить, что введенные данные {value} отображаются в графе {key}")
    public TestBoxPage checkResult(String key, String value) {
        outputForm.should(appear);
        outputForm.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}

