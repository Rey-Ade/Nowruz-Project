package sbu.cs.genius;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sbu.cs.genius.account.User;
import sbu.cs.genius.content.Song;

public class CommentController {

    public static Song currentSong;

    @FXML
    public Label commentTextArea;

    public void send() {
        User.getUser().comment(currentSong, commentTextArea.getText());
    }

}
