/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.eventreservationsystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class EventReservationSystemTest {
    
    public EventReservationSystemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // Test cases for checkBookingCode method
    @Test
    public void testValidBookingCode() {
        assertTrue(EventReservationSystem.checkBookingCode("Event_123"), "Booking code should be valid.");
    }

    @Test
    public void testInvalidBookingCode_NoUnderscore() {
        assertFalse(EventReservationSystem.checkBookingCode("Event123"), "Booking code without underscore should be invalid.");
    }

    @Test
    public void testInvalidBookingCode_ExceedsLength() {
        assertFalse(EventReservationSystem.checkBookingCode("Event_12345678"), "Booking code exceeding 12 characters should be invalid.");
    }

    // Test cases for checkPasswordComplexity method
    @Test
    public void testValidPassword() {
        assertTrue(EventReservationSystem.checkPasswordComplexity("Password1@"), "Password should meet complexity requirements.");
    }

    @Test
    public void testInvalidPassword_ShortLength() {
        assertFalse(EventReservationSystem.checkPasswordComplexity("Pass1@"), "Password shorter than 8 characters should be invalid.");
    }

    @Test
    public void testInvalidPassword_NoUppercase() {
        assertFalse(EventReservationSystem.checkPasswordComplexity("password1@"), "Password without uppercase letter should be invalid.");
    }

    @Test
    public void testInvalidPassword_NoNumber() {
        assertFalse(EventReservationSystem.checkPasswordComplexity("Password!"), "Password without a number should be invalid.");
    }

    @Test
    public void testInvalidPassword_NoSpecialCharacter() {
        assertFalse(EventReservationSystem.checkPasswordComplexity("Password1"), "Password without a special character should be invalid.");
    }

    // Test cases for makeReservation method
    @Test
    public void testMakeReservation_Success() {
        String result = EventReservationSystem.makeReservation("Event_123", "Password1@");
        assertEquals("Reservation successfully made!", result, "Should return successful reservation message.");
    }

    @Test
    public void testMakeReservation_InvalidBookingCode() {
        String result = EventReservationSystem.makeReservation("Event123", "Password1@");
        assertEquals("Booking code is incorrectly formatted.", result, "Should return booking code error message.");
    }

    @Test
    public void testMakeReservation_InvalidPassword() {
        String result = EventReservationSystem.makeReservation("Event_123", "password");
        assertEquals("Password does not meet the complexity requirements.", result, "Should return password complexity error message.");
    }
}

    

