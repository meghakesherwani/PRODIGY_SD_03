package Task3;

import java.util.*;
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class ContactManagementSystem {

    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void addContact() {
        System.out.println("\nAdding Contact");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        System.out.println("\nContacts List");
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println((i + 1) + ". " + contact.getName() + " | " + contact.getPhoneNumber() + " | " + contact.getEmail());
            }
        }
    }

    private static void editContact() {
        System.out.println("\nEditing Contact");
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        viewContacts();
        System.out.print("Enter the index of the contact you want to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Contact contact = contacts.get(index - 1);
        System.out.print("Enter new name (leave empty to keep unchanged): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            contact.setName(newName);
        }
        System.out.print("Enter new phone number (leave empty to keep unchanged): ");
        String newPhoneNumber = scanner.nextLine();
        if (!newPhoneNumber.isEmpty()) {
            contact.setPhoneNumber(newPhoneNumber);
        }
        System.out.print("Enter new email address (leave empty to keep unchanged): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            contact.setEmail(newEmail);
        }
        System.out.println("Contact edited successfully.");
    }

    private static void deleteContact() {
        System.out.println("\nDeleting Contact");
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        viewContacts();
        System.out.print("Enter the index of the contact you want to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index.");
            return;
        }

        contacts.remove(index - 1);
        System.out.println("Contact deleted successfully.");
    }
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nContact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

    }
}
