package sbu.cs.genius.account;

import sbu.cs.genius.content.Album;
import sbu.cs.genius.content.Song;

import java.util.ArrayList;

public class Artist extends Account{

    private static Artist artist = null;

    private String info;
    private ArrayList<Album> albums;
    private ArrayList<Song> songs;

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
        return albums;
    }

    public void newAlbum(Album newAlbum) {
        albums.add(newAlbum);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void newSong(Song newSong) {
        songs.add(newSong);
    }

    public void editLyric(Song song, String lyric) {
        song.editLyric(lyric);
    }
}
