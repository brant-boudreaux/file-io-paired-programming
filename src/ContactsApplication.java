
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsApplication{

    public static void main(String[] args) {
        List<Contacts> contacts;
        List<String> names = new ArrayList<>();

        Path p = Paths.get("src/data/contacts.txt");

        //READ FILE
        try {
            names = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        contacts = Contacts.nameStringsToContacts(names);


        /**
         1. View contacts.
         2. Add a new contact.
         3. Search a contact by name.
         4. Delete an existing contact.
         5. Exit.
         Enter an option (1, 2, 3, 4 or 5):
         */

        //WRITE FILE
        names = Contacts.contactsToNameStrings(contacts);
        try {
            Files.write(p, names);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
