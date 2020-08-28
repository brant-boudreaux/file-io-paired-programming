import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;

public class Response {
    static List<String> contacts;


    static Path p = Paths.get("src/data/contacts.txt");

    //READ FILE
    public static List<String> readFile() {
        try {
            names = Files.readAllLines(Response.p);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        contacts = Contacts.nameStringsToContacts(names);
        return names;
    }

    //WRITE FILE - ADD, EDIT AND DELETE
    public static void writeToFile() {
        try {
            Files.write(p, names);
        } catch (IOException e) {
            e.printStackTrace();
        }
        names = Contacts.contactsToNameStrings(contacts);
    }
}
