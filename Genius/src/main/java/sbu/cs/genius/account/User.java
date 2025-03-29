package sbu.cs.genius.account;

public class User extends Account{

    private static User user;

    public User(String name, String username, String email, String password, int age) {
        super(name, username, email, password, age);
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        User.user = user;
    }
}
