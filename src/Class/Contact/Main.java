package Class.Contact;

import java.util.Scanner;

public class Main {
    private static Scanner sacnner = new Scanner(System.in);
    private static ContactList contactList = new ContactList("0967948934");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit) {
            System.out.println("\nEnter action: (6 to show avadlable actiosj");
            int action = sacnner.nextInt();
            sacnner.nextLine();
            switch  (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    contactList.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }
    public static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = sacnner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = sacnner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(contactList.addNewContact(newContact)) {
            System.out.println("New Contact added: name = " + name +
                    ", phone = " + phone);
        }else {
            System.out.println("Cannot add, " + name + "already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = sacnner.nextLine();
        Contact existingContactRecord = contactList.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName = sacnner.nextLine();
        System.out.print("Emter new contact phone number: ");
        String newNumber = sacnner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(contactList.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfutly updated record ");
        }else {
            System.out.println("Error updating record");
        }
    }
    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = sacnner.nextLine();
        Contact existingContactRecord = contactList.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        if(contactList.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = sacnner.nextLine();
        Contact existingContactRecord = contactList.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name : " + existingContactRecord.getName() +
                "phone number is"  + existingContactRecord.getPhoneNumber());
    }
    private static void startPhone() {
        System.out.println("Starting phone..");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0  - to shutdown\n"
                + "1  - to print contacts\n"
                + "2  - to add a new contact\n"
                + "3  - to update existing an existing contact\n"
                + "4  - to remove an existing contact\n"
                + "5  - query if an existing contact exists\n"
                + "6  - to print a list of available actions\n");
        System.out.println("Choose your action: ");
    }
}
