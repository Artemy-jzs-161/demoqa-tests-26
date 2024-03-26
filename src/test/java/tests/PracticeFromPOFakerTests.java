package tests;

import org.junit.jupiter.api.Test;

public class PracticeFromPOFakerTests extends TestBase {
    @Test
    void fullSuccessfulRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth("30", "January", "2000")
                .setSubject("Chemistry")
                .setHobbies("Music")
                .setUploadPicture("img/kitty.jpg")
                .setAddress("Kartavya Path, India Gate, New Delhi, Delhi 110001")
                .setStateAndCity("NCR", "Delhi")
                .pressSubmit();
        registrationPage
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999")
                .checkResult("Date of Birth", "30 January,2000")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "kitty.jpg")
                .checkResult("Address", "Kartavya Path, India Gate, New Delhi, Delhi 110001")
                .checkResult("State and City", "NCR Delhi");
    }
}
