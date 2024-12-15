package com.codercampus.userLoginService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class UserService {


    public User[] readFile(String fileName) {


        User[] users = new User[10];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int usersRead = 0;


            while ((line = bufferedReader.readLine()) != null && usersRead < users.length) {
                String[] userDetails = line.split(",");
                users[usersRead] = new User(userDetails[0], userDetails[1], userDetails[2]);
                usersRead++;
            }


        } catch (IOException e) {
            System.out.println("There was an issue reading file! Here is why ---> " + e.getMessage());
        }


        return users;
    }


    public User validUser(User[] users, String username, String password) {
        for (User user : users) {
            if (user != null && user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }


        return null;
    }
}