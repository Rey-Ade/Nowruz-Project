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
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.content.Album;
import java.io.IOException;

public class ArtistController {

    @FXML
    private Label artistName, artistUsername, artistAge, artistEmail;

    @FXML
    private ListView<String> recordsListView;


    public void setScene(Artist artist) {
        artistName.setText(artist.getName());
        artistUsername.setText(artist.getUsername());
        artistAge.setText(String.valueOf(artist.getAge()));
        artistEmail.setText(artist.getEmail());
        for (Album album : artist.getAlbumsByArtist()) {
            recordsListView.getItems().add(album.toString());
        }
        System.out.println("-> artist scene is set");
        recordsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // load Album controller
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/artist-view.fxml"));
//                Parent root = null;
//                try {
//                    root = loader.load();
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//                ArtistController artistController = loader.getController();
//                artistController.setScene((Artist) (searchResults.get(index)));
//                // switch scenes
//                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.setResizable(false);
//                stage.show();
//                System.out.println("-> switch to artist scene");
            }
        });
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
}
