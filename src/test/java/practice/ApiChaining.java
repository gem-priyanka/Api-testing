package practice;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiChaining {
    int id;
    @Test(priority = 1)
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

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    void updateUser() {

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Priyanka");
        map.put("job", "sofware developer");

        given().contentType("application/json").body(map)
                .when().put("https://reqres.in/api/users/+id")
                .then().statusCode(200).log().all();
    }


}



