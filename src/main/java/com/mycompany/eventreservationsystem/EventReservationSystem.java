/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eventreservationsystem;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab LEBOGANG NKOANE
 */
public class EventReservationSystem {

    // Method to check if the booking code is correct
    public static boolean checkBookingCode(String code) {
        // The code must contain an underscore and not exceed 12 characters
        return code.contains("_") && code.length() <= 12;
    }

    // Method to check if the password meets complexity requirements
    public static boolean checkPasswordComplexity(String password) {
        // At least 8 characters long, contains at least one capital letter,one number, and one special character
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        return hasUpperCase && hasNumber && hasSpecialChar;
    }

    // Method to make a reservation
    public static String makeReservation(String bookingCode, String password) {
        if (!checkBookingCode(bookingCode)) {
            return "Booking code is incorrectly formatted.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements.";
        }
        return "Reservation successfully made!";
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompting the user to input booking code
        System.out.print("Enter the booking code: ");
        String bookingCode = sc.next();

        // Prompting the user to input password
        System.out.print("Enter the password: ");
        String password = sc.next();

        // Calling the makeReservation method
        System.out.println(makeReservation(bookingCode, password));

        // Closing the scanner
        sc.close();
    }
}

