package com.codercampus.userLoginService;

import java.util.Scanner;

public class UserLoginApplication {

    //First I need to create a new instance of UserService to use the class

    public static void main(String[] args) {
        UserService userService = new UserService();
        User[] users = userService.readFile("data.txt");

        //Then the program needs to have a way to take user input to validate against the file contents
        //We are also establish the variables use in the loop and for the scanner to store its input

        Scanner scanner = new Scanner(System.in);
        String inputUser;
        String inputPass;
        int logInAttempts = 0;
        User isAuser = null;

        //The goal is to validate the user input while limiting the attempts to login

        while (logInAttempts < 5 && isAuser == null) {
            System.out.println("Please Enter Your Username (Hint: email address): ");
            inputUser = scanner.nextLine();
            System.out.println("Please Enter Your Password: ");
            inputPass = scanner.nextLine();

            //This is calling the UserService method we created to compare input to file contents

            isAuser = userService.validUser(users, inputUser, inputPass);

            //I established the return null value in the UserService method to stop automatic logins
            //If the input matches the file, then isAUser != null and a welcome message will print

            if (isAuser != null) {
                System.out.println("Welcome " +  isAuser.getName() + "!");

            //Otherwise, the null value stays and an error message is printed, then the loop continues and increments the counter

            } else {
                System.out.println("Invalid username or password. Please try again.");
                logInAttempts++;
            }
        }
        //Once the counter maxes out, then the loop breaks and this if statement begins, then the scanner closes

        if (isAuser == null) {
            System.out.println("Too many failed login attempts. Please try again later.");
        }

        scanner.close();
    }
}