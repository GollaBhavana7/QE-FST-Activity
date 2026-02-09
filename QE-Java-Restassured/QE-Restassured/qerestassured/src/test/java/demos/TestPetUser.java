package demos;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class TestPetUser {

    String baseUrl = "https://petstore.swagger.io/v2/user";

    @Test(priority = 0)
    public void createUser() {
        HashMap<String, Object> userData = new HashMap<>();
        userData.put("id", 12038715);
        userData.put("username", "abhinav");
        userData.put("firstName", "Abhinav");
        userData.put("lastName", "b");
        userData.put("email", "abhinav@xyz.com");
        userData.put("password", "hunter2");
        userData.put("phone", 123980334);

        Response response = given().contentType(ContentType.JSON)
        .body(userData).when().post(baseUrl);

        response.prettyPrint();

        response.then().statusCode(200);
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("12038715"));
    }

    @Test (priority = 1)
    public void getUser() {
        Response response = given().contentType(ContentType.JSON)
        .pathParam("username", "abhinav")
        .when().get(baseUrl + "/{username}");

        response.prettyPrint();

        response.then().statusCode(200);
    }

    @Test (priority = 2)
    public void deleteUser() {
        Response response = given().contentType(ContentType.JSON)
        .pathParam("username", "abhinav")
        .when().delete(baseUrl + "/{username}");

        response = given().contentType(ContentType.JSON)
        .pathParam("username", "abhinav")
        .when().get(baseUrl + "/{username}");

        response.then().statusCode(404);
    }

}