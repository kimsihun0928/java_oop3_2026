package http.gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// https://jsonplaceholder.typicode.com/posts/1
public class PostClient {

    public static void main(String[] args) {
        // url 을 문자열로 저장
        String urlString = "https://jsonplaceholder.typicode.com/posts/16";
        HttpURLConnection connection =null; // 그냥 선언만 하면 try 문에서 connection에 값 들어가기전 만약 에러가 난다면 connection은 null 도 아니고 값이 들어있지도 않아서 finally 의 != null 을 비교할수없음. --> 컴파일 에러

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            int responseCode = connection.getResponseCode();
            System.out.println("응답코드 확인 : " + responseCode);

            if (responseCode != 200) {
                System.out.println("응답 실패");
                return;
            }
            // --------------연결 완료 ----------------- 이제 GET 했으니 읽어와야함
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }

                System.out.println(sb.toString());

                System.out.println("=====================");
                Gson gson = new Gson();
                String jsonString = sb.toString();
                Post post = gson.fromJson(jsonString, Post.class);
                System.out.println(post.getId());
                System.out.println(post.getUserId());
                System.out.println(post.getTitle());
                System.out.println(post.getBody());
            }

        } catch (Exception e) {
            System.out.println("통신 실패 :" + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }


    } // end of main
} // end of class
