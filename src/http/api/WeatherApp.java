package http.api;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {

    public static void main(String[] args) {
        String apiKey = "48f17fd9e73e60977fa6d8246d59eb27"; // 발급받은 API 키 입력
        String city = "Busan";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey + "&units=metric&lang=kr";

        try {
            // 1. URL 객체 생성 및 연결 설정
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000); // 연결 타임아웃 5초
            conn.setReadTimeout(5000);    // 읽기 타임아웃 5초

            // 2. 응답 코드 확인 (200 OK 인지 체크)
            int responseCode = conn.getResponseCode();
            StringBuilder response = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            if (responseCode == 200) {
                // 3. 입력 스트림을 통해 데이터 읽기

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                // 4. 결과 출력
                System.out.println("응답 성공!");
                System.out.println(response.toString());
            } else {
                System.out.println("호출 실패. 응답 코드: " + responseCode);
            }

            in.close();
            conn.disconnect();

            // 도전 문제 1 - 파싱 처리
            Gson gson = new Gson();
            WeatherAppDTO weatherAppDto = gson.fromJson(response.toString(), WeatherAppDTO.class);
            System.out.println("▶ 상태 : " + weatherAppDto.getWeather().get(0).getDescription());
            System.out.println("▶ 기온 : " + weatherAppDto.getMain().getTemp() + "℃");
            System.out.println("▶ 습도 : " + weatherAppDto.getMain().getHumidity() + "%");
            System.out.println("▶ 풍속 : " + weatherAppDto.getWind().getSpeed() + "m/s");

            double feelsTemp = weatherAppDto.getMain().getFeels_like();
            if (feelsTemp >= 25) {
                System.out.println("현재 체감 온도는 " + feelsTemp + "℃ 이며 오늘은 덥게 느껴집니다.");
            } else {
                System.out.println("현재 체감 온도는 " + feelsTemp + "℃ 이며 오늘은 쌀쌀하게 느껴집니다.");
            }


            // 출력 값
            // 상태 : 맑음
            // 기온 : 17.5'c
            // 습도 : 24%
            // 풍속 : 2.1m/s

            // 간단한 알림 로직
            // 만약 25도보다 크다면 오늘 덥다
            // 그 이하라면 날씨가 쌀쌀하다

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}