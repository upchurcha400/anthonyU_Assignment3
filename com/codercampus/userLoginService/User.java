package com.codercampus.userLoginService;

//This is the class that will establish the objects being read from the file and give them purpose in the program
//To think, this all this started with the POJO lesson :-/

public class User {
    private String username;
    private String password;
    private String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}