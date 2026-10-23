package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

    //-------------------- Test Add Contact --------------------//

    // Tests that a contact can be added to the service.
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Lumie", "Acosta",
                "5623357575", "280 Beck Court");

        service.addContact(contact);
    }
    
  //-------------------- Test Unique Contact ID --------------------//

 // Tests that two contacts do not have the same contact ID.
 @Test
 void testDuplicateContactId() {
     ContactService service = new ContactService();

     Contact contact1 = new Contact("12345", "Lumie", "Acosta",
             "5623357575", "280 Beck Court");

     Contact contact2 = new Contact("12345", "Roxy", "May",
             "5551234567", "123 South Street");

     service.addContact(contact1);

     assertThrows(IllegalArgumentException.class, () -> {
         service.addContact(contact2);
     });
 }
 
//-------------------- Test Delete Contact --------------------//

//Tests that a contact can be deleted using the contact ID.
@Test
void testDeleteContact() {
  ContactService service = new ContactService();
  Contact contact = new Contact("12345", "Lumie", "Acosta",
          "5623357575", "280 Beck Court");

  service.addContact(contact);
  service.deleteContact("12345");

  // Trying to delete it again should fail because it was already removed.
  assertThrows(IllegalArgumentException.class, () -> {
      service.deleteContact("12345");
  });
}

//Tests that an ID that does not exist cannot be deleted.
@Test
void testDeleteContactNotFound() {
  ContactService service = new ContactService();

  assertThrows(IllegalArgumentException.class, () -> {
      service.deleteContact("99999");
  });
}

//-------------------- Test Update Contact --------------------//

//Tests that a contact's information can be updated using the ID.
@Test
void testUpdateContact() {
 ContactService service = new ContactService();
 Contact contact = new Contact("12345", "Lumie", "Acosta",
         "5623357575", "280 Beck Court");

 service.addContact(contact);

 service.updateContact("12345", "Roxy", "May",
         "5551234567", "123 South Street");

 assertEquals("Roxy", contact.getFirstName());
 assertEquals("May", contact.getLastName());
 assertEquals("5551234567", contact.getPhone());
 assertEquals("123 South Street", contact.getAddress());

 // Confirms that the contact ID did not change.
 assertEquals("12345", contact.getContactId());
}

//Tests that if a contact does not exist cannot be updated.
@Test
void testUpdateContactNotFound() {
 ContactService service = new ContactService();

 assertThrows(IllegalArgumentException.class, () -> {
     service.updateContact("99999", "Roxy", "May",
             "5551234567", "123 South Street");
 });
}

}
