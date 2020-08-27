
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

        int selection = input.getInt(1, 5);

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
        System.out.println("--------------------------------");
        List<String> contactFile = Response.names;
        for (String line : contactFile) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                System.out.printf("| %-11s| ", parts[0]);
                System.out.println(parts[1] + "   |");
            }
        }
        returnToMenu();//return to the main menu
    }

    //ADD CONTACT
    public static void addContact() {

    }

    //DELETE CONTACT
    public static void deleteContact() {

    }

    //SEARCH CONTACTS
    public static void searchContacts() {

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
