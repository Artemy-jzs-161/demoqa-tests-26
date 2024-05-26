package api;

import io.qameta.allure.Step;
import models.login.*;
import static io.restassured.RestAssured.given;
import static specs.TestSpecifications.*;

public class AuthorizationApi {
    @Step("Авторизация пользователя")
    public LoginResponseModel authorize (LoginRequestModel loginRequestModel) {
       return given()
                .spec(requestSpecification)
                .body(loginRequestModel)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(responseSpecification(200))
                .extract().response().as(LoginResponseModel.class);
    }
}
