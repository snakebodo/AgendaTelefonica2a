import java.util.ArrayList;
import java.util.Scanner;

public class Phonebook {


    ArrayList<Contacts> MyListOfContacts;

    public Phonebook() {
        MyListOfContacts = new ArrayList<>();

    }

    void addContacts(Contacts x) {
        MyListOfContacts.add(x);
    }

    void showPhonebook() {
        System.out.println("        **Phonebook**       ");
        System.out.println("****************************");
        for (int i = 0; i < MyListOfContacts.size(); i++) {
            showContact(MyListOfContacts.get(i));
        }
        System.out.println("****************************");
    }
    /*void showPhonebook(){
        for(Contacts x : MyListOfContacts){
            showContact(x);
        }
    }*/

    void showContact(Contacts x) {
        System.out.println("        ---Contact---       ");
        System.out.println("----------------------------");
        System.out.println("Firstname: " + x.firtname);
        System.out.println("Lastname: " + x.lastname);
        System.out.println("Number: " + x.number);
        System.out.println("Email: " + x.email);
        System.out.println("----------------------------");

    }

    void readAndAddContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstname = scanner.nextLine();
        System.out.println("Enter lastname: ");
        String lastname = scanner.nextLine();
        System.out.println("Enter number: ");
        String number = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        Contacts contact = new Contacts(
                firstname,
                lastname,
                number,
                email);
        addContacts(contact);

    }

    void readAndSearch() {
        ArrayList<Contacts> listOfContactsFound = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nameToSearch = scanner.nextLine();
        int resultFound = 0;
        for (Contacts x : MyListOfContacts) {
            if (x.firtname.contains(nameToSearch)
                    || x.lastname.contains(nameToSearch)
                    || x.number.contains(nameToSearch)
                    || x.email.contains(nameToSearch)) {
                resultFound++;
                listOfContactsFound.add(x);
            }
        }

        if (resultFound == 0) {
            System.out.println("No contacts found");
        }
        if (resultFound == 1) {
            System.out.println("Only 1 contact found: ");
            System.out.println("****************************");
            for (int i = 0; i < listOfContactsFound.size(); i++) {
                showContact(listOfContactsFound.get(i));
            }
            System.out.println("****************************");
        } else if (resultFound > 1) {
            System.out.println("Multiple contacts found: ");
            System.out.println("****************************");
            for (int h = 0; h < listOfContactsFound.size(); h++) {
                showContact(listOfContactsFound.get(h));
            }
            System.out.println("****************************");
        }
    }


/*    void readAndSearch2() {
        ArrayList<Contacts> listOfContactsFound = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nameToSearch = scanner.nextLine();
        int resultFound = 0;
        for (Contacts x : MyListOfContacts) {
            if (x.firtname.contains(nameToSearch)
                    || x.lastname.contains(nameToSearch)
                    || x.number.contains(nameToSearch)
                    || x.email.contains(nameToSearch)) {
                resultFound++;
                listOfContactsFound.add(x);
            }
        }
    }*/
}

