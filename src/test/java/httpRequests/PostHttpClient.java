package httpRequests;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PostHttpClient {
             public static String sendPost(String url){

                 CloseableHttpClient httpClient = HttpClients.createDefault();
                 String result ="";
                 try
                 {
                     HttpPost post = new HttpPost(url);
                     post.addHeader("Content-Type" , "application/json");

                     JSONObject innerList = new JSONObject();
                     innerList.put("Name" , "Priyanka");
                     innerList.put("Profile", "Software developer");
                     innerList.put("Location" , "Gurgaon");
                     innerList.put("Experience" , "one-year");

                     post.setEntity(new StringEntity(innerList.toString()));

                     CloseableHttpResponse response = httpClient.execute(post);

                  result = EntityUtils.toString(response.getEntity());




                 } catch (UnsupportedEncodingException e) {
                     throw new RuntimeException(e);
                 } catch (ClientProtocolException e) {
                     throw new RuntimeException(e);
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }

                 return result;
             }

    public static void main(String[] args) {
        String restUrl ="https://api.restful-api.dev/objects";
        System.out.println(sendPost(restUrl));
    }


}
