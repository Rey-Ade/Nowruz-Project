package sbu.cs.genius.account;

import sbu.cs.genius.content.Album;
import sbu.cs.genius.content.Song;

import java.util.ArrayList;

public class Artist extends Account{

    private static Artist artist = null;

    private String info;
    private ArrayList<Album> albumsByArtist;
    private ArrayList<Song> songsByArtist;

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

    public ArrayList<Album> getAlbums() {
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
}
