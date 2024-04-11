package httpRequests;

import org.json.JSONObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostHttpUrlConnection {
    public static void sendPost(String URL) {
        try {
            URL url = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setDoInput(true);
            con.setDoOutput(true);

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");

            JSONObject innerList = new JSONObject();
            innerList.put("company", "Gemini");
            innerList.put("location", "Gurgaon");

            JSONObject json = new JSONObject();
            json.put("name", "Priyanka");
            json.put("data", innerList);

            OutputStream output = con.getOutputStream();
            output.write(json.toString().getBytes());
            output.flush();
            output.close();

            BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
            }
            input.close();
            System.out.println("Response:" + response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void main(String[] args) {
        String reqres="https://reqres.in/api/users";
        String restfulApi="https://api.restful-api.dev/objects";
        sendPost(restfulApi);
    }
}