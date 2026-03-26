package http.api;

import lombok.Data;
import lombok.experimental.PackagePrivate;

import java.util.List;

public class WeatherDTO {

    private Response response;

    public static class Response {

        private Header header;
        private Body body;

        @Data
        public static class Header {
            private String resultCode;
            private String resultMsG;
        }

        public static class Body {
            private String dataType;

            public static class Items {
                private List<Item> item;
                private Items items;


                public static class Item {
                    private String baseData; //  발표 일자 (YYYYMMDD)
                    private String baseTime; // 발표 시각
                    private String category;
                    private String obsrValue;
                    private int x;
                    private int y;

                }
            }

        }
    }
}
