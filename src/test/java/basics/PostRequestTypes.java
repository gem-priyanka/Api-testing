package basics;/*using hashmap
   using org.json
   using pojo class
   using externall json document
   */


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import pojo.PojoPostrequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class PostRequestTypes {

    //using hashmap
    // @Test
    void postUsingMap() {


        HashMap<String, String> map = new HashMap<>();
        map.put("name", "anie");
        map.put("job", "teacher");
        map.put("city", "Indore");

        given()
                .contentType("application/json")
                .body(map)

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .log().all();

    }

    //post request body using org.json


    //using hashmap
    @Test
    void postUsingJsonLibrary() {

        JSONObject data = new JSONObject();

        data.put("name", "anil");
        data.put("job", "techassociate");
        data.put("city", "bhopal");

        String arr[] = {"english", "maths"};
        data.put("courses", arr);


        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .body("name", equalTo("anil"))
                .body("job", equalTo("techassociate"))
                .body("city", equalTo("bhopal"))
                .log().all();

    }

    //postrequest using pojo class
    @Test
    void postUsingPojoClass() {

        PojoPostrequest data = new PojoPostrequest();

        data.setName("piyush");
        data.setCity("Agar");
        data.setJob("FinanceAdvisor");


        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .body("name", equalTo("piyush"))
                .body("job", equalTo("FinanceAdvisor"))
                .body("city", equalTo("Agar"))
                .log().all();

    }

    //using external json file
    //@Test
    void postUsingExternalJson() throws FileNotFoundException {

        File f = new File("src/test/java/body.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .body("name", equalTo("Priyanka"))
                .body("job", equalTo("Softwaredev"))
                .body("city", equalTo("Gurugram"))
                .log().all();

    }
}
