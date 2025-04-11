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
                int index = recordsListView.getSelectionModel().getSelectedIndex();
                // load Album controller
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/album-view.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                AlbumController albumController = loader.getController();
                albumController.setScene(artist.getAlbumsByArtist().get(index), "/sbu/cs/genius/artist-view.fxml");
                // switch scenes
                ActionEvent event = new ActionEvent();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                System.out.println("-> switched to album scene");
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
