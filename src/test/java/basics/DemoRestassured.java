package basics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DemoRestassured {


    int id;

    @Test(priority = 1)
    void getrequest() {
        given()

                .when().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200).body("page", equalTo(2))
                .log().all();
    }

    @Test(priority = 2)
    void createUser() {

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Priyanka");
        map.put("job", "SDET");
        id = given()
                .contentType("application/json").body(map)
                .when().post("https://reqres.in/api/users")
                .jsonPath().getInt("id");


        // .then()
        //.statusCode(201)
        //.log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUser() {

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Priyanka");
        map.put("job", "sofware developer");

        given().contentType("application/json").body(map)
                .when().put("https://reqres.in/api/users/+id")
                .then().statusCode(200).log().all();
    }

    @Test(priority = 4)
    void deleteUser() {
        given()

                .when().delete("https://reqres.in/api/users/+id")
                .then().statusCode(204).log().all();

    }
}

