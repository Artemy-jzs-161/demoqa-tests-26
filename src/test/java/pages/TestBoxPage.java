package pages;

import com.codeborne.selenide.SelenideElement;

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

    public TestBoxPage openPage() {
        open("/text-box");
        textCenter.shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TestBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TestBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TestBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TestBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TestBoxPage pressSubmit() {
        submitButton.click();
        return this;
    }

    public TestBoxPage checkResult(String key, String value) {
        outputForm.should(appear);
        outputForm.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}

