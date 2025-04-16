package sbu.cs.genius.account;

import sbu.cs.genius.content.Comment;
import sbu.cs.genius.content.Song;

import java.util.ArrayList;

public class User extends Account{

    private static User user = null;

    private ArrayList<Artist> followingList = new ArrayList<>();

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

    public void followArtist(Artist artist) {
        followingList.add(artist);
    }

    public void unfollowArtist(Artist artist) {
        followingList.remove(artist);
    }

//    public void viewSong(Song song) {
//        song.updateViewsCount();
//    }

    public void comment(Song song, String text) {
        Comment comment = new Comment(getUsername(), text);
        song.addComment(comment);
    }
}
