package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.content.Album;
import sbu.cs.genius.content.Comment;
import sbu.cs.genius.content.Song;
import java.io.IOException;

public class ContentController {

    @FXML
    AnchorPane rightAnchorPane, centerAnchorPane;

    @FXML
    VBox centerVBox;

    @FXML
    Label heading, subheading, title;

    @FXML
    ListView<String> listView;

    // this attribute is only for refresh method to access the displayed song
    private Song currentSong;

    public void setScene(Object object) {
        if (object instanceof Artist) {
            title.setText("Records");
            heading.setText(((Artist) object).getName());
            subheading.setText(((Artist) object).getUsername());
            Label age = new Label("Age");
            age.setLayoutX(20);
            age.setLayoutY(140);
            rightAnchorPane.getChildren().add(age);
            Label artistAge = new Label(String.valueOf(((Artist) object).getAge()));
            artistAge.setLayoutX(110);
            artistAge.setLayoutY(140);
            rightAnchorPane.getChildren().add(artistAge);
            Label email = new Label("Email");
            email.setLayoutX(20);
            email.setLayoutY(185);
            rightAnchorPane.getChildren().add(email);
            Label artistEmail = new Label(((Artist) object).getEmail());
            artistEmail.setLayoutX(110);
            artistEmail.setLayoutY(185);
            rightAnchorPane.getChildren().add(artistEmail);
            Label info = new Label("Info");
            info.setLayoutX(20);
            info.setLayoutY(230);
            rightAnchorPane.getChildren().add(info);
            Text artistInfo = new Text(((Artist) object).getInfo());
            artistInfo.setLayoutX(20);
            artistInfo.setLayoutY(265);
            rightAnchorPane.getChildren().add(artistInfo);
            for (Album album : ((Artist) object).getAlbumsByArtist()) {
                listView.getItems().add(album.toString());
            }
            listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    int index = listView.getSelectionModel().getSelectedIndex();
                    System.out.println("-> selected " + listView.getSelectionModel().getSelectedItem());
                    setAlbumScene(((Artist) object).getAlbumsByArtist().get(index));
                }
            });
        }
        else if (object instanceof Album) {
            setAlbumScene(object);
        }
        else {
            setSongScene(object);
        }
    }

    public void back(ActionEvent event) throws IOException {
        // switch to browse scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/browse-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        System.out.println("-> switch to browse scene");
    }

    private void setAlbumScene(Object object) {
        rightAnchorPane.getChildren().remove(2, 8);
        listView.getItems().clear();
        title.setText("Track List");
        heading.setText(((Album) object).getTitle());
        subheading.setText(((Album) object).getArtist().toString());
        Label releaseDate = new Label("Release Date");
        releaseDate.setLayoutX(20);
        releaseDate.setLayoutY(140);
        rightAnchorPane.getChildren().add(releaseDate);
        Label albumReleaseDate = new Label(((Album) object).getReleaseDate());
        albumReleaseDate.setLayoutX(140);
        albumReleaseDate.setLayoutY(140);
        rightAnchorPane.getChildren().add(albumReleaseDate);
        for (Song song : ((Album) object).getTracklist()) {
            listView.getItems().add(song.toString());
        }
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int index = listView.getSelectionModel().getSelectedIndex();
                System.out.println("-> selected " + listView.getSelectionModel().getSelectedItem());
                setSongScene(((Album) object).getTracklist().get(index));
            }
        });
    }

    public void setSongScene(Object object) {
        currentSong = (Song) object;
        rightAnchorPane.getChildren().remove(2, 4);
        title.setText("Lyrics");
        heading.setText(((Song) object).getTitle());
        subheading.setText(((Song) object).getArtist().toString());
        int y = 140;
        if (((Song) object).getCoArtist() != null) {
            Label coArtist = new Label("Co-Artist");
            coArtist.setLayoutX(20);
            coArtist.setLayoutY(y);
            rightAnchorPane.getChildren().add(coArtist);
            Label songCoArtist = new Label(((Song) object).getCoArtist().toString());
            songCoArtist.setLayoutX(110);
            songCoArtist.setLayoutY(y);
            rightAnchorPane.getChildren().add(songCoArtist);
            y += 45;
        }
        Label albumTitle = new Label("Album Title");
        albumTitle.setLayoutX(20);
        albumTitle.setLayoutY(y);
        rightAnchorPane.getChildren().add(albumTitle);
        Label songAlbumTitle = new Label(((Song) object).getAlbumTitle());
        songAlbumTitle.setLayoutX(110);
        songAlbumTitle.setLayoutY(y);
        rightAnchorPane.getChildren().add(songAlbumTitle);
        y += 45;
        Label releaseDate = new Label("Release Date");
        releaseDate.setLayoutX(20);
        releaseDate.setLayoutY(y);
        rightAnchorPane.getChildren().add(releaseDate);
        Label songReleaseDate = new Label(((Song) object).getReleaseDate());
        songReleaseDate.setLayoutX(110);
        songReleaseDate.setLayoutY(y);
        rightAnchorPane.getChildren().add(songReleaseDate);
        y += 45;
        Label genre = new Label("Genre");
        genre.setLayoutX(20);
        genre.setLayoutY(y);
        rightAnchorPane.getChildren().add(genre);
        Label songGenre = new Label(((Song) object).getGenre());
        songGenre.setLayoutX(110);
        songGenre.setLayoutY(y);
        rightAnchorPane.getChildren().add(songGenre);
        y += 45;
        // tags
        Label views = new Label("Views");
        views.setLayoutX(20);
        views.setLayoutY(y);
        rightAnchorPane.getChildren().add(views);
        Label songViews = new Label(String.valueOf(((Song) object).getViewsCount()));
        songViews.setLayoutX(110);
        songViews.setLayoutY(y);
        rightAnchorPane.getChildren().add(songViews);
        Text lyric = new Text(((Song) object).getLyric());
        lyric.setLayoutX(30);
        lyric.setLayoutY(115);
        centerAnchorPane.getChildren().remove(listView);
        centerAnchorPane.getChildren().add(lyric);
        Button refresh = new Button("Refresh");
        refresh.setPrefWidth(65);
        refresh.setPrefHeight(30);
        refresh.setLayoutX(395);
        refresh.setLayoutY(18);
        refresh.setOnAction(this::refresh);
        centerAnchorPane.getChildren().add(refresh);
        Button editLyrics = new Button("Edit Lyrics");
        editLyrics.setPrefWidth(85);
        editLyrics.setPrefHeight(30);
        editLyrics.setLayoutX(17);
        editLyrics.setLayoutY(18);
        editLyrics.setOnAction(this::editLyrics);
        centerAnchorPane.getChildren().add(editLyrics);
        System.out.println("-> hello!");
        centerVBox.getChildren().add(getCommentLayout((Song) object));
        // add comments to the scene
        for (Comment comment : ((Song) object).getComments()) {
            centerVBox.getChildren().add(getDisplayCommentLayout(comment));
        }
    }

    Node getCommentLayout(Song currentSong) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/comment-view.fxml"));
        try {
            Node node = loader.load();
            CommentController controller = loader.getController();
            controller.currentSong = currentSong;
            return node;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // load comment layout and return a node
    Node getDisplayCommentLayout(Comment comment) {
        // load fxml file of comment layout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/displaycomment-view.fxml"));
        try {
            Node node = loader.load();
            DisplayCommentController controller = loader.getController();
            // set comment details
            controller.username.setText(comment.getUsername());
            controller.date.setText(comment.getDate());
            controller.text.setText(comment.getText());
            return node;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void refresh(ActionEvent event){
        // add comments to song scene
        for (Comment comment : currentSong.getComments()) {
            centerVBox.getChildren().add(getDisplayCommentLayout(comment));
        }
    }

    public void editLyrics(ActionEvent event) {

    }
}
