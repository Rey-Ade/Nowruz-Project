package sbu.cs.genius.content;

import sbu.cs.genius.account.Artist;

import java.util.ArrayList;

public class Album {

    private String title;
    // in the form of ex. November 14, 1995
    private String releaseDate;
    private Artist artist;
    private ArrayList<Song> tracklist;

    public Album(String title, String releaseDate, Artist artist) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public ArrayList<Song> getTracklist() {
        return tracklist;
    }

    public void addSong(Song song) {
        tracklist.add(song);
    }
}
