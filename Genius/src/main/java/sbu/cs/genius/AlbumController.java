package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sbu.cs.genius.content.Album;
import sbu.cs.genius.content.Song;

import java.io.IOException;

public class AlbumController {

    @FXML
    private Label albumTitle, albumArtist, albumReleaseDate;

    @FXML
    private ListView<String> trackListView;

    private String path = "";

    public void setScene(Album album, String path, ActionEvent event) {
        this.path = path;
        albumTitle.setText(album.getTitle());
        albumArtist.setText(album.getArtist().toString());
        albumReleaseDate.setText(album.getReleaseDate());
        for (Song song : album.getTracklist()) {
            trackListView.getItems().add(song.toString());
        }
        System.out.println("-> album scene is set");

        trackListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int index = trackListView.getSelectionModel().getSelectedIndex();
                // load song controller

                // switch scenes

                System.out.println("-> switched to song scene");
            }
        });
    }

    public void back(ActionEvent event) throws IOException {
        // switch to path (previous) scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        System.out.println("-> switch to previous scene");
    }
}
