package org.example.contacts;

import org.example.contacts.models.Contact;
import org.example.contacts.models.ContactManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Contact contact1 = new Contact("Rasmus", "1987-05-10", "+45 42765614");
            Contact contact2 = new Contact("Bent", "1995-10-15", "+45 45896258");
            Contact contact3 = new Contact("Lone", "1950-12-05", "+45 41358796");

            ContactManager cm = new ContactManager();

            cm.addContact(contact1);
            cm.addContact(contact2);
            cm.addContact(contact3);

            System.out.println(cm);

            cm.removeContact("Bent");

            System.out.println(cm);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Process Complete");
        }
    }

    /**
     * Name: manageContacts
     *
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) add b) remove a contact c) exit.
     *   •        case a: ask for the name, phone number and birthDate.
     *   •        case b: ask who they'd like to remove.
     *   •        case c: break the loop.
     *   • 3. close Scanner.
     */



    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads contacts from <fileName>;
     *   • 2. From the manager object, it adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     */

}
