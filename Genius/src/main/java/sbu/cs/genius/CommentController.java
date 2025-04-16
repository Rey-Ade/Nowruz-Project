package sbu.cs.genius;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sbu.cs.genius.account.User;
import sbu.cs.genius.content.Comment;

public class CommentController {

    @FXML
    AnchorPane commentAnchorPane;

    @FXML
    Label username, date;

    public void setComment(Comment comment) {
        username.setText(comment.getUsername());
        date.setText(comment.getDate());
        Text text = new Text(comment.getText());
        text.setLayoutX(30);
        text.setLayoutY(60);
        commentAnchorPane.getChildren().add(text);
    }
}
