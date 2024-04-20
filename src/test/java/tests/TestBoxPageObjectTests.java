package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TestBoxPage;

@Tag("registration")
public class TestBoxPageObjectTests extends TestBase {

    TestBoxPage testBoxPage = new TestBoxPage();

    @Feature("Форма регистрации")
    @Story("Заполнение формы Text Box")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы со всеми заполненными полями")
    @Tag("registration")
    @Test
    void fullSuccessfulRegistrationTest() {
        testBoxPage
                .openPage()
                .setFullName("Ivan Ivanov")
                .setEmail("IvanIvanov@google.com")
                .setCurrentAddress("lenina 1")
                .setPermanentAddress("kirova 2")
                .pressSubmit();
        testBoxPage
                .checkResult("Name:", "Ivan Ivanov")
                .checkResult("Email:", "IvanIvanov@google.com")
                .checkResult("Current Address :", "lenina 1")
                .checkResult("Permananet Address :", "kirova 2");
    }
}
