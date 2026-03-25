package http.json;

public class NotJsonEx2 {

    public static void main(String[] args) {

        String json = "{\"userId\": 1, \"id\": 1, \"title\": \"quidem molestiae enim\"}";
        // json 형식의 문자열을 파싱해서 Album 객체로 변환해보자

        String step1 = json.replace("{", "").replace("}", "");

        String[] parts = step1.split(",");

        String userIdString = parts[0].split(":")[1];
        int userIdInt = Integer.parseInt(userIdString.trim());

        String idString = parts[1].split(":")[1];
        int idInt = Integer.parseInt(idString.trim());

        String title = parts[2].split(":")[1].trim();

        Album album = new Album(userIdInt, idInt, title);

        System.out.println(album.toString());
        System.out.println(album.test());


    } // end of main
} // end of class

