package contact;

public class Contact {
	// Stores the required information for each contact and contactId is final because it cannot be changed after creation.
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
  //------------------------------ Constructor---------------- -----------//
    
 // Creates a new contact and checks that all information
    public Contact(String contactId, String firstName, String lastName,
            String phone, String address) {
    	
    	// Contact ID is required and cannot be more than 10 characters.
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        
        // First name is required and cannot be more than 10 characters
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        
        // Last name is required and cannot be more than 10 characters.
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        
     // Phone number is required and must contain exactly 10 digits.
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        
     // Address is required and cannot be more than 30 characters.
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

     // Saves the validated information to the contact object.
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    
  //------------------------------ Getters---------------- -----------//
    
 // Returns the contact ID.
    public String getContactId() {
        return contactId;
    }

    // Returns the first name.
    public String getFirstName() {
        return firstName;
    }

    // Returns the last name.
    public String getLastName() {
        return lastName;
    }

    // Returns the phone number.
    public String getPhone() {
        return phone;
    }

    // Returns the address.
    public String getAddress() {
        return address;
    }
    
  //------------------------------ Setters---------------- -----------//

 // Updates the first name after checking requirements.
 public void setFirstName(String firstName) {
     if (firstName == null || firstName.length() > 10) {
         throw new IllegalArgumentException("Invalid first name");
     }
     this.firstName = firstName;
 }

 // Updates the last name after checking requirements.
 public void setLastName(String lastName) {
     if (lastName == null || lastName.length() > 10) {
         throw new IllegalArgumentException("Invalid last name");
     }
     this.lastName = lastName;
 }

 // Updates the phone number and makes sure it is 10 digits exact.
 public void setPhone(String phone) {
     if (phone == null || !phone.matches("\\d{10}")) {
         throw new IllegalArgumentException("Invalid phone number");
     }
     this.phone = phone;
 }

 // Updates the address after checking requirements.
 public void setAddress(String address) {
     if (address == null || address.length() > 30) {
         throw new IllegalArgumentException("Invalid address");
     }
     this.address = address;
 }

 // End
 }
