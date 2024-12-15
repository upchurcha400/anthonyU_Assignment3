package com.codercampus.userLoginService;

import java.util.Scanner;

public class UserLoginApplication {


    public static void main(String[] args) {
        UserService userService = new UserService();
        User[] users = userService.readFile("data.txt");


        Scanner scanner = new Scanner(System.in);
        String inputUser;
        String inputPass;
        int logInAttempts = 0;
        User isAuser = null;


        while (logInAttempts < 5 && isAuser == null) {
            System.out.println("Please Enter Your Username (Hint: email address): ");
            inputUser = scanner.nextLine();
            System.out.println("Please Enter Your Password: ");
            inputPass = scanner.nextLine();


            isAuser = userService.validUser(users, inputUser.toLowerCase(), inputPass);


            isAuser = userService.validUser(users, inputUser, inputPass);


            if (isAuser != null) {
                System.out.println("Welcome " + isAuser.getName() + "!");


            } else {
                System.out.println("Invalid username or password. Please try again.");
                logInAttempts++;
            }
        }


        if (isAuser == null) {
            System.out.println("Too many failed login attempts. Please try again later.");
        }

        scanner.close();
    }
}