package sbu.cs.genius.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Account {

    public static Account account;

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
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean validUsername(String username) {
        Pattern pattern = Pattern.compile("^\\S{5,8}$");
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }

    public static boolean validEmail(String email) {
        Pattern pattern = Pattern.compile("^\\S+@[^-][^_]+\\.\\w+");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
