import org.example.Contact
import org.example.ContactsManager
import org.example.ContactsManagerImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ContactsManagerTest {


    private lateinit var contactsManager: ContactsManager
    private lateinit var contacts: List<Contact>

    @BeforeEach
    fun setUp() {
        contactsManager = ContactsManagerImpl() // Replace with actual implementation class name

        contacts = listOf(
            Contact("John Doe", "1234567890", "john@example.com"),
            Contact("Jane Smith", "0987654321", "jane@example.com"),
            Contact("Alice Johnson", "5556667777", "alice@example.com"),
            Contact("Bob Brown", "2223334444", "bob@example.com"),
            // ... other contacts as previously defined
        )

        // Adding initial contacts
        contacts.forEach { contact ->
            contactsManager.addContact(contact.name, contact.phone, contact.email)
        }
    }

    @Test
    fun addContact() {
        val newContact = Contact("Ivy Blue", "1231231234", "ivy@example.com")
        contactsManager.addContact(newContact.name, newContact.phone, newContact.email)

        val retrievedContact = contactsManager.getContactsByName("Ivy Blue")
        assertTrue(retrievedContact.contains(newContact))
    }

    @Test
    fun removeContact() {
        val contactToRemove = contacts[1] // For example, removing "Jane Smith"
        contactsManager.removeContact(contactToRemove)

        assertFalse(contactsManager.isContactExists(contactToRemove))
    }

    @Test
    fun getAllContacts() {
        val initialCount = contacts.size
        val newContact = Contact("Jack Red", "9879879870", "jack@example.com")
        contactsManager.addContact(newContact.name, newContact.phone, newContact.email)

        val contacts = contactsManager.getAllContacts()
        assertEquals(initialCount + 1, contacts.size)
    }


    @Test
    fun getContactsByName() {
        val expectedContact = contacts.first { it.name.startsWith("John Doe") }
        val retrievedContacts = contactsManager.getContactsByName("John Doe")

        assertTrue(retrievedContacts.contains(expectedContact))
        assertTrue(retrievedContacts.all { it.name.startsWith("John Doe") })
    }

    @Test
    fun getContactsByFirstLetter() {
        val expectedContacts = contacts.filter { it.name.startsWith("A") }
        val retrievedContacts = contactsManager.getContactsByFirstLetter('A')

        assertTrue(retrievedContacts.containsAll(expectedContacts))
        assertTrue(retrievedContacts.all { it.name.startsWith("A") })
    }

    @Test
    fun isContactExists() {
        val existingContact = contacts[0] // For example, "John Doe"
        assertTrue(contactsManager.isContactExists(existingContact))

        val nonExistingContact = Contact("Nonexistent Person", "0000000000", "noone@example.com")
        assertFalse(contactsManager.isContactExists(nonExistingContact))
    }
}