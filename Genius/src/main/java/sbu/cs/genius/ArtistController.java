package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.account.User;
import sbu.cs.genius.content.Album;
import sbu.cs.genius.content.Comment;
import sbu.cs.genius.content.Song;
import java.io.IOException;

public class ArtistController {

    @FXML
    AnchorPane anchorPane;

    @FXML
    Label artistName, artistUsername, artistAge, artistEmail;

    @FXML
    ListView<String> recordsListView;

    // to give followArtist and unfollowArtist methods access to the displayed artist
    private Artist artist;
    private Button follow = new Button();

    public void setScene(Artist artist) {
        this.artist = artist;
        artistName.setText(artist.getName());
        artistUsername.setText(artist.getUsername());
        artistAge.setText(String.valueOf(artist.getAge()));
        artistEmail.setText(artist.getEmail());
        Text info = new Text(artist.getInfo());
        info.setLayoutX(20);
        info.setLayoutY(265);
        anchorPane.getChildren().add(info);
        for (Album album : artist.getAlbumsByArtist()) {
            recordsListView.getItems().add(album.toString());
        }
        if (User.getUser() != null) {
            // create "Follow" button
            artistName.setAlignment(Pos.CENTER_LEFT);
            artistUsername.setAlignment(Pos.CENTER_LEFT);
            // check if artist is already followed
            boolean isFollowed = false;
            for (Artist following : User.getUser().getFollowingList()) {
                if (artist.equals(following)) {
                    isFollowed = true;
                    break;
                }
            }
            if (isFollowed) {
                follow.setText("Unfollow");
                follow.setTextFill(Color.BLACK);
                follow.setOnAction(this::unfollowArtist);
            }
            else {
                follow.setText("Follow");
                follow.setTextFill(Color.BLUE);
                follow.setOnAction(this::followArtist);
            }
            follow.setLayoutX(175);
            follow.setLayoutY(63);
            anchorPane.getChildren().add(follow);
        }
        System.out.println("-> artist scene is set");

        recordsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int index = recordsListView.getSelectionModel().getSelectedIndex();
                System.out.println("-> selected " + recordsListView.getSelectionModel().getSelectedItem());
                // load album controller
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/album-view.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                AlbumController albumController= loader.getController();
                albumController.setScene(artist.getAlbumsByArtist().get(index));
                // switch scenes
                Stage stage = (Stage) recordsListView.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                System.out.println("-> switched to album scene");
            }
        });
    }

    public void followArtist(ActionEvent event) {
        User.getUser().followArtist(artist);
        System.out.println("-> " + artist + " is followed");
        follow.setText("Unfollow");
        follow.setTextFill(Color.BLACK);
        follow.setOnAction(this::unfollowArtist);
    }

    public void unfollowArtist(ActionEvent event) {
        User.getUser().unfollowArtist(artist);
        System.out.println("-> " + artist + " is unfollowed");
        follow.setText("Follow");
        follow.setTextFill(Color.BLUE);
        follow.setOnAction(this::followArtist);
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
//
//    private void setAlbumScene(Object object) {
//        rightAnchorPane.getChildren().remove(2, 8);
//        listView.getItems().clear();
//        title.setText("Track List");
//        heading.setText(((Album) object).getTitle());
//        subheading.setText(((Album) object).getArtist().toString());
//        Label releaseDate = new Label("Release Date");
//        releaseDate.setLayoutX(20);
//        releaseDate.setLayoutY(140);
//        rightAnchorPane.getChildren().add(releaseDate);
//        Label albumReleaseDate = new Label(((Album) object).getReleaseDate());
//        albumReleaseDate.setLayoutX(140);
//        albumReleaseDate.setLayoutY(140);
//        rightAnchorPane.getChildren().add(albumReleaseDate);
//        for (Song song : ((Album) object).getTracklist()) {
//            listView.getItems().add(song.toString());
//        }
//        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                int index = listView.getSelectionModel().getSelectedIndex();
//                System.out.println("-> selected " + listView.getSelectionModel().getSelectedItem());
//                setSongScene(((Album) object).getTracklist().get(index));
//            }
//        });
//    }
//
//    public void setSongScene(Object object) {
//        currentSong = (Song) object;
//        rightAnchorPane.getChildren().remove(2, 4);
//        title.setText("Lyrics");
//        heading.setText(((Song) object).getTitle());
//        subheading.setText(((Song) object).getArtist().toString());
//        int y = 140;
//        if (((Song) object).getCoArtist() != null) {
//            Label coArtist = new Label("Co-Artist");
//            coArtist.setLayoutX(20);
//            coArtist.setLayoutY(y);
//            rightAnchorPane.getChildren().add(coArtist);
//            Label songCoArtist = new Label(((Song) object).getCoArtist().toString());
//            songCoArtist.setLayoutX(110);
//            songCoArtist.setLayoutY(y);
//            rightAnchorPane.getChildren().add(songCoArtist);
//            y += 45;
//        }
//        Label albumTitle = new Label("Album Title");
//        albumTitle.setLayoutX(20);
//        albumTitle.setLayoutY(y);
//        rightAnchorPane.getChildren().add(albumTitle);
//        Label songAlbumTitle = new Label(((Song) object).getAlbumTitle());
//        songAlbumTitle.setLayoutX(110);
//        songAlbumTitle.setLayoutY(y);
//        rightAnchorPane.getChildren().add(songAlbumTitle);
//        y += 45;
//        Label releaseDate = new Label("Release Date");
//        releaseDate.setLayoutX(20);
//        releaseDate.setLayoutY(y);
//        rightAnchorPane.getChildren().add(releaseDate);
//        Label songReleaseDate = new Label(((Song) object).getReleaseDate());
//        songReleaseDate.setLayoutX(110);
//        songReleaseDate.setLayoutY(y);
//        rightAnchorPane.getChildren().add(songReleaseDate);
//        y += 45;
//        Label genre = new Label("Genre");
//        genre.setLayoutX(20);
//        genre.setLayoutY(y);
//        rightAnchorPane.getChildren().add(genre);
//        Label songGenre = new Label(((Song) object).getGenre());
//        songGenre.setLayoutX(110);
//        songGenre.setLayoutY(y);
//        rightAnchorPane.getChildren().add(songGenre);
//        y += 45;
//        // tags
//        Label views = new Label("Views");
//        views.setLayoutX(20);
//        views.setLayoutY(y);
//        rightAnchorPane.getChildren().add(views);
//        Label songViews = new Label(String.valueOf(((Song) object).getViewsCount()));
//        songViews.setLayoutX(110);
//        songViews.setLayoutY(y);
//        rightAnchorPane.getChildren().add(songViews);
//        Text lyric = new Text(((Song) object).getLyric());
//        lyric.setLayoutX(30);
//        lyric.setLayoutY(115);
//        centerAnchorPane.getChildren().remove(listView);
//        centerAnchorPane.getChildren().add(lyric);
//        Button refresh = new Button("Refresh");
//        refresh.setPrefWidth(65);
//        refresh.setPrefHeight(30);
//        refresh.setLayoutX(395);
//        refresh.setLayoutY(18);
//        refresh.setOnAction(this::refresh);
//        centerAnchorPane.getChildren().add(refresh);
//        Button editLyrics = new Button("Edit Lyrics");
//        editLyrics.setPrefWidth(85);
//        editLyrics.setPrefHeight(30);
//        editLyrics.setLayoutX(17);
//        editLyrics.setLayoutY(18);
//        editLyrics.setOnAction(this::editLyrics);
//        centerAnchorPane.getChildren().add(editLyrics);
//        System.out.println("-> hello!");
//        centerVBox.getChildren().add(getCommentLayout((Song) object));
//        // add comments to the scene
//        for (Comment comment : ((Song) object).getComments()) {
                // X = 20
                // Y = 40
//            centerVBox.getChildren().add(getDisplayCommentLayout(comment));
//        }
//    }
}
