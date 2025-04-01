package sbu.cs.genius;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.content.Album;
import sbu.cs.genius.content.Song;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("signup-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        // initial data
        Artist EchoSeraph = new Artist("Echo Seraph", "Echo_Seraph", "echoseraph@gmail.com", "echo1993", 25);
        Artist.addArtistToArtists(EchoSeraph);
        Album starlightChronicles = new Album("Starlight Chronicles", "May 17, 1993", EchoSeraph);
        Song starlightChronicles1 = new Song("Whispers in the Nebula", "May 17, 1993", EchoSeraph, null, "Starlight Chronicles", "[enter lyric here]" , "Folk");
        Song starlightChronicles2 = new Song("Crimson Sky", "May 17, 1993", EchoSeraph, null, "Starlight Chronicles", "[enter lyric here]" , "Folk");
        Song starlightChronicles3 = new Song("Electric Stardust", "May 17, 1993", EchoSeraph, null, "Starlight Chronicles", "[enter lyric here]", "Folk");
        Song starlightChronicles4 = new Song("Fading Echoes", "May 17, 1993", EchoSeraph, null, "Starlight Chronicles", "[enter lyric here]", "Folk");
        starlightChronicles.addSongToAlbum(starlightChronicles1);
        starlightChronicles.addSongToAlbum(starlightChronicles2);
        starlightChronicles.addSongToAlbum(starlightChronicles3);
        starlightChronicles.addSongToAlbum(starlightChronicles4);
        Album.addAlbumToAllAlbums(starlightChronicles);
        Song.addSongToAllSongs(starlightChronicles1);
        Song.addSongToAllSongs(starlightChronicles2);
        Song.addSongToAllSongs(starlightChronicles3);
        Song.addSongToAllSongs(starlightChronicles4);

        Artist CairoNova = new Artist("Cairo Nova", "Cairo_Nova", "caironova@gmail.com", "cairo2011", 21);
        Artist.addArtistToArtists(CairoNova);
        Album theGardenOfBrokenTime = new Album("The Garden of Broken Time", "July 1, 2011", CairoNova);
        Song theGardenOfBrokenTime1 = new Song("Clockwork Flowers", "July 1, 2011", CairoNova, null, "The Garden of Broken Time", "[enter lyric here]" , "Alternative");
        Song theGardenOfBrokenTime2 = new Song("Rust in the Roots", "July 1, 2011", CairoNova, null, "The Jungle Giants", "[enter lyric here]", "Alternative");
        Song theGardenOfBrokenTime3 = new Song("Cracked Hourglass", "July 1, 2011", CairoNova, null, "The Jungle Giants", "[enter lyric here]", "Alternative");
        Song theGardenOfBrokenTime4 = new Song("Eclipsed Sun", "July 1, 2011", CairoNova, null, "The Jungle Giants", "[enter lyric here]", "Alternative");
        theGardenOfBrokenTime.addSongToAlbum(theGardenOfBrokenTime1);
        theGardenOfBrokenTime.addSongToAlbum(theGardenOfBrokenTime2);
        theGardenOfBrokenTime.addSongToAlbum(theGardenOfBrokenTime3);
        theGardenOfBrokenTime.addSongToAlbum(theGardenOfBrokenTime4);
        Album.addAlbumToAllAlbums(theGardenOfBrokenTime);
        Song.addSongToAllSongs(theGardenOfBrokenTime1);
        Song.addSongToAllSongs(theGardenOfBrokenTime2);
        Song.addSongToAllSongs(theGardenOfBrokenTime3);
        Song.addSongToAllSongs(theGardenOfBrokenTime4);

        Artist NeonDrifters = new Artist("Neon Drifters", "Neon_Drifters", "neondrifters@gmail.com", "drifters2019", 35);
        Artist.addArtistToArtists(NeonDrifters);
        Album fracturedReality = new Album("Fractured Reality", "April 27, 2022", NeonDrifters);
        Song fracturedReality1 = new Song("Mirrors", "April 27, 2022", NeonDrifters, null, "The Funhouse", "[enter lyric here]", "Alternative");
        Song fracturedReality2 = new Song("Through the Glass", "April 27, 2022", NeonDrifters, null, "The Funhouse", "[enter lyric here]", "Alternative");
        Song fracturedReality3 = new Song("Come out and Play", "April 27, 2022", NeonDrifters, null, "The Funhouse", "[enter lyric here]", "Alternative");
        Song fracturedReality4 = new Song("The Last Lighthouse", "April 27, 2022", NeonDrifters, null, "The Funhouse", "[enter lyric here]", "Alternative");
        fracturedReality.addSongToAlbum(fracturedReality1);
        fracturedReality.addSongToAlbum(fracturedReality2);
        fracturedReality.addSongToAlbum(fracturedReality3);
        fracturedReality.addSongToAlbum(fracturedReality4);
        Album.addAlbumToAllAlbums(fracturedReality);
        Song.addSongToAllSongs(fracturedReality1);
        Song.addSongToAllSongs(fracturedReality2);
        Song.addSongToAllSongs(fracturedReality3);
        Song.addSongToAllSongs(fracturedReality4);
        launch();
    }
}