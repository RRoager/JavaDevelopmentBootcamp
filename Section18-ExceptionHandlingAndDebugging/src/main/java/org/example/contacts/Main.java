package org.example.contacts;

import org.example.contacts.models.Contact;
import org.example.contacts.models.ContactManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static ContactManager cm = new ContactManager();
    public static void main(String[] args) {
        try {
            loadContacts("contacts.txt");
            System.out.println("CONTACTS LOADED\n\n");
            System.out.println(cm);
            manageContacts();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nProcess Complete.");
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
    public static void manageContacts() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit");
            String response = sc.nextLine();
            if (response.equals("a")) {
                System.out.print("\tName: ");
                String name = sc.nextLine();
                System.out.print("\tPhone Number: ");
                String phoneNumber = sc.nextLine();
                System.out.print("\tBirth Date: ");
                String birthDate = sc.nextLine();
                if (name.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5) {
                    System.out.println("\nThe input you provided is not valid. Registration failed.");
                } else {
                    try {
                        cm.addContact(new Contact(name, phoneNumber, birthDate));
                    } finally { //contacts will re-print regardless of the outcome...
                        System.out.println("\n\nUPDATED CONTACTS\n\n" + cm);
                    }
                }
            } else if (response.equals("b")) {
                System.out.println("\nWho would you like to remove?");
                cm.removeContact(sc.nextLine());
                System.out.println("\n\nUPDATED CONTACTS\n\n" + cm);

            } else {
                break;
            }
        }
        sc.close();
    }



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
    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scFile = new Scanner(fis);
        while (scFile.hasNextLine()) {
            Contact contact = new Contact(scFile.next(), scFile.next(), scFile.next());
            cm.addContact(contact);
        }
        scFile.close();
    }

}
