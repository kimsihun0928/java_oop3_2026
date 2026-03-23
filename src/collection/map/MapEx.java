package collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {

        // 학생 이름, 점수
        Map<String, Integer> scores = new HashMap<>();

        // 추가 (put)
        scores.put("철수",90);
        scores.put("민수", 75);
        scores.put("영희", 88);

        // 조회 (get)
        System.out.println(scores.get("철수")); // 90 --> key값을 조회하면 value 값을 얻음
        System.out.println(scores.get("없는값")); // null --> 없는 값 조회 시 null

        // 포함 여부
        System.out.println(scores.containsKey("영희"));
        System.out.println(scores.containsValue(87));

        // 삭제
        scores.remove("민수");

        // 크기
        scores.size();

        // put() 은 덮어씌우기도 함
        scores.put("철수", 0); // 덮어쓰기 됨

        // 인덱스 없음
        System.out.println(">>>" + scores.keySet());
        System.out.println(scores);
        for(String name : scores.keySet()) {
            System.out.println(name + " : " + scores.get(name) + "점");
        }


    } // end of main
} // end of class
