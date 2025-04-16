package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sbu.cs.genius.account.User;
import sbu.cs.genius.content.Comment;
import sbu.cs.genius.content.Song;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class SongController {

    @FXML
    AnchorPane leftAnchorPane, centerAnchorPane;

    @FXML
    VBox vBox;

    @FXML
    Label songAlbumTitle, songReleaseDate, songGenre, songViews, songTitle, songArtist;

    @FXML
    TextArea commentTextArea;

    // stores the path of the previous scene
    private String prePage = "";
    // to give refresh button access to the current song
    private Song song;

    public void setScene(Song song, String path) {
        prePage = path;
        this.song = song;
        songTitle.setText(song.getTitle());
        if (song.getCoArtist() != null) {
            songArtist.setText(song.getArtist().toString() + ", " + song.getCoArtist().toString());
        }
        else {
            songArtist.setText(song.getArtist().toString());
        }
        songAlbumTitle.setText(song.getAlbumTitle());
        songReleaseDate.setText(song.getReleaseDate());
        songGenre.setText(song.getGenre());
        songViews.setText(String.valueOf(song.getViewsCount()));
        if (song.getTag() != null) {
            Text tags = new Text(song.getTag());
            tags.setLayoutX(125);
            tags.setLayoutY(320);
            leftAnchorPane.getChildren().add(tags);
        }
        Text lyric = new Text(song.getLyric());
        lyric.setLayoutX(30);
        lyric.setLayoutY(120);
        centerAnchorPane.getChildren().add(lyric);
        // load comments
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        for (Comment comment : song.getComments()) {
            vBox.getChildren().add(getCommentLayout(comment));
        }
        System.out.println("-> song scene is set");
    }

    public void back(ActionEvent event) throws IOException {
        // switch to the previous scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource(prePage));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        System.out.println("-> switch to the previous scene");
    }

    public void refresh(ActionEvent event) throws IOException {
        // remove currently displayed comments
        vBox.getChildren().remove(2, vBox.getChildren().size());
        // add all comments
        for (Comment comment : song.getComments()) {
            vBox.getChildren().add(getCommentLayout(comment));
        }
        System.out.println("-> refreshed comments");
    }

    public void editLyrics(ActionEvent event) throws IOException {
        TextArea lyricsTextArea = new TextArea(song.getLyric());
        lyricsTextArea.setLayoutX(68);
        lyricsTextArea.setLayoutY(125);
        lyricsTextArea.setPrefSize(410,300);
        centerAnchorPane.getChildren().removeLast();
        centerAnchorPane.getChildren().add(lyricsTextArea);
        Button submit = new Button("Submit");
        submit.setPrefHeight(29.5);
        submit.setLayoutX(465);
        submit.setLayoutY(440);
        submit.setOnAction(this::submit);
        centerAnchorPane.getChildren().add(submit);
    }

    public void submit(ActionEvent event) {
        // send request to artist and admin

        // remove TextArea and submit button
        int i = centerAnchorPane.getChildren().size();
        centerAnchorPane.getChildren().remove(i - 2, i);
        // add lyrics
        Text lyric = new Text(song.getLyric());
        lyric.setLayoutX(30);
        lyric.setLayoutY(120);
        centerAnchorPane.getChildren().add(lyric);
    }

    public void send(ActionEvent event) throws IOException {
        User.getUser().comment(this.song, commentTextArea.getText());
        commentTextArea.setText("");
    }

    // load comment layout and return a node
    Node getCommentLayout(Comment comment) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/comment-view.fxml"));
        try {
            Node node = loader.load();
            CommentController commentController = loader.getController();
            commentController.setComment(comment);
            return node;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
