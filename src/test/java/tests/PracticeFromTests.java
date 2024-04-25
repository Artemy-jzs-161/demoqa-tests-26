package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;


@Tags({@Tag("registration"), @Tag("practice_from")})
public class PracticeFromTests extends TestBase {
    @Feature("Форма регистрации")
    @Story("Заполнение Practice Form")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы со всеми заполненными полями")
    @Test
    void fullSuccessfulRegistrationTest() {


        step("Открыть Practice Form", () -> {
            registrationPage.openPage();
        });

        step("Заполнение регистрационных данных", () -> {
            registrationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.userEmail)
                    .setGender(testData.gender)
                    .setUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.day, testData.month, testData.year)
                    .setSubject(testData.subject)
                    .setHobbies(testData.hobby)
                    .setAddress(testData.currentAddress)
                    .setStateAndCity(testData.state, testData.city);

            if (Configuration.browser.equals("chrome")) {
                registrationPage.setUploadPicture(testData.picture);
            }
        });

        step("Нашать кнопку Submit", () -> {
            registrationPage.pressSubmit();
        });

        step("Проверка заполненных данных", () -> {
            registrationPage
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.userEmail)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobby)
                    .checkResult("Address", testData.currentAddress)
                    .checkResult("State and City", testData.state + " " + testData.city);


            if (Configuration.browser.equals("chrome")) {
                registrationPage.checkResult("Picture", testData.picture);
            }
        });
    }

    /*
    @Feature("Форма регистрации")
    @Story("Заполнение Practice Form")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы с обязательными к заполненению полями")
    @Test
    void minSuccessfulRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .pressSubmit();
        registrationPage
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);

    }

    @Feature("Форма регистрации")
    @Story("Заполнение Practice Form")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы с незаполненным именем")
    @Test
    void emptyFirstNameRegistrationTest() {
        registrationPage
                .openPage()
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .pressSubmit();
        registrationPage
                .checkFormIsNotDisplayed()
                .checkEmptyFirstName();

    }

    @Feature("Форма регистрации")
    @Story("Заполнение Practice Form")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы с незаполненной фамилией")
    @Test
    void emptyLastNameRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .pressSubmit();
        registrationPage
                .checkFormIsNotDisplayed()
                .checkEmptyLastName();
    }

    @Feature("Форма регистрации")
    @Story("Заполнение Practice Form")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы с незаполненным полом")
    @Test
    void emptyGenderRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserNumber(testData.userNumber)
                .pressSubmit();
        registrationPage
                .checkFormIsNotDisplayed()
                .checkEmptyGender();

    }

    @Feature("Форма регистрации")
    @Story("Заполнение Practice Form")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы с незаполненным телефоном")
    @Test
    void emptyUserNumberRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .pressSubmit();
        registrationPage
                .checkFormIsNotDisplayed()
                .checkEmptyUserNumber();
    }

     */
}
