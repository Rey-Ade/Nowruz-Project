package sbu.cs.genius;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.content.Album;
import sbu.cs.genius.content.Song;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class BrowseController {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<String> searchListView;

    @FXML
    public void search(ActionEvent e) throws IOException {
        searchListView.getItems().clear();
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
        for (Song song : Song.getAllSongs()) {
            if (song.getTitle().toLowerCase().contains(term.toLowerCase())) {
                searchResults.add(song);
                searchListView.getItems().add(song.toString());
            }
        }
        System.out.println("-> search ListView is populated");

        searchListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int index = searchListView.getSelectionModel().getSelectedIndex();
                System.out.println("-> selected " + searchListView.getSelectionModel().getSelectedItem());
                if (searchResults.get(index) instanceof Artist) {
                    // load Artist controller
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/artist-view.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    ArtistController artistController = loader.getController();
                    artistController.setScene((Artist) (searchResults.get(index)));
                    // switch scenes
                    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    System.out.println("-> switched to artist scene");
                }
                else {
                    System.out.println("-> failed");
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
        System.out.println("-> switched to home scene");
    }

}
