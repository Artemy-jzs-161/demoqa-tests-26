package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TestBoxPage;

@Tag("registration")
public class TestBoxPageObjectTests extends TestBase {

    TestBoxPage testBoxPage = new TestBoxPage();

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
