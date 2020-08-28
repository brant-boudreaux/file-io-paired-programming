
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsApplication {
    static Input input = new Input();

    static List<String> names = Response.readFile(new ArrayList<>());

    public static void main(String[] args) {
        contactsMenu();
    }

    static Path p = Paths.get("src/data/contacts.txt");

    public static void contactsMenu() {
        System.out.println("Welcome to your contacts!");
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");
        //Add an edit method

        int selection = input.getInt();

        switch (selection) {
            case 1:
                viewContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                searchContacts();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                System.out.println("GoodBye!");
                break;
        }
    }

    public static void viewContacts() {
        System.out.println("| Name       |  Phone Number   |");
        System.out.println("----------------------------------------------");
        List<String> contactFile = Response.readFile(names);
        for (String line : contactFile) {
            String[] parts = line.split(", ");
                System.out.println("| " + parts[0] + " " + parts[1] + "   |");
        }
        returnToMenu();//return to the main menu
    }

    //ADD CONTACT
    public static void addContact(){
        System.out.println("What is the name of your new contact?");
        String name = input.getString().trim();
        List<String> contactFile = Response.readFile(names);
        for (String line : contactFile) {
            String[] parts = line.split(" ");
            if (name.equalsIgnoreCase(parts[0])) {
                System.out.println("There is already a contact by this name:");
                searchContact(name);
                System.out.println("\nWould you like to add another contact with this name? Y | N");
                boolean yes = input.yesNo();
                if (yes) {
                    addContact(name);
                    return;
                } else {
                    returnToMenu();
                }
            }
        }
        System.out.println("Please enter the phone number: (xxx)xxx-xxxx");
        String phoneNumber = input.getString().trim();
        //boolean validated = validatePhoneNumber(phoneNumber);

        //if (validated) {
            names.add(name + ", " + phoneNumber);
            Response.writeToFile(names);
            System.out.println("Contact added!");
            returnToMenu();
//        } else {
//
//            System.out.println("Invalid format: (xxx)xxx-xxxx");
//            addContact(name);
//
//        }
    }

    // When contact doesn't exist and user wants to add
    public static void addContact(String name){

        System.out.println("Please enter the phone number: (xxx)xxx-xxxx");
        String phoneNumber = input.getString().trim();
        //boolean validated = validatePhoneNumber(phoneNumber);

//        if (validated) {
            names.add(name + " " + phoneNumber);
            Response.writeToFile(names);
            System.out.println("Contact added!");
            returnToMenu();
//        } else {
//
//            System.out.println("Invalid format: (xxx)xxx-xxxx");
//            addContact(name);
//
//        }
    }


    //DELETE CONTACT
    public static void deleteContact() {
        System.out.println("Which contact would you like to delete?");
        String contact = input.getString();
        boolean contactFound = false;
        for (int i = 0; i < names.size(); i++){
            String[] contactParts = names.get(i).split(", ");
            if (contact.equalsIgnoreCase(contactParts[0])){
                names.remove(i);
                Response.writeToFile(names);
                System.out.println("" + contact + " has been deleted.");
                returnToMenu();
            }
        }
        if (!contactFound){
            System.out.println("Input does not match any of your contacts. Would you like to re-enter and try again? [y/N] ");
            boolean yes = input.yesNo();
            if (yes){
                deleteContact();
            } else {
                returnToMenu();
            }
        }
    }

    //SEARCH CONTACTS
    static public void searchContacts(){
        System.out.println("Search contact by name:");
        String contact = input.getString();
        List<String> contactFile = Response.readFile(names);
        boolean found = false;
        for (String line : contactFile) {
            String[] parts = line.split(", ");

            if (contact.equalsIgnoreCase(parts[0])) {
                System.out.println("Name: " + parts[0] + "\n" + "Number: " + parts[1]);
                found = true;
                returnToMenu();

            }
        }

        if (!found) {
            System.out.println("Contact not found!\nWould you like to add this contact? Y | N ");
            boolean add = input.yesNo();
            if (add) {
                addContact(contact);
            } else {
                returnToMenu();
            }
        }
    }

    //RETURN TO MENU
    public static void returnToMenu() {
        System.out.println("Return to main menu? [Yes/No]");
        boolean confirm = input.yesNo();

        if (confirm) {
            contactsMenu();
        } else {
            System.out.println("bye");
        }
    }
}
