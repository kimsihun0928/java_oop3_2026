package http.parsing;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UserClient {

    public static void main(String[] args) {

        String urlString = "https://jsonplaceholder.typicode.com/users/1";
        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드 : " + responseCode);
            // --------------------------

            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuffer responseBody = new StringBuffer();
                String line;
                while ( (line = reader.readLine()) != null ) {
                    responseBody.append(line).append("\n");
                }

                System.out.println(responseBody);
                System.out.println("==========================");

                // DTO
                String jsonString = responseBody.toString();
                System.out.println(jsonString);
                Gson gson = new Gson();

                User user = gson.fromJson(jsonString, User.class);
                System.out.println(user);

            }




        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main

} // end of class
