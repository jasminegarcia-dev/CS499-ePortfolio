//Author Name: Jasmine Garcia
//Original Publishing Date: 27 July 2025
//Updated on: 5 April 2026
//Course ID: CS-320
//Description: This is the tests for the contact service - ContactServiceTest.

package contact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    // Test: Adding a contact to the system
    @Test
    @DisplayName("Should add contact to service list")
    void addContactToList() {

        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Luna", "Lovegood", "3364162251", "Ravenclaw Tower");

        service.addContact(contact);

        // If no exception occurs, test passes
    }

    // Test: Prevent duplicate contact IDs
    @Test
    @DisplayName("Should throw exception for duplicate contact ID")
    void duplicateIdFails() {

        ContactService service = new ContactService();

        Contact c1 = new Contact("1", "Harry", "Potter", "4193410221", "Privet Drive");
        Contact c2 = new Contact("1", "Draco", "Malfoy", "2105055755", "Slytherin House");

        service.addContact(c1);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    // Test: Deleting an existing contact
    @Test
    @DisplayName("Should delete contact by ID")
    void deleteExistingContact() {

        ContactService service = new ContactService();
        Contact contact = new Contact("9", "Hermione", "Granger", "4193417625", "Hogwarts Study");

        service.addContact(contact);
        service.deleteContact("9");
    }

    // Test: Attempt to delete non-existent contact
    @Test
    @DisplayName("Should throw error when deleting contact that doesn't exist")
    void deleteInvalidIdShouldThrowError() {

        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("404"));
    }

    // Test: Updating first name
    @Test
    @DisplayName("Should update contact first name")
    void shouldUpdateContactFirstName() {

        ContactService service = new ContactService();
        Contact contact = new Contact("3", "Ron", "Weasley", "5672076345", "The Burrow");

        service.addContact(contact);
        service.updateFirstName("3", "Ronald");

        assertEquals("Ronald", contact.getFirstName());
    }

    // Test: Invalid phone update should fail
    @Test
    @DisplayName("Should fail when setting bad phone number")
    void setInvalidPhoneNumberManuallyFails() {

        ContactService service = new ContactService();
        Contact contact = new Contact("7", "Ginny", "Weasley", "9672075524", "Gryffindor House");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("7", "123");
        });
    }

    // Test search contact by last name
    @Test
    @DisplayName("Should find contact by last name")    
    void searchContactByLastName() {

        ContactService service = new ContactService();
        Contact contact = new Contact("5", "Albus", "Dumbledore", "5551234567", "Hogwarts Headmaster's Office");

        service.addContact(contact);

        // Search for contact by last name
        Contact found = service.searchByLastName("Dumbledore");

        assertNotNull(found);
        assertEquals("5", found.getContactId());
    }
}