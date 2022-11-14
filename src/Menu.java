import java.util.Scanner;
public class Menu {

    Phonebook phonebook = new Phonebook();

    void showMenu() {
        System.out.println(">>>>>> Phonebook menu <<<<<<");
        System.out.println("1 - Show phonebook");
        System.out.println("2 - Add contact");
        System.out.println("3 - Search contact");
        System.out.println("4 - Delete contact");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        if (userInput == 1) {
            phonebook.showPhonebook();
            showMenu();
        }
        if (userInput == 2) {
            System.out.println("Add contact details");
            phonebook.readAndAddContacts();
            showMenu();
        }
        if (userInput == 3) {
            System.out.println("Search name/number/email in the Phone Book");
            phonebook.searchAndShowAllContactsFound(scanner.next());
            showMenu();
        }
        if (userInput == 4) {
            System.out.println("Search name/number/email that you want to delete");
            phonebook.searchAndDeleteContact(scanner.next());
            showMenu();

        }
    }
}