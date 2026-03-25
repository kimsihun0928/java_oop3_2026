package http.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

class Album {
    private int userId;
    private int id;
    private String title;

    @Override
    public String toString() {
        return "{\"userId\": " + userId +
                ", \"id\": " + id +
                ", \"title\": " + title + "}";
    }

    public String test() {
        return "{\"userId\": 1, \"id\": 1, \"title\": \"quidem molestiae enim\"}";
    }
}