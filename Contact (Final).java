//Author Name: Jasmine Garcia
//Original Publishing Date: 27 July 2025
//Updated on: 5 April 2026
//Course ID: CS-320
//Description: This file defines the Contact class and validates the contact details.

package contact;

public class Contact {

    // Unique identifier (cannot be changed once set)
    private final String contactId;

    // Contact fields
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    // Initializes a Contact object and validates all input fields
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        // Validate contact ID (must not be null and max length of 10)
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        this.contactId = contactId;

        // Use setter methods to apply validation logic for other fields
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // Getter for contact ID (no setter because ID should not change)
    public String getContactId() {
        return contactId;
    }

    // Standard getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods include validation to enforce constraints

    public void setFirstName(String firstName) {

        // Must not be null and max length of 10
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        // Must not be null and max length of 10
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        this.lastName = lastName;
    }

    public void setPhone(String phone) {

        // Must be exactly 10 digits and only numeric
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }

        this.phone = phone;
    }

    public void setAddress(String address) {

        // Must not be null and max length of 30
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.address = address;
    }
}