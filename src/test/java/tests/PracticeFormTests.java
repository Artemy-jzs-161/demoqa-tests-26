package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {

    String firstName = "Ivan";
    String lastName = "Ivanov";
    String userEmail = "IvanIvanov@google.com";
    String userNumber = "9133333333";
    String genderMale = "Male";
    String year = "2000";
    String month = "January";
    String day = "1";
    String subject = "Chemistry";
    String hobbySport = "Sports";
    String hobbyReading = "Reading";
    String hobbyMusic = "Music";
    String picture = "img/kitty.jpg";
    String currentAddress = "Kartavya Path, India Gate, New Delhi, Delhi 110001";
    String state = "NCR";
    String city = "Delhi";

    @AfterAll
    static void afterAll() {
        Selenide.closeWindow();
    }

    @Test
    void studentRegistrationFormTest() {
        open("/automation-practice-form");
        //firstName
        $("#firstName").setValue(firstName);
        //lastName
        $("#lastName").setValue(lastName);
        //userEmail
        $("#userEmail").setValue(userEmail).click();

        //gender
        $("#genderWrapper").$(byText(genderMale)).click();

        //userNumber
        $("#userNumber").setValue(userNumber);

        //dateOfBirthInput
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month").$(byText(day)).click();

        //subjects
        $("#subjectsInput").setValue(subject).pressEnter();

        //hobbies
        $("#hobbiesWrapper").$(byText(hobbySport)).click();
        $("#hobbiesWrapper").$(byText(hobbyReading)).click();
        $("#hobbiesWrapper").$(byText(hobbyMusic)).click();

        //picture
        $("#uploadPicture").uploadFromClasspath(picture);

        //currentAddress
        $("#currentAddress").setValue(currentAddress);

        //stateAndCity
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        //button
        $("#submit").click();

        //assert
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(lastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genderMale));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbySport + ", " + hobbyReading + ", " + hobbyMusic));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(picture));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));

    }
}
