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
        Artist slowdive = new Artist("Slowdive", "Slowdive", "slowdive@gmail.com", "slowdive1989", 20);
        Artist.addArtistToArtists(slowdive);
        Album outsideYourRoom = new Album("Outside Your Room", "May 17, 1993", slowdive);
        Song outsideYourRoom1 = new Song("Alison", "May 17, 1993", slowdive, null, "Outside Your Room", "Listen close and don't be stoned\n" +
                "I'll be here in the morning\n" +
                "'Cause I'm just floating\n" +
                "Your cigarette still burns\n" +
                "Your messed-up world will thrill me\n" +
                "\n" +
                "Alison, I'm lost\n" +
                "\n" +
                "\"Alison,\" I said, \"We're sinking\"\n" +
                "There's nothing here but that's okay\n" +
                "Outside your room, your sister's spinning\n" +
                "But she lies, tells me she's just fine\n" +
                "I guess she's out there somewhere\n" +
                "\n" +
                "And the sailors, they strike poses\n" +
                "TV covered walls\n" +
                "End so slowly\n" +
                "With your talking and your pills\n" +
                "Your messed-up life still thrills me\n" +
                "\n" +
                "Alison, I'm lost" +
                "Alison, I'll drink your wine\n" +
                "I'll wear your clothes when we're both high\n" +
                "\"Alison,\" I said, \"We're sinking\"\n" +
                "But she laughs and tells me it's just fine\n" +
                "I guess she's out there somewhere", "Shoegaze");
        Song outsideYourRoom2 = new Song("So Tired", "May 17, 1993", slowdive, null, "Outside Your Room", "So tired\n" +
                "It's so hard to feel\n" +
                "But it's alright\n" +
                "Cause I believe\n" +
                "And I guess I'll dream\n" +
                "I guess I'll take the time to dream\n" +
                "It's alright\n" +
                "I'm just sleeping\n" +
                "\n" +
                "Slow down\n" +
                "It's just always on my\n" +
                "Slow down\n" +
                "It's just always on my\n" +
                "\n" +
                "So tired\n" +
                "Suicide is gone yeah\n" +
                "But it's alright\n" +
                "Cause I believe\n" +
                "And it's just a dream\n" +
                "It's always on your\n" +
                "It's just a dream\n" +
                "It's just always on your mind", "Shoegaze");
        Song outsideYourRoom3 = new Song("Souvlaki Space Station", "May 17, 1993", slowdive, null, "Outside Your Room", "Closed doors\n" +
                "Brings open minds\n" +
                "(And I don't want to see you)\n" +
                "See you smile\n" +
                "Inside\n" +
                "(And I don't want to know you)\n" +
                "Faces\n" +
                "And I've fallen\n" +
                "(And I don't want to hear you)\n" +
                "Wonder why\n" +
                "I'm here now\n" +
                "\n" +
                "In asylum\n" +
                "Don't you see?\n" +
                "In asylum\n" +
                "Don't you see?\n" +
                "\n" +
                "Doors close\n" +
                "And feelings flow\n" +
                "(And I don't want to know you)\n" +
                "Through my mind\n" +
                "I feel his\n" +
                "(And I don't want to hear you)\n" +
                "Pictures\n" +
                "And I've fallen\n" +
                "(and I don't want to know you)\n" +
                "Wonder why\n" +
                "I'm here now\n" +
                "(I promise to be near you)" +
                "Curse your soul\n" +
                "I don't wanna hear you\n" +
                "(And I) Curse your soul\n" +
                "I don't wanna know you\n" +
                "Curse your soul\n" +
                "I don't wanna hear you\n" +
                "(And I) Curse your soul\n" +
                "I don't wanna know you", "Shoegaze");
        Song outsideYourRoom4 = new Song("Moussaka Chaos", "May 17, 1993", slowdive, null, "Outside Your Room", "This song is an instrumental", "Shoegaze");
        outsideYourRoom.addSongToAlbum(outsideYourRoom1);
        outsideYourRoom.addSongToAlbum(outsideYourRoom2);
        outsideYourRoom.addSongToAlbum(outsideYourRoom3);
        outsideYourRoom.addSongToAlbum(outsideYourRoom4);
        Album.addAlbumToAllAlbums(outsideYourRoom);
        Song.addSongToAllSongs(outsideYourRoom1);
        Song.addSongToAllSongs(outsideYourRoom2);
        Song.addSongToAllSongs(outsideYourRoom3);
        Song.addSongToAllSongs(outsideYourRoom4);

        Artist TheJungleGiants = new Artist("The Jungle Giants", "The_Jungle_Giants", "thejunglegiants@gmail.com", "giants2011", 20);
        Artist.addArtistToArtists(TheJungleGiants);
        Album theJungleGiants = new Album("The Jungle Giants", "July 1, 2011", TheJungleGiants);
        Song theJungleGiants1 = new Song("Mr Polite", "July 1, 2011", TheJungleGiants, null, "The Jungle Giants", "Comin' around\n" +
                "I'm gonna take you to town\n" +
                "I've got your name on my collar\n" +
                "I'm wearing you about\n" +
                "Can I take you out to see the sea?\n" +
                "Can I hear another story, please?\n" +
                "Are you led to the assumption\n" +
                "That your company is something that I need?\n" +
                "\n" +
                "Hey!\n" +
                "I'll only stay if you will stay\n" +
                "I'll only go if you will go\n" +
                "What are we doing anyway?\n" +
                "No!\n" +
                "No, I don't even know these people\n" +
                "But I don't mind a little unfamiliarity\n" +
                "While I politely let go\n" +
                "\n" +
                "Please stop from packing your bags\n" +
                "Or am I moving too fast?\n" +
                "I know we're living in the city\n" +
                "Well, here, we won't last\n" +
                "There's a little place near here\n" +
                "I like to go and see the sky is clear\n" +
                "Well, you can come with me and tell me\n" +
                "That I am the only one you don't fear" +
                "Hey!\n" +
                "I'll only stay if you will stay\n" +
                "I'll only go if you will go\n" +
                "What are we doing anyway?\n" +
                "No!\n" +
                "No, I don't even know these people\n" +
                "But I don't mind a little unfamiliarity\n" +
                "While I politely let go\n" +
                "\n" +
                "Why are you waiting?\n" +
                "What are you expecting to see?\n" +
                "Why are you waiting?\n" +
                "What are you expecting to see?\n" +
                "\n" +
                "Hey!\n" +
                "I'll only stay if you will stay\n" +
                "I'll only go if you will go\n" +
                "What are we doing anyway?\n" +
                "No!\n" +
                "No, I don't even know these people\n" +
                "But I don't mind a little unfamiliarity\n" +
                "While I politely let go\n" +
                "While I politely let go", "Alternative");
        Song theJungleGiants2 = new Song("No One Needs to Know", "July 1, 2011", TheJungleGiants, null, "The Jungle Giants", "I've seen watching all the seasons\n" +
                "Changing like the reasons why I'm here\n" +
                "And while we go away, the winter is here to stay\n" +
                "But we don't mind the cold\n" +
                "\n" +
                "While everybody's sleeping\n" +
                "We're just quietly creeping out of our empty beds\n" +
                "My wheels, turning in the dark\n" +
                "Leading me right through the park to where you are\n" +
                "\n" +
                "Then there it goes, another one for\n" +
                "All the people that you came for\n" +
                "And I guess that you could call them the unlucky ones\n" +
                "Yes, we could meet\n" +
                "And you could park your car discretely down the street\n" +
                "So I won't wake the neighbours with the clicking of my feet, yeah\n" +
                "\n" +
                "No one really needs to, no one really needs to\n" +
                "No one really needs to know\n" +
                "No one really needs to, no one really needs to\n" +
                "No one really needs to know" +
                "Well, you could be fair-weathered, but can this get much better?\n" +
                "I don't need a reason why\n" +
                "Just take a step out to the street, you don't really know defeat\n" +
                "So you can stop and cry\n" +
                "\n" +
                "While everybody's sleeping\n" +
                "We're just quietly creeping out of our empty beds\n" +
                "My wheels, turning in the dark\n" +
                "Leading me right through the park to where you are\n" +
                "\n" +
                "Then there it goes, another one for\n" +
                "All the people that you came for\n" +
                "And I guess that you could call them the unlucky ones\n" +
                "Yes, we could meet\n" +
                "And you could park your car discretely down the street\n" +
                "So I won't wake the neighbours with the clicking of my feet, yeah\n" +
                "\n" +
                "No one really needs to, no one really needs to\n" +
                "No one really needs to know\n" +
                "No one really needs to, no one really needs to\n" +
                "No one really needs to know" +
                "And I don't care if this is fair\n" +
                "And I don't know where to go\n" +
                "And I don't know where to go\n" +
                "And I don't care if this is fair\n" +
                "And I don't know where to go\n" +
                "And I don't care if this fair for me\n" +
                "\n" +
                "Then there it goes, another one for\n" +
                "All the people that you came for\n" +
                "And I guess that you could call them the unlucky ones\n" +
                "Yes, we could meet\n" +
                "And you could park your car discretely down the street\n" +
                "So I won't wake the neighbours with the clicking of my feet, yeah\n" +
                "\n" +
                "No one really needs to, no one really needs to\n" +
                "No one really needs to know\n" +
                "No one really needs to, no one really needs to\n" +
                "No one really needs to know", "Alternative");
        Song theJungleGiants3 = new Song("All The Wrong Places", "July 1, 2011", TheJungleGiants, null, "The Jungle Giants", "Stare while the night's turning dark\n" +
                "And the fire's in your heart\n" +
                "And you know you should not\n" +
                "But you can't help but wonder what is going on\n" +
                "Find both your shoes\n" +
                "An excuse for your bruises\n" +
                "The good and the bad drive you mad\n" +
                "If you can't tell them apart right from the start\n" +
                "\n" +
                "And I can't help but think I'm waiting\n" +
                "For darker times and complications\n" +
                "It's my subconscious navigation\n" +
                "Leading me to all the wrong places\n" +
                "\n" +
                "Well, maybe I'll never learn\n" +
                "Or maybe I'm just not concerned\n" +
                "Maybe we're both that faux\n" +
                "Well, maybe two wrongs make a right\n" +
                "Maybe they just might\n" +
                "\n" +
                "I can't help but think I'm waiting\n" +
                "For darker times and complications\n" +
                "It's my subconscious navigation\n" +
                "Leading me to all the wrong places\n" +
                "Hey, hey, hey" +
                "I was only dancin', yeah\n" +
                "'Cause I didn't know how else to get\n" +
                "Somewhere that you don't know\n" +
                "Somewhere that you don't know\n" +
                "I was only dancin', yeah\n" +
                "'Cause I didn't know how else to get\n" +
                "Somewhere that you don't know\n" +
                "Somewhere that you don't know\n" +
                "\n" +
                "I can't help but think I'm waiting\n" +
                "For darker times and complications\n" +
                "It's my subconscious navigation\n" +
                "Leading me to all the wrong places", "Alternative");
        Song theJungleGiants4 = new Song("Like a Weight", "July 1, 2011", TheJungleGiants, null, "The Jungle Giants", "So I sat on your floor\n" +
                "While you laid in your bed\n" +
                "And you told me some more\n" +
                "Of these tears in your head\n" +
                "It hurts and it feels\n" +
                "Feels like I'm dead\n" +
                "And I can't see your eyes\n" +
                "Behind all those threads\n" +
                "\n" +
                "So I silently spoke\n" +
                "Through a crack in the door\n" +
                "The things so familiar\n" +
                "Are coming no more\n" +
                "\n" +
                "Goodbye, my dear\n" +
                "Like a weight I can shake\n" +
                "Who knows if you'll hear\n" +
                "Another breath that I'll take?\n" +
                "Days come and go\n" +
                "And this loving was slow\n" +
                "So now that it's closed\n" +
                "What have you to show?" +
                "Goodbye, my dear\n" +
                "Like a weight I can shake\n" +
                "Who knows if you'll hear\n" +
                "Another breath that I'll take?\n" +
                "Days come and go\n" +
                "And this loving was slow\n" +
                "So now that it's closed\n" +
                "What have you to show?\n" +
                "Goodbye, my dear\n" +
                "Like a weight I can shake\n" +
                "Who knows if you'll hear\n" +
                "Another breath that I'll take?", "Alternative");
        Song theJungleGiants5 = new Song("One of These Days", "July 1, 2011", TheJungleGiants, null, "The Jungle Giants", "Oh oh oh...\n" +
                "Oh oh oh...\n" +
                "Oh oh oh...\n" +
                "\n" +
                "Teacher, please tell me why I can't sleep, and I can't l lie?\n" +
                "Why I can't close my eyes in the middle of the night?\n" +
                "And I wish I could let this leave my head\n" +
                "Spending days filling books, still in this side of the bed\n" +
                "\n" +
                "I don't know where I am now\n" +
                "I don't if this is my town\n" +
                "And I don't know but it's nearly been a month now\n" +
                "Funny how everything you fear\n" +
                "Goes away, and then becomes so clear\n" +
                "Can't explain why I'm still standing here\n" +
                "\n" +
                "Every morning that I wake feels like one more on the count\n" +
                "Can you tell how many days? Is this last to last from now?\n" +
                "And I wish I could let this leave her head\n" +
                "Spending days filling books, still in this side of the bed\n" +
                "\n" +
                "I don't know where I am now\n" +
                "I don't if this is my town\n" +
                "And I don't know but it's nearly been a month now\n" +
                "Funny how everything you fear\n" +
                "Goes away, and then becomes so clear\n" +
                "Can't explain why I'm still standing here" +
                "One of these days\n" +
                "We are gonna leave this whole place\n" +
                "One of these days\n" +
                "We are gonna know what to say\n" +
                "One of these days\n" +
                "We are gonna leave this whole place\n" +
                "One of these days\n" +
                "\n" +
                "Oh oh oh...\n" +
                "Oh oh oh...\n" +
                "Oh oh oh...", "Alternative");
        theJungleGiants.addSongToAlbum(theJungleGiants1);
        theJungleGiants.addSongToAlbum(theJungleGiants2);
        theJungleGiants.addSongToAlbum(theJungleGiants3);
        theJungleGiants.addSongToAlbum(theJungleGiants4);
        theJungleGiants.addSongToAlbum(theJungleGiants5);
        Album.addAlbumToAllAlbums(theJungleGiants);
        Song.addSongToAllSongs(theJungleGiants1);
        Song.addSongToAllSongs(theJungleGiants2);
        Song.addSongToAllSongs(theJungleGiants3);
        Song.addSongToAllSongs(theJungleGiants4);
        Song.addSongToAllSongs(theJungleGiants5);

        Artist francisOfDelirium = new Artist("Francis of Delirium", "Francis_Of_Deliriun", "francisofdelirium@gmail.com", "francis2019", 20);
        Artist.addArtistToArtists(francisOfDelirium);
        Album theFunhouse = new Album("The Funhouse", "April 27, 2022", francisOfDelirium);
        Song theFunhouse1 = new Song("Mirrors", "April 27, 2022", francisOfDelirium, null, "The Funhouse", "So, step right in\n" +
                "Take off your coat\n" +
                "Give it a good look\n" +
                "Give it all that you've got\n" +
                "I'll set you up over here on the floor\n" +
                "The spot should be clean\n" +
                "\n" +
                "And for over an hour\n" +
                "Your sweat turns sour\n" +
                "Hands all white\n" +
                "Covered in dust\n" +
                "And coughing up spite\n" +
                "\n" +
                "I can't look in the mirror\n" +
                "I wish you weren't here\n" +
                "I can't look in the mirror\n" +
                "I wish you weren't here\n" +
                "I can't look in the mirror\n" +
                "\n" +
                "So, step right in\n" +
                "Take off your coat\n" +
                "Give it a good look\n" +
                "Give it all that you've got\n" +
                "I'll set you up over here on the floor\n" +
                "The spot should be clеan" +
                "And for over an hour\n" +
                "Your sweat turns sour\n" +
                "Hands all white\n" +
                "Covеred in dust\n" +
                "And coughing up spite\n" +
                "\n" +
                "I can't look in the mirror\n" +
                "I wish you weren't here\n" +
                "I can't look in the mirror\n" +
                "I wish you weren't here\n" +
                "I can't look in the mirror", "Alternative");
        Song theFunhouse2 = new Song("All Love", "April 27, 2022", francisOfDelirium, null, "The Funhouse", "Let's go out\n" +
                "I'm not here\n" +
                "I got stuck\n" +
                "I'm still out of it\n" +
                "\n" +
                "You're skin deep\n" +
                "But I bleed\n" +
                "I'm nodding\n" +
                "And fade out of it\n" +
                "\n" +
                "No you don't have to call me baby\n" +
                "Know I've been in and out of it lately\n" +
                "And you don't have to say that maybe\n" +
                "One day all of this won't phase me\n" +
                "\n" +
                "I give in you give up\n" +
                "You're speaking\n" +
                "But I'm apart from this\n" +
                "Fever dream\n" +
                "Dripping seams\n" +
                "You rip in and I'm out of it\n" +
                "\n" +
                "No you don't have to call me baby\n" +
                "Don't want you to look right at me\n" +
                "And you don't have to stop this failing\n" +
                "When you try you're left with nothing" +
                "I guess that it was all love\n" +
                "All fun, all love all fun\n" +
                "All love, all fun, all love all fun\n" +
                "\n" +
                "So you dig in deep heave\n" +
                "Watch it bleed\n" +
                "As your burned out body falls into an\n" +
                "Empty flame\n" +
                "A red gash in the earths membrane\n" +
                "You're afraid\n" +
                "Feeding into what you can't tame\n" +
                "\n" +
                "You break in, break free, break down\n" +
                "Break in, break free, break down\n" +
                "Break in, break free, break down\n" +
                "Break in, break free, break down\n" +
                "\n" +
                "I guess that it was all love\n" +
                "All fun, all love all fun\n" +
                "All love, all fun, all love all fun", "Alternative");
        Song theFunhouse3 = new Song("Come out and Play", "April 27, 2022", francisOfDelirium, null, "The Funhouse", "I can't explain\n" +
                "I can't wash it off and look the other way\n" +
                "This won't fade\n" +
                "But Ican't keep it moving on until I play\n" +
                "\n" +
                "I want you to play (Play)\n" +
                "Come out and fade\n" +
                "Wash me away\n" +
                "\n" +
                "Keep me\n" +
                "Keep me at bay\n" +
                "Come out and play\n" +
                "Wash me\n" +
                "Wash me away\n" +
                "Come out and play\n" +
                "\n" +
                "I can't stay\n" +
                "I can't watch this fall apart if I'm to blame\n" +
                "Face to face\n" +
                "Hide and brace\n" +
                "Count to ten and start the game" +
                "I want you to play (Play)\n" +
                "Come out and fade\n" +
                "Wash us away\n" +
                "\n" +
                "Keep me\n" +
                "Keep me at bay\n" +
                "Come out and play\n" +
                "Wash me\n" +
                "Wash me away\n" +
                "Come out and play", "Alternative");
        Song theFunhouse4 = new Song("The Funhouse", "April 27, 2022", francisOfDelirium, null, "The Funhouse", "This isn't a call to arms\n" +
                "This is a breakdown, a falling apart\n" +
                "This is the acceptance of sin\n" +
                "This is the lamb, I’m feeding him\n" +
                "\n" +
                "Am I bleeding over\n" +
                "My lungs spilled under\n" +
                "I don't know how this one ends\n" +
                "I don't know how this one ends\n" +
                "\n" +
                "There’s a dog on it's hind legs\n" +
                "Screaming out \"Baby, I'm outside. Baby, I'm outside.\"\n" +
                "There's a place that it takes you\n" +
                "To do it's best to break you\n" +
                "You can't fight, baby, I can't fight\n" +
                "\n" +
                "I’m a free-floating body with your skin slipping off me\n" +
                "And your life flying at me, but I know that I’m all alone\n" +
                "I don't need you to take me home\n" +
                "I’ll beg and beg and beg and break this all off\n" +
                "\n" +
                "'Cause I don't know what's left to believe\n" +
                "And I don’t know what's left to believe in\n" +
                "And I don't know what's left to believe\n" +
                "And I don't know what's left to believe" +
                "So you're doing everything that you can\n" +
                "To keep your hands off of your head\n" +
                "And your whole body's flying\n" +
                "You think that you might have gone limp\n" +
                "I don't know what I did\n" +
                "\n" +
                "My legs give out and drag you right into my life\n" +
                "But I don't want you to die\n" +
                "My arms fly out and I feel like you just might\n" +
                "Wanna give this a try\n" +
                "\n" +
                "So your lungs fill with lead\n" +
                "So consumed by this feeling of dread\n" +
                "And your skin can't fill out\n" +
                "It folds and sinks into the ground\n" +
                "\n" +
                "And the sky turns red\n" +
                "You're bleeding now from the bottom of your feet and hands\n" +
                "And they put you up on a pole\n" +
                "Now you're crying 'cause you can't let go\n" +
                "\n" +
                "As your body sinks into the ground\n" +
                "And your hands are getting tied and bound\n" +
                "You're giving up, I'm giving out\n" +
                "\n" +
                "'Cause I don't know what's left to believe\n" +
                "And I don't know what's left to believe in\n" +
                "And I don't know what's left to believe\n" +
                "And I don't know what's left to believe" +
                "And it's haunting\n" +
                "Pale skin\n" +
                "Solid ground\n" +
                "Slow it down\n" +
                "Slow it down\n" +
                "Slow it down\n" +
                "Slow it down", "Alternative");
        theFunhouse.addSongToAlbum(theFunhouse1);
        theFunhouse.addSongToAlbum(theFunhouse2);
        theFunhouse.addSongToAlbum(theFunhouse3);
        theFunhouse.addSongToAlbum(theFunhouse4);
        Album.addAlbumToAllAlbums(theFunhouse);
        Song.addSongToAllSongs(theFunhouse1);
        Song.addSongToAllSongs(theFunhouse2);
        Song.addSongToAllSongs(theFunhouse3);
        Song.addSongToAllSongs(theFunhouse4);
        launch();
    }
}