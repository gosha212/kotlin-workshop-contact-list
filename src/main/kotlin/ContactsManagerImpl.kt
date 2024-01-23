package org.example

class ContactsManagerImpl : ContactsManager {

    private val contacts = mutableListOf<Contact>()

    override fun addContact(name: String, phone: String, email: String) {
        contacts.add(Contact(name, phone, email))
    }

    override fun removeContact(contact: Contact) {
        contacts.remove(contact)
    }

    override fun getAllContacts(): List<Contact> {
        return contacts
    }

    override fun getContactsByName(name: String): List<Contact> {
        return contacts.filter { it.name == name }
    }

    override fun getContactsByFirstLetter(firstLetter: Char): List<Contact> {
        return contacts.filter { it.name.startsWith(firstLetter) }
    }

    override fun isContactExists(contact: Contact): Boolean {
        return contacts.contains(contact)
    }
}