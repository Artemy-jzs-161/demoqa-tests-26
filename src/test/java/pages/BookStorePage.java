package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.USERNAME;

public class BookStorePage {
    private final SelenideElement
            userName = $("#userName-value"),
            booksList = $(".ReactTable");

    @Step("Открыть страницу профиля")
    public BookStorePage openProfilePage() {
        open("/profile");
        return this;
    }

    @Step("Проверить, что пользователь вошёл в систему")
    public BookStorePage checkUserLoggedIn() {
        userName.shouldHave(text(USERNAME));
        return this;
    }

    @Step("Проверить, что книга удалена")
    public void checkBookWasDeleted(String bookTitle) {
        booksList.shouldNotHave(text(bookTitle));
    }

}
