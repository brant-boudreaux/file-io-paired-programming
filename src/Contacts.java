

import java.util.ArrayList;
import java.util.List;

public class Contacts{
    private String name;
    private String phone;
    private String email;

    //CONTACTS CONSTRUCTOR
    public Contacts(String name, String phone, String email){this.name = name; this.phone = phone, this.email = email}

    //NAME SETTER/GETTER
    public String getName(){return name;}
    public void setName(){this.name = name;}

    //PHONE SETTER/GETTER
    public String getPhone(){return phone;}
    public void setPhone(){this.phone = phone;}

    //EMAIL SETTER/GETTER
    public String getEmail(){return email;}
    public void setEmail(){this.email = email;}


     //TAKES IN LIST OF CONTACTS OBJECTS AND RETURNS A LIST OF NAME STRINGS
    public static List<String> contactsToNameStrings(List<Contacts> contacts) {
        List<String> names = new ArrayList<>();
        for (Contacts contact : contacts) {
            names.add(contact.getName());
        }
        return names;
    }


     //TAKES IN LIST OF NAME STRINGS AND RETURNS LIST OF CONTACTS OBJECTS
    public static List<Contacts> nameStringsToContacts(List<String> names) {
        List<Instructor> contacts = new ArrayList<>();
        for (String name : names) {
            instructors.add(new Contacts(name));
        }
        return instructors;
    }
}
