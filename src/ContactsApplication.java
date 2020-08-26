
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsApplication{
    public static void main(String[] args) {
    Input input = new Input();
    List<Contact> fields;
    List<String> contacts;

    Path p = Paths.get("src/data/contacts.txt");

    try {
        contacts = Files.readAllLines(p);
    } catch (IOException e) {
        e.printStackTrace();
    }

    fields = Contacts.nameStringsToFields(contacts);

    contacts = Contacts.FieldsToNameStrings(fields);

    try {
        Files.write(p, contacts);
    } catch (IOException e){
        e.printStackTrace();
    }

    }
}
