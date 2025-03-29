package sbu.cs.genius.account;

public class Artist extends Account{

    private static Artist artist = null;

    public Artist (String name, String username, String email, String password, int age) {
        super(name, username, email, password, age);
    }

    public static Artist getArtist() {
        return artist;
    }

    public static void setArtist(Artist artist) {
        Artist.artist = artist;
    }
}
