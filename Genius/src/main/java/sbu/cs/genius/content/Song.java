package sbu.cs.genius.content;

import sbu.cs.genius.account.Artist;

import java.util.ArrayList;

public class Song {

    private String title;
    // in the form of ex. November 14, 1995
    private String releaseDate;
    private Artist artist;
    private Artist coArtist;
    private String albumTitle;
    private String lyric;
    private String genre;
    private ArrayList<String> tag;
    private ArrayList<String> comment;
    private int viewsCount = 0;

    public Song(String title, String releaseDate, Artist artist, Artist coArtist, String albumTitle, String lyric, String genre) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.coArtist = coArtist;
        this.albumTitle =  albumTitle;
        this.lyric = lyric;
        this.genre = genre;

    }

    public void editLyric(String newLyric) {
        lyric = newLyric;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void updateViewsCount() {
        viewsCount++;
    }

    public ArrayList<String> getComment() {
        return comment;
    }

    public void addComment(String comment) {
        this.comment.add(comment);
    }
}
