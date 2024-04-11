package authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BasicAuth {
    @Test
    public  void basicAuth()
    {
        RequestSpecification reqSpec= RestAssured.given();
        reqSpec.baseUri("http://postman-echo.com");
        reqSpec.basePath("/basic-auth");
//        Response response= reqSpec.auth().basic("postman","password").get();// non preemptive
        Response response= reqSpec.auth().preemptive().basic("postman","password").get();// non preemptive

        response.prettyPrint();
        System.out.println(response.statusLine());

    }
}
