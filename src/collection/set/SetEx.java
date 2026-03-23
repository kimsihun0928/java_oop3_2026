package collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetEx {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        // 추가
        set.add("철수");
        set.add("영희");
        set.add("철수"); // 증복! 무시됨

        System.out.println(set);
        System.out.println(set.size());

        System.out.println(set.contains("철수")); // true
        System.out.println(set.contains("민준")); // false

        set.remove("철수");

        // 전체 순회
        for (String name : set) {
            System.out.println(name);
        }

    }
}
