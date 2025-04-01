package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.account.User;
import sbu.cs.genius.content.Song;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private MenuButton myMenuButton;

    @FXML
    private ListView<String> topSongsListView;

    @FXML
    private TextField searchTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // user is a "User"
        if (User.getUser() != null) {
            // change the text of the menu button
            myMenuButton.setText(User.getUser().getUsername());
        }
        // user is an "Artist"
        else {
            // change the text of the menu button
            myMenuButton.setText(Artist.getArtist().getUsername());
            // add two more menu items
            MenuItem newAlbum = new MenuItem("new album");
            MenuItem newSingle = new MenuItem("new single");
            myMenuButton.getItems().add(newAlbum);
            myMenuButton.getItems().add(newSingle);
            // assign a method to each of the new menu items
            newAlbum.setOnAction(this::newAlbum);
            newSingle.setOnAction(this::newSingle);
        }
        // initialize ListView
        String[] topSongs = new String[5];
        ArrayList<Song> tempAllSongs = Song.getAllSongs();
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
    }

    public void profileScene() {

    }

    public void newAlbum (ActionEvent event) {
        System.out.println("new album");
    }

    public void newSingle(ActionEvent event) {
        System.out.println("new single");
    }

    public void search(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/search-view.fxml"));
        root = loader.load();

        // make an instance of SearchController class
        SearchController searchController = loader.getController();
        searchController.getSearchTerm(searchTextField.getText());

        // switch to search scene
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
