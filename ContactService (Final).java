//Author Name: Jasmine Garcia
//Original Publishing Date: 27 July 2025
//Updated on: 5 April 2026
//Course ID: CS-320 
//Description: This file defines the ContactService class (manager of Contact objects)

package contact;

import java.util.HashMap;

public class ContactService {

    //Temporary in memory storage using HashMap
    // In a future enhancement, this would be replacd with a database
    // HashMap to store contacts using contactId as the key
    private HashMap<String, Contact> contacts = new HashMap<>();

    // Centralized validation method (ENHANCEMENT)
    // This method ensures that all validation checks are handled in one place,
    // improving maintainability and reducing repeated logic.
    private void validateContact(Contact contact) {

        // Check if contact object is null
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        // Validate contact ID (must not be null and must be <= 10 characters)
        if (contact.getContactId() == null || contact.getContactId().length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID.");
        }

        // Ensure contact ID is unique (no duplicates allowed)
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
    }

    // Adds a new contact to the system
    // Now uses the centralized validation method before adding
    public void addContact(Contact contact) {

        // Call validation method before storing the contact
        validateContact(contact);

        // Add validated contact to HashMap
        contacts.put(contact.getContactId(), contact);
    }

    /*
     * Deletes a contact based on the contact ID
     */
    public void deleteContact(String contactId) {

        // Check if contact exists before attempting removal
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }

        // Remove contact from storage
        contacts.remove(contactId);
    }

    // Updates the first name of a contact
    // Uses helper method to retrieve contact safely
    public void updateFirstName(String contactId, String newFirstName) {

        Contact contact = getContactById(contactId);

        // Delegate validation to Contact class setter
        contact.setFirstName(newFirstName);
    }

    // Updates the last name of a contact
    public void updateLastName(String contactId, String newLastName) {

        Contact contact = getContactById(contactId);
        contact.setLastName(newLastName);
    }

    // Updates the phone number of a contact
    public void updatePhone(String contactId, String newPhone) {

        Contact contact = getContactById(contactId);
        contact.setPhone(newPhone);
    }

    // Updates the address of a contact
    public void updateAddress(String contactId, String newAddress) {

        Contact contact = getContactById(contactId);
        contact.setAddress(newAddress);
    }

    // Helper method to safely retrieve a contact by ID
    // Prevents null access and keeps code cleaner
    private Contact getContactById(String contactId) {

        Contact contact = contacts.get(contactId);

        // Throw error if contact does not exist
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }

        return contact;
    }

    // Search contacts by last name
    public Contact searchByLastName(String lastName) {

        for (Contact contact : contacts.values()) {

            if (contact.getLastName().equalsIgnoreCase(lastName)) {
                return contact;
            }
        }
        
        throw new IllegalArgumentException("No contact found with last name: " + lastName); 
    }
}