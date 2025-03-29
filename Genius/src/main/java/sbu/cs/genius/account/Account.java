package sbu.cs.genius.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Account {

    private String name;
    private String username;
    private String email;
    private String password;
    private int age;

    public Account(String name, String username, String email, String password, int age) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public static boolean validPassword(String password) {
        Pattern pattern = Pattern.compile("(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

}
