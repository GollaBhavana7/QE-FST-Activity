package demos;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Activity1 {
    String baseURL = "https://petstore.swagger.io/v2";

    @Test
    public void addNewPet() {

        int petId = 756933;
        String reqBody = """
                {
                  "id": %d,
                  "name": "see-saw",
                  "status": "available"
                }
                """.formatted(petId); 
        Response responsePost =given().contentType(ContentType.JSON).body(reqBody)
                .when().post(baseURL + "/pet").then().statusCode(200)
                .extract().response();
        System.out.println("POST Response:");
        System.out.println(responsePost.asPrettyString()); 

        Response responseGet = given().contentType(ContentType.JSON).pathParam("petId", petId)
                .when().get(baseURL + "/pet/{petId}")
                .then().statusCode(200).extract().response();
        System.out.println("GET Response:");
        System.out.println(responseGet.asPrettyString());
 
        Response responseDelete =given().contentType(ContentType.JSON).pathParam("petId", petId)
                .when().delete(baseURL + "/pet/{petId}")
                .then().statusCode(200).extract().response();
        System.out.println("DELETE Response:");
        System.out.println(responseDelete.asPrettyString()); 
        given()
            .contentType(ContentType.JSON)
            .pathParam("petId", petId)
        .when()
            .get(baseURL + "/pet/{petId}")
        .then()
            .statusCode(404);
    }
}