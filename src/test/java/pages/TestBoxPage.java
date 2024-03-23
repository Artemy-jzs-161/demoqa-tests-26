package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBoxPage {

    private SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputForm = $("#output");

    public TestBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
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

