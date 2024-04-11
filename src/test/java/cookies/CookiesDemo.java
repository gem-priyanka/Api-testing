package cookies;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookiesDemo {
    @Test
    void getCookieInfo() {
        Response res = given()
                .when()
                .get("https://www.google.com/");


//getting single cookie value
        //String ans = res.getCookie("AEC");
        //System.out.println("the value for cookie is "+ans);

        Map<String, String> map = res.getCookies();
        System.out.println(map.keySet());


    }

}
