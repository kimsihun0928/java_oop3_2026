package http.api;

import lombok.Data;

import java.util.List;

@Data
public class AirQuality {

    private Response response;

    @Data
    public static class Response {
        private Body body;
        private Header header;


        @Data
        public static class Body {
            private int totalCount;
            private List<Item> items;
            private int pageNo;
            private int numOfRows;

            @Data
            public static class Item {
                private String clearVal;
                private String sn;
            }
        }

        @Data
        public static class Header {
            private String resultMsg;
            private String resultCode;
        }
    }

}
