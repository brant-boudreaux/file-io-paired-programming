
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsApplication {
    static Input input = new Input();

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
        System.out.println("| Name       |  Phone Number   |  Email       |");
        System.out.println("----------------------------------------------");
        List<String> contactFile = Response.readFile(p);
        for (String line : contactFile) {
            String[] parts = line.split(",");
                System.out.println("| " + parts[0] + "   |");
        }
        returnToMenu();//return to the main menu
    }

    //ADD CONTACT
    public static void addContact(){
        System.out.println("What is the name of your new contact?");
        String name = input.getString().trim();
        List<String> contactFile = Response.readFile(p);

        for (String line : contactFile) {
            String[] parts = line.split(" ");

            //if (name.equalsIgnoreCase(parts[0])) {
                //System.out.println("There is already a contact by this name:");
                //searchContact(name);
                //System.out.println("\nWould you like to add another contact with this name? Y | N");
                //boolean yes = input.yesNo();
                //if (yes) {
                    addContact(name);
                    return;
              //  } else {
              //      returnToMenu();
               // }
            //}
        }

        System.out.println("Please enter the phone number: (xxx)xxx-xxxx");
        String phoneNumber = input.getString().trim();

        //boolean validated = validatePhoneNumber(phoneNumber);

        //if (validated) {

            Response.names.add(name + " " + phoneNumber);
            Response.writeToFile();
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

            Response.names.add(name + " " + phoneNumber);
            Response.writeToFile();
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
        List<String> contactFile = Response.readFile(p);

    }

    //SEARCH CONTACTS
    static public void searchContacts(){
        System.out.println("Search contact by name:");
        String contact = input.getString();
        List<String> contactFile = Response.readFile(p);
        boolean found = false;
        for (String line : contactFile) {
            String[] parts = line.split(",");

            if (contact.equalsIgnoreCase(parts[0])) {
                System.out.println("Name: " + parts[0] + "\n" + "Number: " + parts[0]);
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

    public static void searchContacts(String name) {
        List<String> searchFile = Response.readFile(p);

        for (String contact : searchFile){
            String[] parts = contact.split(",");
            if (name.equalsIgnoreCase(parts[0])){
                System.out.println("Name: " + parts[0] + "\n" + "Number: " + parts[0]);
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
