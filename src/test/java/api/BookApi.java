package api;

import io.qameta.allure.Step;
import models.book.AddBookRequestModel;
import models.book.DeleteBookRequestModel;
import models.login.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static specs.TestSpecifications.requestSpecification;
import static specs.TestSpecifications.responseSpecification;

public class BookApi {

    @Step("Удалить все книги")
    public void deleteAllBook(LoginResponseModel loginResponse) {
        given(requestSpecification)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .queryParam("UserId", loginResponse.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(responseSpecification(204));
    }

    @Step("Удалить книгу")
    public void deleteBook(LoginResponseModel loginResponse, DeleteBookRequestModel deleteBookRequest) {
        given(requestSpecification)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(deleteBookRequest)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(responseSpecification(204));
    }

    @Step("Добавить книгу")
    public void addBook(LoginResponseModel loginResponse, AddBookRequestModel addBookRequest) {
        given(requestSpecification)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(addBookRequest)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(responseSpecification(201));
    }
}
