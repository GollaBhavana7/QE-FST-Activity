package demos;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity3 {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;

    @BeforeClass
    public void setup() {
        // Build RequestSpecification
        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();

        // Build ResponseSpecification
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @DataProvider(name = "petData")
    public Object[][] testData() {
        return new Object[][]{
                {77212, "Riley", "alive"},
                {77243, "Hansel", "alive"}
        };
    }

    @Test(priority = 1)
    public void addPets() {
        // Pet 1
        String pet1 = "{\"id\": 77212, \"name\": \"Riley\", \"status\": \"alive\"}";
        given().spec(reqSpec).body(pet1)
                .when().post()
                .then().spec(resSpec);

        // Pet 2
        String pet2 = "{\"id\": 77243, \"name\": \"Hansel\", \"status\": \"alive\"}";
        given().spec(reqSpec).body(pet2)
                .when().post()
                .then().spec(resSpec);
    }

    @Test(priority = 2, dataProvider = "petData")
    public void getPets(int id, String name, String status) {
        given().spec(reqSpec).pathParam("petId", id)
                .when().get("/{petId}")
                .then().spec(resSpec)
                .body("name", equalTo(name))
                .body("id", equalTo(id));
    }

    @Test(priority = 3, dataProvider = "petData")
    public void deletePets(int id, String name, String status) {
        given().spec(reqSpec).pathParam("petId", id)
                .when().delete("/{petId}")
                .then().statusCode(200);
    }
}