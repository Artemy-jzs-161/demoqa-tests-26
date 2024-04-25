package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultFormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultFormComponent resultFormComponent = new ResultFormComponent();
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            practiceFormWrapper = $(".practice-form-wrapper");

    @Step("Открыть страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        practiceFormWrapper.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вввести имя пользователя {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Вввести фамилию пользователя {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Вввести email {value}")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбрать пол {value}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Ввести номер телефона {value}")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Установить дату рождения {day}.{month}.{year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбрать предмет {value}")
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать хобби {value}")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Загрузить изображение {value}")
    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Ввести адрес {value}")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Выбрать штат {state} и город {city}")
    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    @Step("Нажать на кнопку Submit")
    public RegistrationPage pressSubmit() {
        submitButton.click();
        return this;
    }

    @Step("Проверить, что введенные данные {value} отображаются в графе {key}")
    public RegistrationPage checkResult(String key, String value) {
        resultFormComponent.checkForm(key, value);
        return this;
    }

    @Step("Проверить, что форма не появляется")
    public RegistrationPage checkFormIsNotDisplayed() {
        resultFormComponent.formNotAppear();
        return this;
    }

    @Step("Проверить, что поле имени пустое")
    public RegistrationPage checkEmptyFirstName() {
        firstNameInput.shouldBe(empty);
        firstNameInput.shouldHave(cssValue("color", "rgb(220, 53, 69)"));
        firstNameInput.shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg" +
                " xmlns='http://www.w3.org/2000/svg'" +
                " width='12' height='12' fill='none' stroke='%23dc3545'" +
                " viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath" +
                " stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6'" +
                " cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
        return this;

    }

    @Step("Проверить, что фамилия не заполнена")
    public RegistrationPage checkEmptyLastName() {
        lastNameInput.shouldBe(empty);
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        lastNameInput.shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg" +
                " xmlns='http://www.w3.org/2000/svg'" +
                " width='12' height='12' fill='none' stroke='%23dc3545'" +
                " viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath" +
                " stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6'" +
                " cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
        return this;

    }

    @Step("Проверить, что телефон не заполнен")
    public RegistrationPage checkEmptyUserNumber() {
        userNumberInput.shouldBe(empty);
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        userNumberInput.shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg" +
                " xmlns='http://www.w3.org/2000/svg'" +
                " width='12' height='12' fill='none' stroke='%23dc3545'" +
                " viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath" +
                " stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6'" +
                " cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
        return this;

    }

    @Step("Проверить, что пол не заполнен")
    public RegistrationPage checkEmptyGender() {
        if (Configuration.browser.equals("firefox")) {
            genderWrapper.$(byText("Male")).shouldHave(cssValue("color", "rgb(220, 53, 69)"));
            genderWrapper.$(byText("Female")).shouldHave(cssValue("color", "rgb(220, 53, 69)"));
            genderWrapper.$(byText("Other")).shouldHave(cssValue("color", "rgb(220, 53, 69)"));

        } else {
            genderWrapper.$(byText("Male")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
            genderWrapper.$(byText("Female")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
            genderWrapper.$(byText("Other")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        }
        return this;
    }
}