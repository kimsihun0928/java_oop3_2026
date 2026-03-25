package http.toJson;

import http.parsing.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ToJsonUser {

    public static void main(String[] args) {
        // User 객체를 생성해서 --> JSON 문자열로 변환




        User user = new User();
        user.setId(1);
        user.setName("길동");
        user.setUsername("king111");
        user.setEmail("bs@dfd.com");
        user.setAddress(user.getAddress());






    } // end of main
} // end of class

class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

}