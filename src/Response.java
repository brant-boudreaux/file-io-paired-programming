
public class Response {
    //EDIT FILES - move to a separate class?
//    public static int userInput(){
//        int userInput = input.getInt(1, 5);
//        return userInput;
//    }

    public static void contactsMenu(){
        Input input = new Input();

        System.out.println("Welcome to your contacts!");
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");

        int selection = input.getInt(1, 5);

        switch(selection) {
            case 1:
                viewContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                System.out.println("GoodBye!");
                break;
        }

}
