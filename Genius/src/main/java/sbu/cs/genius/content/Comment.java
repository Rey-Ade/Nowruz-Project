package sbu.cs.genius.content;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {

    private String date;
    private String text;
    private String username;

    public Comment (String username, String text){
        this.username = username;
        date = formatDateTime(LocalDateTime.now());
        this.text = text;
    }

    // format date and time and return a string
    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return dateTime.format(format);
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getUsername() {
        return username;
    }
}
