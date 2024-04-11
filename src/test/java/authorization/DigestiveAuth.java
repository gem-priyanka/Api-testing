package authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DigestiveAuth {
    @Test
    public void digestiveAuth()
    {
        RequestSpecification reqSpec= RestAssured.given();
        reqSpec.baseUri("https://httpbin.org/digest-auth/undefined/Priyanka/Sharma");
        Response response=reqSpec.auth().digest("Priyanka","Sharma").get();
        System.out.println(response.getStatusCode());
    }
}
