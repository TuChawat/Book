package com.Bridgelabs;

import com.sun.corba.se.pept.transport.ContactInfoList;

import java.util.*;
import java.util.stream.Collectors;

import static com.sun.javafx.font.FontResource.ZERO;

public class AddressBook {
    public int indexValue = 1;
    public HashMap<Integer, ContactPerson> contacts = new HashMap<>();
    public HashMap<String, AddressBookList> addressBookList = new HashMap<String, AddressBookList>();
    public static Scanner sc = new Scanner(System.in);
    static AddressBook addressbook = new AddressBook();

    public static void main() {
        int choice = 0;
        AddressBook contact = new AddressBook();
        System.out.println("----- Welcome to Address Book Program -----");
        while (choice < 9) {
            System.out.println(" ---------- Menu ---------- ");
            System.out.println("\nEnter your choice " +
                    "\n\t 1.Add Contact " +
                    "\n\t 2.PrintContact " +
                    "\n\t 3.Edit Contact " +
                    "\n\t 4.Delete Contact" +
                    "\n\t 5. Sorting by First Name" +
                    "\n\t 6. Sorting by City Name" +
                    "\n\t 7. View Cities and State of Contacts " +
                    "\n\t 8. Search contacts in Cities and States " +
                    "\n\t 9. Exit from menu : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    contact.addPerson();
                    break;
                case 2:
                    contact.editContact();
                    break;
                case 3:
                    contact.sortByName();
                    break;
                case 4:
                    contact.sortByCity();
                    break;
                case 5:
                    contact.deleteContact();
                    break;
                case 6:
                    contact.createNewAddressBook();
                    break;
                case 7:
                    contact.searchPersonByCity();
                    break;
                case 8:
                    contact.searchPersonByState();
                    break;
                case 9:
                    contact.countPersonByState();
                    break;
                case 10:
                    contact.countPersonByCity();
                    break;
                case 11:
                    contact.sortPersonByFirstname();
                    break;
                case 12:
                    contact.sortPersonByCity();
                    break;
                case 13:
                    contact.sortPersonByState();
                    break;
                case 14:
                    contact.sortPersonByZipCode();
                    break;
            }
        }
    }

    public void addPerson() {
        System.out.println("Enter Person Details to add in contact ");
        System.out.print("\tEnter First name :");
        String firstName = sc.next();
        if (check(firstName)) {
            System.out.println("Contact is exist, Enter different name ");
        } else {
            System.out.print("\tEnter Last name :");
            String lastName = sc.next();
            System.out.print("\tEnter Address :");
            String address = sc.next();
            System.out.print("\tEnter City :");
            String city = sc.next();
            System.out.print("\tEnter State :");
            String state = sc.next();
            System.out.print("\tEnter Zip code :");
            long zip = sc.nextLong();
            System.out.print("\tEnter Phone number :");
            long phoneNumber = sc.nextLong();

            ContactPerson person1 = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber);
            contacts.put(indexValue, person1);
            indexValue++;

        System.out.println("Successfully Added : \n ");
        }
    }

    public Boolean check(String checkName) {
        if (contacts.isEmpty())
            return false;
        else {
            Iterator<Integer> itr = contacts.keySet().iterator();
            while (itr.hasNext()) {
                int key = itr.next();
                if (contacts.get(key).firstName.equals(checkName)) {
                    System.out.println("\nAdd contact again with different first name.");
                    return true;
                }
            }
        }
        return false;
    }


    public void editContact() {
        if (contacts.isEmpty()) {
            System.out.println("There are no contacts to edit ");
        } System.out.println("Enter the first name to edit contact.");
        String name = sc.next();
        Iterator<Integer> itr = contacts.keySet().iterator();
        while (itr.hasNext()) {
            int key = itr.next();
            if (contacts.get(key).firstName.equals(name)) {
                System.out.println("\nEnter First");
                String first = sc.next();
                sc.nextLine();
                System.out.println("Enter Last Name");
                String last = sc.next();
                sc.nextLine();
                System.out.println("Enter Address");
                String address = sc.next();
                sc.nextLine();
                System.out.println("Enter City");
                String city = sc.nextLine();
                System.out.println("Enter State");
                String state = sc.next();
                sc.nextLine();
                System.out.println("Enter Zip Code");
                int zip = sc.nextInt();
                System.out.println("Enter Phone Number");
                long phone = sc.nextLong();
                ContactPerson contact = new ContactPerson(first, last, address, city, state, zip, phone);
                contacts.put(key, contact);
                System.out.println("Contact edited with given first name : " + name);
            }
        }
    }

    public void sortByName(){
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (ContactPerson cont : conatactlist){
            System.out.println(cont.getfirstName() + " " +cont.getlastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(ContactPerson::getfirstName));
        conatactlist.forEach((ContactPerson cont) -> System.out.println(cont.getfirstName() + " " + cont.getlastName()));
    }

    public void sortByCity(){
        System.out.println("---Sort by City---");
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (ContactPerson cont : conatactlist){
            System.out.println(cont.getCity() + " : " + cont.getfirstName() + " " + cont.getlastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(ContactPerson::getCity));
        conatactlist.forEach((ContactPerson cont) -> System.out.println(cont.getCity() + " : " +cont.getfirstName() + " " + cont.getlastName()));
    }


    public void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("There is no contact to delete");
        } else {
            System.out.println("Enter First name: ");
            String fname = sc.next();
            for (int count = ZERO; count < contacts.size(); count++) {
                if (contacts.get(count).getfirstName().equals(fname)) {
                    contacts.remove(contacts.get(count));
                }
            }
        }
    }

    public void createNewAddressBook() {
        System.out.println("Enter the name for Address Book:");
        String addressBookName = sc.next();
        AddressBookList addressBookListobj = new AddressBookList(addressBookName);
    }

    public void searchPersonByCity() {
        System.out.println("Enter the city:");
        String cityName = sc.next();
        System.out.println("Person Search by " + cityName);
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        Dictionary dictWithCity = new Hashtable();
        conatactlist.stream().filter(n -> n.city.contains(cityName)).forEach(contactlist -> dictWithCity.put(contactlist.firstName, contactlist));
        for (Enumeration i = dictWithCity.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }

    public void searchPersonByState() {
        System.out.println("Enter the state:");
        String stateName = sc.next();
        System.out.println("Person Search by " + stateName);
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        Dictionary dictWithState = new Hashtable();
        conatactlist.stream().filter(n -> n.state.contains(stateName)).forEach(contactlist -> dictWithState.put(contactlist.firstName, stateName));
        for (Enumeration i = dictWithState.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }

    public void countPersonByState() {
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        System.out.println(conatactlist.stream().collect(Collectors.groupingBy((ContactPerson C) -> C.getState(),Collectors.counting())));
    }

    public void countPersonByCity() {
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        System.out.println(conatactlist.stream().collect(Collectors.groupingBy((ContactPerson C) -> C.getCity(),Collectors.counting())));
    }

    public void sortPersonByFirstname(){
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (ContactPerson cont : conatactlist){
            System.out.println(cont.getfirstName() + " " +cont.getlastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(ContactPerson::getfirstName));
        conatactlist.forEach((ContactPerson cont) -> System.out.println(cont.getfirstName() + " " + cont.getlastName()));
    }

    public void sortPersonByCity(){
        System.out.println("Sort by City");
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (ContactPerson cont : conatactlist){
            System.out.println(cont.getCity() + " : " + cont.getfirstName() + " " + cont.getlastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(ContactPerson::getCity));
        conatactlist.forEach((ContactPerson cont) -> System.out.println(cont.getCity() + " : " +cont.getfirstName() + " " + cont.getlastName()));
    }

    public void sortPersonByState(){
        System.out.println("Sort by State");
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (ContactPerson cont : conatactlist){
            System.out.println(cont.getState() + " : " +cont.getfirstName() + " "+ cont.getlastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(ContactPerson::getState));
        conatactlist.forEach((ContactPerson cont) -> System.out.println(cont.getState() + " : " + cont.getfirstName() + " " + cont.getlastName()));
    }

    public void sortPersonByZipCode(){
        System.out.println("Sort by ZipCode");
        Collection<ContactPerson> values = contacts.values();
        ArrayList<ContactPerson> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (ContactPerson cont : conatactlist){
            System.out.println(cont.getZip() + " : " +cont.getfirstName() + " "+ cont.getlastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(ContactPerson::getZip));
        conatactlist.forEach((ContactPerson cont) -> System.out.println(cont.getZip() + " : " +cont.getfirstName() + " " + cont.getlastName()));
    }
}

