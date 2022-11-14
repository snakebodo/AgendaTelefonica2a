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
        System.out.println("         Phonebook        ");
        System.out.println("****************************");
        int a = 0;
        for (int i = 0; i < MyListOfContacts.size(); i++) {
            a++;
            if (a >= 1) {
                System.out.println("  Position: " + a);
                showContact(MyListOfContacts.get(i));
            }
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

    void searchAndShowAllContactsFound(String nameToSearch) {
        ArrayList<Contacts> listOfContactsFound = new ArrayList<>();
        int resulOfContactsFound = 0;
        for (Contacts x : MyListOfContacts) {
            if (x.firtname.contains(nameToSearch) || x.lastname.contains(nameToSearch) || x.email.contains(nameToSearch) || x.number.contains(nameToSearch)) {
                listOfContactsFound.add(x);
                resulOfContactsFound++;
            }
        }
        if (resulOfContactsFound == 0) {
            System.out.println("No contacts found");

        }
        if (resulOfContactsFound > 1) {
            System.out.println("We found multiple contacts");
            int a = 0;
            for (Contacts x : listOfContactsFound) {
                a++;
                if (a >= 1) {
                    System.out.println("  Position: " + a);
                }
                showContact(x);
            }
        }
        if (resulOfContactsFound == 1) {
            System.out.println("Only one contact found");
            for (Contacts x : MyListOfContacts) {
                if (x.firtname.contains(nameToSearch) || x.lastname.contains(nameToSearch) || x.email.contains(nameToSearch) || x.number.contains(nameToSearch)) {
                    showContact(x);
                }
            }
        }
    }

    void searchAndDeleteContact(String nameToSearch) {
        ArrayList<Contacts> listOfContactsFound = new ArrayList<>();

        int resulOfContactsFound = 0;
        int count = 0;

        for (int i = 0; i < MyListOfContacts.size(); i++) {

            if (MyListOfContacts.get(i).firtname.contains(nameToSearch)
                    || MyListOfContacts.get(i).lastname.contains(nameToSearch)
                    || MyListOfContacts.get(i).email.contains(nameToSearch)
                    || MyListOfContacts.get(i).number.contains(nameToSearch)) {
                listOfContactsFound.add(MyListOfContacts.get(i));
                resulOfContactsFound++;
            }
        }
        if (resulOfContactsFound == 0) {
            System.out.println("No contacts found");

        }

        if (resulOfContactsFound > 1) {
            System.out.println("We found multiple contacts");
            int a = 0;
            ArrayList<Contacts> listSaveToDelete = new ArrayList<>();
            for (Contacts m : listOfContactsFound) {
                a++;
                if (m.firtname.contains(nameToSearch)
                        || m.lastname.contains(nameToSearch)
                        || m.number.contains(nameToSearch)
                        || m.email.contains(nameToSearch)) {
                    listSaveToDelete.add(m);
                }
                if (a >= 1) {
                    System.out.println("  Position: " + a);
                    showContact(m);
                }
            }
            System.out.println("Select position to delete");
            System.out.println("or type 'all' to delete all contacts found.");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if (input.contains("all")) {
                for (Contacts q : listOfContactsFound) {
                    for (Contacts s : MyListOfContacts) {
                        if (q.firtname.contains(s.firtname)
                                && q.lastname.contains(s.lastname)
                                && q.number.contains(s.number)
                                && q.email.contains(s.email)) {
                            MyListOfContacts.remove(s);
                            break;
                        }
                    }
                }
                System.out.println("All contacts found were deleted!");
            }
            // inputul nostru trebuie sa fie mai mare de 49 -> tip char si mai mic de 56 tot tip char,
            else if (input.contains("1")) {
                for (Contacts i : MyListOfContacts) {
                    if (listSaveToDelete.get(0).firtname.contains(i.firtname)
                            && listSaveToDelete.get(0).lastname.contains(i.lastname)
                            && listSaveToDelete.get(0).number.contains(i.number)
                            && listSaveToDelete.get(0).email.contains(i.email)) {
                        MyListOfContacts.remove(i);
                        count++;
                        System.out.println("Contact with position " + count + " was deleted!");
                        break;
                    }
                }
            } else if (input.contains("2")) {
                for (Contacts i : MyListOfContacts) {
                    if (listSaveToDelete.get(1).firtname.contains(i.firtname)
                            && listSaveToDelete.get(1).lastname.contains(i.lastname)
                            && listSaveToDelete.get(1).number.contains(i.number)
                            && listSaveToDelete.get(1).email.contains(i.email)) {
                        MyListOfContacts.remove(i);
                        count = count + 2;
                        System.out.println("Contact with position " + count + " was deleted!");
                        break;
                    }
                }

            } else if (input.contains("3")) {
                for (Contacts i : MyListOfContacts) {
                    if (listSaveToDelete.get(2).firtname.contains(i.firtname)
                            && listSaveToDelete.get(2).lastname.contains(i.lastname)
                            && listSaveToDelete.get(2).number.contains(i.number)
                            && listSaveToDelete.get(2).email.contains(i.email)) {
                        MyListOfContacts.remove(i);
                        count = count + 3;
                        System.out.println("Contact with position " + count + " was deleted!");
                        break;
                    }
                }
            } else if (input.contains("4")) {
                for (Contacts i : MyListOfContacts) {
                    if (listSaveToDelete.get(3).firtname.contains(i.firtname)
                            && listSaveToDelete.get(3).lastname.contains(i.lastname)
                            && listSaveToDelete.get(3).number.contains(i.number)
                            && listSaveToDelete.get(3).email.contains(i.email)) {
                        MyListOfContacts.remove(i);
                        count = count + 4;
                        System.out.println("Contact with position " + count + " was deleted!");
                        break;
                    }
                }

            } else {
                System.out.println("Please enter a valid position");


            }
        }
        if (resulOfContactsFound == 1) {
            System.out.println("This contact:");
            for (int i = 0; i < MyListOfContacts.size(); i++) {

                if (MyListOfContacts.get(i).firtname.contains(nameToSearch)
                        || MyListOfContacts.get(i).lastname.contains(nameToSearch)
                        || MyListOfContacts.get(i).email.contains(nameToSearch)
                        || MyListOfContacts.get(i).number.contains(nameToSearch)) {
                    showContact(MyListOfContacts.get(i));
                    MyListOfContacts.remove(i);
                }

            }
            System.out.println("was deleted.");

        }
    }
}