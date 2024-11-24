package com.codercampus.userLoginService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//To the grader: I am sorry for the comments through out. Had a tough time following the lesson video and I have to talk things
//out, so they will help me understand the lesson more if I can read them and refresh my memory. Let me know if I should remove them
//prior to submission. Thank you!


public class UserService {
    //Set the array size to 10 just in case users are added later

    public User[] readFile(String fileName) {

        //this will create a new file reader as an instantiation of the BufferedReader class. It will make a string out of the
        //line of data it pulls from the file and then it will break that down csv style to complete the required array requirements
        //It is also going to count how many lines of user data it reads from the file

        User[] users = new User[10];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int usersRead = 0;

            //this will read the file line by line and split the data into an array of strings

            while ((line = bufferedReader.readLine()) != null && usersRead < users.length) {
                String[] userDetails = line.split(",");
                users[usersRead] = new User(userDetails[0], userDetails[1], userDetails[2]);
                usersRead++;
            }

            //Here is where the program will catch any file exceptions and tell the user why on the console

        } catch (IOException e) {
            System.out.println("There was an issue reading file! Here is why ---> " + e.getMessage());
        }
        //This is going to return the complete array of users read from the file up to ten.

        return users;
    }

    //This is the method that will be called from UserLoginApplication to validate the input against the file contents
    //Modify the if statement to add the .equalsIgnoreCase method to the username to make it case-insensitive
    public User validUser(User[] users, String username, String password) {
        for (User user : users) {
            if (user != null && user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        //If the input is not found in the file a null value will return to be handled in the ULA

        return null;
    }
}