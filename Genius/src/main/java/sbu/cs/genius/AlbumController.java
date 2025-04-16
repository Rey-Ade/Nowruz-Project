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
    private Label albumReleaseDate;

    @FXML
    private ListView<String> trackListView;

    // stores the path of the previous scene
    private String prePage = "";

    public void setScene(Album album, String path) {
        prePage = path;
        albumReleaseDate.setText(album.getReleaseDate());
        for (Song song : album.getTracklist()) {
            trackListView.getItems().add(song.toString());
        }
        System.out.println("-> album scene is set");

        trackListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int index = trackListView.getSelectionModel().getSelectedIndex();
                System.out.println("-> selected " + trackListView.getSelectionModel().getSelectedItem());
                // load song controller
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/song-view.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                SongController songController = loader.getController();
                songController.setScene(album.getTracklist().get(index), "/sbu/cs/genius/album-view.fxml");
                // switch scenes
                Stage stage = (Stage) trackListView.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                System.out.println("-> switched to song scene");
            }
        });
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
}
