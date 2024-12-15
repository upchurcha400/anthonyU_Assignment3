package com.codercampus.userLoginService;

import java.util.Scanner;

public class UserLoginApplication {

    //First I need to create a new instance of UserService to use the class

    public static void main(String[] args) {
        UserService userService = new UserService();
        User[] users = userService.loadUsers("data.txt");

        //Then the program needs to have a way to take user input to validate against the file contents
        //We are also establish the variables use in the loop and for the scanner to store its input

        try (Scanner scanner = new Scanner(System.in)) {
            String inputUser;
            String inputPassword;
            int logInAttempts = 0;
            final int MAX_LOGIN_ATTEMPTS = 5;
            User validUser = null;

            //The goal is to validate the user input while limiting the attempts to login

            while (logInAttempts < MAX_LOGIN_ATTEMPTS && validUser == null) {
                System.out.println("Please Enter Your Username (Hint: email address): ");
                inputUser = scanner.nextLine();
                System.out.println("Please Enter Your Password: ");
                inputPassword = scanner.nextLine();

               //This is calling the UserService method we created to compare input to file contents

                validUser = userService.validateUser(users, inputUser, inputPassword);

                //I established the return null value in the UserService method to stop automatic logins
                //If the input matches the file, then isAUser != null and a welcome message will print

                if (validUser != null) {
                    System.out.println("Welcome " + validUser.getName() + "!");

                    //Otherwise, the null value stays and an error message is printed, then the loop continues and increments the counter

                } else {
                    System.out.println("Invalid username or password. Please try again.");
                    logInAttempts++;
                }
            }
            //Once the counter maxes out, then the loop breaks and this if statement begins, then the scanner closes

            if (validUser == null) {
                System.out.println("Too many failed login attempts. Please try again later.");
            }
        }

    }
}