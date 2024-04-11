package assertions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResponseBodyValidation {
    @Test
    public void responseBody()
    {
        RequestSpecification reqSpec= RestAssured.given();
        reqSpec.baseUri("https://reqres.in/");
        reqSpec.basePath("/api/users?page=2");
        Response response=reqSpec.get();
        ResponseBody responseBody= response.getBody();
        String responseString= responseBody.asString();

//        System.out.println("Response Body :"+responseString);
//         just to check George is present in String or not
//        Assert.assertTrue(responseString.contains("George"),"Not Present");

//        check for particular firstname is george
        JsonPath jsonPathView = responseBody.jsonPath();
        String fName=jsonPathView.get("data[0].first_name");
        Assert.assertEquals(fName,"George","Not Matched");




    }
}
