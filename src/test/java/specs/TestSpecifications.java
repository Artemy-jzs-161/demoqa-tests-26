package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.*;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static io.restassured.http.ContentType.JSON;

public class TestSpecifications {
    public static RequestSpecification requestSpecification = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().headers()
            .contentType(JSON);

    public static ResponseSpecification responseSpecification(int status) {
        return new ResponseSpecBuilder().
                expectStatusCode(status)
                .log(STATUS)
                .log(BODY)
                .build();
    }


}
