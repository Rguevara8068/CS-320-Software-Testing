package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {
	
	//------------------------Test Valid Contact---------------------//
	
	 @Test
	    void testContact() {
	        Contact contact = new Contact("12345", "Lumie", "Acosta",
	                "5623357575", "280 Beck Court");

	        assertEquals("12345", contact.getContactId());
	        assertEquals("Lumie", contact.getFirstName());
	        assertEquals("Acosta", contact.getLastName());
	        assertEquals("5623357575", contact.getPhone());
	        assertEquals("280 Beck Court", contact.getAddress());
	    }
	 
	//--------------------Test Contact ID Requirements--------------------//

	// Tests that the contact ID cannot be more than 10 characters.
	@Test
	void testContactIdTooLong() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345678901", "Lumie", "Acosta",
	                "5623357575", "280 Beck Court");
	    });
	}

	// Tests that a contact ID cannot be null.
	@Test
	void testContactIdNull() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(null, "Lumie", "Acosta",
	                "5623357575", "280 Beck Court");
	    });
	}
	
	//--------------------Test First Name Requirements--------------------//

	// Tests the first name is not more than 10 characters.
	@Test
	void testFirstNameTooLong() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "LumieAcosta1", "Acosta",
	                "5623357575", "280 Beck Court");
	    });
	}

	// Tests that a first name cannot be null.
	@Test
	void testFirstNameNull() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", null, "Acosta",
	                "5623357575", "280 Beck Court");
	    });
	}
	
	//--------------------Test Last Name Requirements--------------------//

	// Tests that the last name has more than 10 characters.
	@Test
	void testLastNameTooLong() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "Lumie", "AcostaSmith",
	                "5623357575", "280 Beck Court");
	    });
	}

	// Tests that a last name cannot be null.
	@Test
	void testLastNameNull() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "Lumie", null,
	                "5623357575", "280 Beck Court");
	    });
	}
	
	//--------------------Test Phone Requirements--------------------//

	// Tests that the phone number does not have less than 10 digits.
	@Test
	void testPhoneTooShort() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "Lumie", "Acosta",
	                "562335757", "280 Beck Court");
	    });
	}

	// Tests that the phone number does not have more than 10 digits.
	@Test
	void testPhoneTooLong() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "Lumie", "Acosta",
	                "56233575755", "280 Beck Court");
	    });
	}

	// Tests that the phone number has only digits.
	@Test
	void testPhoneNotDigits() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "Lumie", "Acosta",
	                "562335757A", "280 Beck Court");
	    });
	}

	// Tests that the phone number cannot be null.
	@Test
	void testPhoneNull() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "Lumie", "Acosta",
	                null, "280 Beck Court");
	    });
	}
	
	//--------------------Test Address Requirements--------------------//

	// Tests that the address cannot be have more than 30 characters.
	@Test
	void testAddressTooLong() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "Lumie", "Acosta",
	                "5623357575", "1234567890123456789012345678901");
	    });
	}

	// Tests that the address cannot be null.
	@Test
	void testAddressNull() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "Lumie", "Acosta",
	                "5623357575", null);
	    });
	}
}