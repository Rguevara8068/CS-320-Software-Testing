package contact;
import java.util.ArrayList;
public class ContactService {

	 //----------------------------- Contact List ----------------------//

    // Stores contacts in memory without using a database.
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

  //----------- Add Contact -----------//

 // Adds a new contact if the contact ID is unique.
 public void addContact(Contact contact) {

     // Checks any existing contacts for the same ID.
     for (Contact existingContact : contactList) {
         if (existingContact.getContactId().equals(contact.getContactId())) {
             throw new IllegalArgumentException("Contact ID already exists");
         }
     }

     // Adds the contact after confirming the ID is unique.
     contactList.add(contact);
 }
 
//-------------------- Delete Contact --------------------//

//Deletes a contact using the contact ID.
public void deleteContact(String contactId) {

  // Removes the contact if the ID matches.
  boolean removed = contactList.removeIf(
          contact -> contact.getContactId().equals(contactId));

  // Throws an exception if the contact ID is not found.
  if (!removed) {
      throw new IllegalArgumentException("Contact ID not found");
  }
}

//-------------------- Update Contact --------------------//

//Updates a contact's information using the contact ID.
public void updateContact(String contactId, String firstName,
     String lastName, String phone, String address) {

 // Looks for the contact with the matching ID.
 for (Contact contact : contactList) {
     if (contact.getContactId().equals(contactId)) {

         // Updates the fields that are allowed to change.
         contact.setFirstName(firstName);
         contact.setLastName(lastName);
         contact.setPhone(phone);
         contact.setAddress(address);
         return;
     }
 }

 // Throws an exception if the contact ID is not found.
 throw new IllegalArgumentException("Contact ID not found");
 
  }
// End.
}
