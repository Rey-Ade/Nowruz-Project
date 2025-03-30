package sbu.cs.genius.account;

import sbu.cs.genius.content.Song;

import java.util.ArrayList;

public class User extends Account{

    private static User user = null;

    private ArrayList<Artist> followingList;

    public User(String name, String username, String email, String password, int age) {
        super(name, username, email, password, age);
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        User.user = user;
    }

    public ArrayList<Artist> getFollowingList() {
        return followingList;
    }

    public void addArtistToFollowingList(Artist artist) {
        followingList.add(artist);
    }

    public void viewSong(Song song) {
        song.updateViewsCount();
    }

    public void comment(Song song, String comment) {
        song.addComment(comment);
    }
}
