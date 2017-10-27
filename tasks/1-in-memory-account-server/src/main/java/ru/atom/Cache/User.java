package ru.atom.Cache;

public class User {
    //private final String firstName;
    //private final String familyName;
    private final String nick;
    private final String password;

    public User(String nick, String password) {

        this.nick = nick;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }
}