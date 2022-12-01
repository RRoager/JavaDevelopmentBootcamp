package org.example.contacts.models;

import java.util.ArrayList;
import java.util.Optional;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public Contact getContacts(int index) {
        return new Contact(contacts.get(index));
    }

    public void setContacts(int index, Contact contact) {
        contacts.set(index, new Contact(contact));
    }

    public void addContact(Contact contact) {
        contacts.add(new Contact(contact));
    }

    public void removeContact(String contactName) {
        if (contacts.isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }
        contacts.removeIf(c -> c.getName().equals(contactName));
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Contact contact : contacts){
            temp.append(contact.toString());
            temp.append("\n");
        }

        return temp.toString();
    }
}
