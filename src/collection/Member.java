package collection;

import lombok.*;


@Data //  자동으로 기본 생성자 만들어줌
@AllArgsConstructor // 모든 변수가 들어가있는 생성자 만들때 사용

public class Member {

    private int id;
    private String name;
    private String email;
    private int age;

    // 필요하다면 직접 생성자 생성 가능


    public Member(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
