package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.TestBoxPage;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("registration"), @Tag("test_box")})
public class TestBoxTests extends TestBase {
    TestBoxPage testBoxPage = new TestBoxPage();

    @Feature("Форма регистрации")
    @Story("Заполнение формы Text Box")
    @Owner("Artemy-jzs-161")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отправка формы со всеми заполненными полями")
    @Test
    void fullSuccessfulRegistrationTest() {

        step("Открыть Test Box ", () -> {
            testBoxPage.openPage();
        });

        step("Заполнение формы ", () -> {
            testBoxPage
                    .setFullName(testData.firstName + " " + testData.lastName)
                    .setEmail(testData.userEmail)
                    .setCurrentAddress(testData.currentAddress)
                    .setPermanentAddress(testData.currentAddress);
        });

        step("Нашать кнопку Submit", () -> {
            testBoxPage.pressSubmit();
        });

        step("Проверка заполненных данных", () -> {
            testBoxPage
                    .checkResult("Name:", testData.firstName + " " + testData.lastName)
                    .checkResult("Email:", testData.userEmail)
                    .checkResult("Current Address :", testData.currentAddress)
                    .checkResult("Permananet Address :", testData.currentAddress);
        });
    }
}
