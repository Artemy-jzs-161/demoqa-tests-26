package tests;

import api.AuthorizationApi;
import api.BookApi;
import extensions.WithLogin;
import models.book.*;
import models.login.*;
import org.junit.jupiter.api.*;
import pages.BookStorePage;
import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static tests.TestData.TARGET_BOOK_TITLE;

@DisplayName("Проверка Book store application")
public class BookTest extends TestBase {
    AuthorizationApi authorizationApi = new AuthorizationApi();
    BookApi bookApi = new BookApi();
    BookStorePage bookStorePage = new BookStorePage();
    LoginRequestModel loginRequest = new LoginRequestModel(TestData.USERNAME, TestData.PASSWORD);
    LoginResponseModel loginResponse = authorizationApi.authorize(loginRequest);

    @Test
    @DisplayName("Авторизация по API")
    @WithLogin
    void loginWithApiTest() {
        step("Проверить ник в поле User Name", () ->
                bookStorePage
                        .openProfilePage()
                        .checkUserLoggedIn());
    }

    @Test
    @DisplayName("Удаление книги")
    @WithLogin
    void checkDeleteBook() {
        step("Удалить все книги", () ->
                bookApi.deleteAllBook(loginResponse));

        step("Добавить книгу", () -> {
            List<IsbnModel> isbnList = new ArrayList<>();
            IsbnModel isbn = new IsbnModel(TestData.TARGET_BOOK_ISBN);
            isbnList.add(isbn);
            bookApi.addBook(loginResponse, new AddBookRequestModel(loginResponse.getUserId(), isbnList));
        });

        step("Удалить книгу", () ->
                bookApi.deleteBook(loginResponse, new DeleteBookRequestModel(TestData.TARGET_BOOK_ISBN, loginResponse.getUserId())));

        step("Проверить что книги нет в таблице", () -> {
            bookStorePage
                    .openProfilePage()
                    .checkBookWasDeleted(TARGET_BOOK_TITLE);
        });
    }
}


