package sbu.cs.genius.account;

import sbu.cs.genius.content.Album;
import sbu.cs.genius.content.Song;

import java.util.ArrayList;

public class Artist extends Account{

    private static Artist artist = null;
    private static ArrayList<Artist> artists = new ArrayList<>();

    private String info;
    private ArrayList<Album> albumsByArtist = new ArrayList<>();
    private ArrayList<Song> songsByArtist = new ArrayList<>();

    public Artist (String name, String username, String email, String password, int age) {
        super(name, username, email, password, age);
    }

    public static Artist getArtist() {
        return artist;
    }

    public static void setArtist(Artist artist) {
        Artist.artist = artist;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<Album> getAlbumsByArtist() {
        return albumsByArtist;
    }

    public void newAlbum(Album newAlbum) {
        // add new album to artist's record
        albumsByArtist.add(newAlbum);
        // add new album to allAlbums array
        Album.addAlbumToAllAlbums(newAlbum);
    }

    public ArrayList<Song> getSongsByArtist() {
        return songsByArtist;
    }

    public void newSong(Song newSong) {
        // add new song to artist's record
        songsByArtist.add(newSong);
        // add new song to allSongs array
        Song.addSongToAllSongs(newSong);
    }

    public void editLyric(Song song, String lyric) {
        song.editLyric(lyric);
    }

    public static ArrayList<Artist> getArtists() {
        return artists;
    }

    public static void addArtistToArtists(Artist artist) {
        Artist.artists.add(artist);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object object) {
        return ((Artist) object).getUsername().equals(getUsername());
    }
}
