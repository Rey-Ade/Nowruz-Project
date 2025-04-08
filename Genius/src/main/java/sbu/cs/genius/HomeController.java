package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sbu.cs.genius.account.User;
import sbu.cs.genius.content.Song;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private ListView<String> topSongsListView;

    @FXML
    private Button newAlbumButton, newSingleButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // user is a "User"
        if (User.getUser() != null) {
            newAlbumButton.setVisible(false);
            newSingleButton.setVisible(false);
        }
        // uses is an "Artist"
        else {
            newAlbumButton.setOnAction(this::newAlbum);
            newSingleButton.setOnAction(this::newSingle);
        }

        // initialize ListView
        String[] topSongs = new String[5];
        List<Song> tempAllSongs = new ArrayList<>(Song.getAllSongs());
        Song topSong = Song.getAllSongs().getFirst();
        for (int j = 0; j < 5; j++) {
            for (Song song : tempAllSongs) {
                if (song.getViewsCount() > topSong.getViewsCount()) {
                    topSong = song;
                }
            }
            topSongs[j] = topSong.toString();
            tempAllSongs.remove(topSong);
            topSong = tempAllSongs.getFirst();
        }
        topSongsListView.getItems().addAll(topSongs);
        System.out.println("-> top songs ListView is initialized");
    }

    @FXML
    public void profile() {

    }

    public void newAlbum (ActionEvent event) {
        System.out.println("new album");
    }

    public void newSingle(ActionEvent event) {
        System.out.println("new single");
    }

    @FXML
    public void search(ActionEvent event) throws IOException {
        // switch to search scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sbu/cs/genius/browse-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        System.out.println("-> switched to browse scene");
    }
}
