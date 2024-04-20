package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("registration")
public class PracticeFromTests extends TestBase {
    @Feature("Форма регистрации")
    @Story("Заполнение Practice Form")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы со всеми заполненными полями")
    @Test
    void fullSuccessfulRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .setUploadPicture(testData.picture)
                .setAddress(testData.currentAddress)
                .setStateAndCity(testData.state, testData.city)
                .pressSubmit();
        registrationPage
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Feature("Форма регистрации")
    @Story("Заполнение Practice Form")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы с обязательными к заполненению полями")
    @Test
    void minSuccessfulRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName("Sveta")
                .setLastName("Svetlakova")
                .setGender("Female")
                .setUserNumber("8888888888")
                .pressSubmit();
        registrationPage
                .checkResult("Student Name", "Sveta Svetlakova")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8888888888");

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
                .setLastName("Svetlakova")
                .setGender("Female")
                .setUserNumber("8888888888")
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
                .setFirstName("Sveta")
                .setGender("Female")
                .setUserNumber("8888888888")
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
                .setFirstName("Sveta")
                .setLastName("Svetlakova")
                .setUserNumber("8888888888")
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
                .setFirstName("Sveta")
                .setLastName("Svetlakova")
                .setGender("Female")
                .pressSubmit();
        registrationPage
                .checkFormIsNotDisplayed()
                .checkEmptyUserNumber();
    }
}