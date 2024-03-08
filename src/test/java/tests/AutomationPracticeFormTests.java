package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void StudentRegistrationFormTest() {
        open("/automation-practice-form");
        //firstName
        $("#firstName").setValue("Artem");
        //lastName
        $("#lastName").setValue("Borovik");
        //userEmail
        $("#userEmail").setValue("art@ebor.com");

        //gender

        //userNumber
        $("#userNumber").setValue("+79139139113");

        //dateOfBirthInput
        //subjects
        //hobbies
        //picture
        //currentAddress
        //stateAndCity

        //buttom
        $("#submit").click();


        $("#userEmail").setValue("art@ebor.com");
        $("#currentAddress").setValue("lenina1");
        $("#permanentAddress").setValue("kirova2");

        $("#output #name").shouldHave(text("Artem"));
        $("#output #email").shouldHave(text("art@ebor.com"));
        $("#output #currentAddress").shouldHave(text("lenina1"));
        $("#output #permanentAddress").shouldHave(text("kirova2"));
    }

}
