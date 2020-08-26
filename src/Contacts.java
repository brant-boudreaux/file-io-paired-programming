

import java.util.ArrayList;

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

    /**
     * This method takes in a list of Instructor objects and returns a list of name strings
     * @param instructors is a list of Instructor objects
     * @return a list of String objects based off of the names of the passed in list of Instructor objects
     */
    public static List<String> contactsToNameStrings(List<Contacts> contacts) {
        List<String> names = new ArrayList<>();
        for (Contacts contact : contacts) {
            names.add(contact.getName());
        }
        return names;
    }

    /**
     * This method takes in a list of name strings and returns a list of Instructor objects
     * @param names is a list of name strings
     * @return a list of Instructor objects with matching names to the input list of name strings
     */
    public static List<Instructor> nameStringsToInstructors(List<String> names) {
        List<Instructor> instructors = new ArrayList<>();
        for (String name : names) {
            instructors.add(new Instructor(name));
        }
        return instructors;
    }
}
