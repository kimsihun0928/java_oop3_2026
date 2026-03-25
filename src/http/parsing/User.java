package http.parsing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;


    static class Address {

        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", suite='" + suite + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode='" + zipcode + '\'' +
                    ", geo=" + geo +
                    '}';
        }

        static class Geo {
            private String lat;
            private String lng;

            @Override
            public String toString() {
                return "Geo{" +
                        "lat='" + lat + '\'' +
                        ", lng='" + lng + '\'' +
                        '}';
            }
        }
    }

    static class Company {
        private String name;
        private String catchPhrase;
        private String bs;

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", catchPhr ase='" + catchPhrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }
    }
}
