package sbu.cs.genius;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.content.Album;
import sbu.cs.genius.content.Song;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SearchController {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<String> searchListView;

    @FXML
    public void search() {
        String term = searchTextField.getText();
        ArrayList<Object> searchResults = new ArrayList<>();
        // search through artists
        for (Artist artist : Artist.getArtists()) {
            // using toLowerCase() method makes contains() method case-insensitive
            if (artist.getUsername().toLowerCase().contains(term.toLowerCase())) {
                searchResults.add(artist);
                searchListView.getItems().add(artist.toString());
            }
        }
        // search through albums
        for (Album album : Album.getAllAlbums()) {
            if (album.getTitle().toLowerCase().contains(term.toLowerCase())) {
                searchResults.add(album);
                searchListView.getItems().add(album.toString());
            }
        }
        // search through songs
        System.out.println("Songs:");
        int i = 1;
        for (Song song : Song.getAllSongs()) {
            System.out.println(i + ". " + song.getTitle().toLowerCase());
            i++;
            if (song.getTitle().toLowerCase().contains(term.toLowerCase())) {
                searchResults.add(song);
                searchListView.getItems().add(song.toString());
                //System.out.println("found " + song.toString());
            }
        }

        searchListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                int index = searchListView.getSelectionModel().getSelectedIndex();
                // switch scenes
                if (searchResults.get(index) instanceof Artist) {

                }
                else if (searchResults.get(index) instanceof Album) {

                }
                else {

                }
            }
        });
    }

    @FXML
    public void home(ActionEvent event) throws IOException {
        // switch to home scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/home-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
