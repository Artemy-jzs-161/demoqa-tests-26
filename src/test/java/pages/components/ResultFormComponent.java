package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ResultFormComponent {
    public void checkForm(String key, String value){
        $(".modal-dialog").should(appear);
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void formNotAppear(){
        $(".modal-dialog").shouldNot(appear);
    }
}
