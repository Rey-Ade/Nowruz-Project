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
        EchoSeraph.setInfo("Hi I'm Echo Seraph\n" +
                "Spreading good vibes");
        Artist.addArtistToArtists(EchoSeraph);
        Album starlightChronicles = new Album("Starlight Chronicles", "May 17, 1993", EchoSeraph);
        Song starlightChronicles1 = new Song("Whispers in the Nebula", "May 17, 1993", EchoSeraph, null, "Starlight Chronicles", "" , "Pop");
        Song starlightChronicles2 = new Song("Crimson Sky", "May 17, 1993", EchoSeraph, null, "Starlight Chronicles", "[enter lyric here]" , "Pop");
        Song starlightChronicles3 = new Song("Electric Stardust", "May 17, 1993", EchoSeraph, null, "Starlight Chronicles", "[enter lyric here]", "Pop");
        Song starlightChronicles4 = new Song("Fading Echoes", "May 17, 1993", EchoSeraph, null, "Starlight Chronicles", "(Verse 1)\n" +
                "I still hear your voice in the hollow of the night\n" +
                "Like a ghost that won’t let go, clingin’ to the light\n" +
                "We said forever under stormy skies\n" +
                "But forever fades when the silence multiplies\n" +
                "\n" +
                "(Pre-Chorus)\n" +
                "You were a fire, burnin’ wild and bright\n" +
                "Now you're a whisper in the back of my mind\n" +
                "\n" +
                "(Chorus)\n" +
                "Fading echoes, calling me back\n" +
                "To the places where we lost what we had\n" +
                "Like smoke in the wind, like dreams in the rain\n" +
                "I reach for you, but you slip away again\n" +
                "Oh-oh, fading echoes in the dark\n" +
                "\n" +
                "(Verse 2)\n" +
                "Your shadow dances on the edges of my doubt\n" +
                "A phantom truth I can't live with or without\n" +
                "I’ve memorized the cracks in every wall\n" +
                "Still waiting for your voice to break the fall\n" +
                "\n" +
                "(Pre-Chorus)\n" +
                "You were thunder in my quiet world\n" +
                "Now you’re just silence I can’t unlearn\n" +
                "\n" +
                "(Chorus)\n" +
                "Fading echoes, calling me back\n" +
                "To the places where we lost what we had\n" +
                "Like smoke in the wind, like dreams in the rain\n" +
                "I reach for you, but you slip away again\n" +
                "Oh-oh, fading echoes in the dark\n" +
                "\n" +
                "(Bridge)\n" +
                "We were fire, we were fate\n" +
                "Now we’re echoes lost in space\n" +
                "All that’s left are memories\n" +
                "Bouncing off the vacancy\n" +
                "\n" +
                "(Final Chorus)\n" +
                "Fading echoes, haunting my mind\n" +
                "I scream your name but I’m out of time\n" +
                "Like stars that fall before they shine\n" +
                "You were almost forever, just not mine\n" +
                "Oh-oh, fading echoes…\n" +
                "Just fading echoes…\n" +
                "In the dark", "Pop");
        starlightChronicles.addSongToAlbum(starlightChronicles1);
        starlightChronicles.addSongToAlbum(starlightChronicles2);
        starlightChronicles.addSongToAlbum(starlightChronicles3);
        starlightChronicles.addSongToAlbum(starlightChronicles4);
        EchoSeraph.newAlbum(starlightChronicles);
        EchoSeraph.newSong(starlightChronicles1);
        EchoSeraph.newSong(starlightChronicles2);
        EchoSeraph.newSong(starlightChronicles3);
        EchoSeraph.newSong(starlightChronicles4);

        Artist CairoNova = new Artist("Cairo Nova", "Cairo_Nova", "caironova@gmail.com", "cairo2011", 21);
        CairoNova.setInfo("Caitlyn Grace Nova\n" +
                "Known professionally as Cairo Nova");
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
        CairoNova.newAlbum(theGardenOfBrokenTime);
        CairoNova.newSong(theGardenOfBrokenTime1);
        CairoNova.newSong(theGardenOfBrokenTime2);
        CairoNova.newSong(theGardenOfBrokenTime3);
        CairoNova.newSong(theGardenOfBrokenTime4);

        Artist NeonDrifters = new Artist("Neon Drifters", "Neon_Drifters", "neondrifters@gmail.com", "drifters2019", 35);
        NeonDrifters.setInfo("American alternative band formed\n" +
                "in New York City in 2011");
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
        NeonDrifters.newAlbum(fracturedReality);
        NeonDrifters.newSong(fracturedReality1);
        NeonDrifters.newSong(fracturedReality2);
        NeonDrifters.newSong(fracturedReality3);
        NeonDrifters.newSong(fracturedReality4);

        Artist GlassChapel = new Artist("Glass Chapel", "Glass_Chapel", "glasschapel@gmail.com", "chapel2007", 17);
        GlassChapel.setInfo("French band formed in 2007");
        Artist.addArtistToArtists(GlassChapel);
        Album plasticWeather = new Album("Plastic Weather - Single", "December 7, 2013", GlassChapel);
        Song plasticWeather1 = new Song("Plastic Weather", "December 7, 2013", GlassChapel, null, "Plastic Weather - Single", "[enter lyric here]", "Folk");
        plasticWeather.addSongToAlbum(plasticWeather1);
        GlassChapel.newAlbum(plasticWeather);
        GlassChapel.newSong(plasticWeather1);

        System.out.println("-> initial data is entered");
        launch();
    }
}