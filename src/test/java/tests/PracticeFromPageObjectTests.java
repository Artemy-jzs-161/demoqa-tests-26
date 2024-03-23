package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFromPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullSuccessfulRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("IvanIvanov@google.com")
                .setGender("Male")
                .setUserNumber("9999999999")
                .setDateOfBirth("30", "January", "2000")
                .setSubject("Chemistry")
                .setHobbies("Music")
                .setUploadPicture("img/kitty.jpg")
                .setAddress("Kartavya Path, India Gate, New Delhi, Delhi 110001")
                .setStateAndCity("NCR", "Delhi")
                .pressSubmit();
        registrationPage
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "IvanIvanov@google.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999")
                .checkResult("Date of Birth", "30 January,2000")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "kitty.jpg")
                .checkResult("Address", "Kartavya Path, India Gate, New Delhi, Delhi 110001")
                .checkResult("State and City", "NCR Delhi");
    }

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

