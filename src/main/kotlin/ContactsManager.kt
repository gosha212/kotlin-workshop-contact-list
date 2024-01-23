package org.example

interface ContactsManager {

    fun addContact(name: String, phone: String, email: String)

    fun removeContact(contact: Contact)

    fun getAllContacts(): List<Contact>

    fun getContactsByName(name: String): List<Contact>

    fun getContactsByFirstLetter(firstLetter: Char): List<Contact>

    fun isContactExists(contact: Contact): Boolean

}