//Author Name: Jasmine Garcia
//Original Publishing Date: 27 July 2025
//Updated on: 5 April 2026
//Course ID: CS-320
//Description: This file has the tests for the Contact class.

package contact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test: Valid contact creation
    // Ensures all fields are correctly assigned when valid input is used
    @Test
    @DisplayName("Should create contact with valid data")
    void createValidContact() {
        Contact contact = new Contact("1001", "Harry", "Potter", "1234567890", "4 Privet Drive");

        assertEquals("1001", contact.getContactId());
        assertEquals("Harry", contact.getFirstName());
        assertEquals("Potter", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("4 Privet Drive", contact.getAddress());
    }

    // Test: Null contact ID should throw exception
    @Test
    @DisplayName("Should throw error if contact ID is null")
    void nullContactIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Hermione", "Granger", "1112223333", "Hogwarts Library");
        });
    }

    // Test: Invalid phone number (not 10 digits)
    @Test
    @DisplayName("Should throw error if phone is not exactly 10 digits")
    void invalidPhoneFailsValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("202", "Ron", "Weasley", "123", "The Burrow");
        });
    }

    // Test: First name exceeds allowed length
    @Test
    @DisplayName("Should throw error for too-long first name")
    void firstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("301", "BellatrixLestrange", "Black", "1234567890", "Azkaban");
        });
    }

    // Test: Updating address successfully
    @Test
    @DisplayName("Should update address successfully")
    void updateAddressSuccessfully() {
        Contact contact = new Contact("404", "Sirius", "Black", "0987654321", "12 Grimmauld Place");

        contact.setAddress("Headquarters of the Order");

        assertEquals("Headquarters of the Order", contact.getAddress());
    }

    // Test: Address exceeds allowed length
    @Test
    @DisplayName("Should throw error when address exceeds 30 characters")
    void tooLongAddressFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("505", "Neville", "Longbottom", "1119998888",
                    "A very, very, very long address string");
        });
    }
}