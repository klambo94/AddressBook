package com.github.klambo94.AddressBook;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Created by Kendra Lamb on 3/14/2015.
 */
public class AddressBook {
    ArrayList<Person> people = new ArrayList();
    ArrayList<String> editOptions = new ArrayList();
    ArrayList<String> sortOptions = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String name = null;
    final String FIRSTNAME = "Change the first name";
    final String MIDDLENAME = "Change the middle name";
    final String LASTNAME = "Change the last name";
    final String PHONENUMBER = "Change the phone number";
    final String ADDRESS = "Change the address";
    final String EMAIL = "Change the email";
    final String SORTFIRSTNAME = "Sort by first name.";
    final String SORTMIDDLENAME = "Sort by middle name.";
    final String SORTLASTNAME = "Sort by last name.";
    final String SORTPHONENUM = "Sort by phone number.";
    final String SORTEMAIL = "Sort by email.";
    final String SORTSTREETNUM = "Sort by street number.";
    final String SORTSTREETNAME = "Sort by street name.";
    final String SORTAPTNUM = "Sort by apartment number.";
    final String SORTCITYNAME = "Sort by city name.";
    final String SORTSTATENAME = "Sort by State name.";
    final String SORTZIP = "Sort by Zip code.";
    final String EDITOPTION = "";
    final String SORTOPTION = "";

    public AddressBook() {
        Person person1 = new Person("Kendra", "Marie", "Lamb", "7202318807", "18104", "E Loyola Pl", "Aurora", "Co", "klambo94@gmail.com", "n/a", "80236");
        Person person2 = new Person("Adam", "Douglas", "Smith", "2029473613", "8060", "E Girard Ave", "Denver", "Co", "asmith0935@gmail.com", "701", "80013");
        Person person3 = new Person("Kendra", "Jane", "Workman", "3039473614", "4165", "S Gray St", "Wheat Ridge", "Co", "kjane2015@yahoo.com", "n/a", "80212");
        people.add(person1);
        people.add(person2);
        people.add(person3);

    }

  /*  public void Datafactory(){
        int count = 10;
        for (int i = 0; i < count; i++) {
            Person person = new Person();
                    person.setFirstName(DataFactory.getFirstNameAnyGender());

        }
    }
*/

    public void addPerson() {

        boolean newPerson = true;
        while (newPerson) {
            String firstName = "";
            String middleName = "";
            String lastName = "";
            String email = "";
            String streetNumber = "";
            String streetName = "";
            String city = "";
            String state = "";
            String phoneNumber = "";
            String aptNum = "";
            String zip = "";

            boolean firstIsBad = true;
            while (firstIsBad) {
                System.out.println("What is the first name of the person?");
                firstName = isGoodInput(firstName);
                firstIsBad = false;

            }

            boolean middleIsBad = true;
            while (middleIsBad) {
                System.out.println("What is the middle name of the person?");
                middleName = isGoodInput(middleName);
                middleIsBad = false;
            }

            boolean lastIsBad = true;
            while (lastIsBad) {
                System.out.println("What is the last name of the person?");
                lastName = isGoodInput(lastName);
                lastIsBad = false;

            }

            boolean phoneNumberIsBad = true;
            while (phoneNumberIsBad) {
                System.out.println("Please enter the phone number of the person");
                phoneNumber = isGoodNumberInput("phoneNumber");
                phoneNumberIsBad = false;

            }

            boolean streetNumberIsBad = true;
            while (streetNumberIsBad) {
                System.out.println("Please enter the address number of the person");
                streetNumber = isGoodNumberInput("streetNumber");
                streetNumberIsBad = false;
            }

            boolean streetNameIsBad = true;
            while (streetNameIsBad) {
                System.out.println("Please enter the street name they live on");
                streetName = isGoodInput(streetName);
                streetNameIsBad = false;

            }

            boolean aptNumIsBad = true;
            while (aptNumIsBad) {
                System.out.println("Please enter the apartment number, put n/a");
                aptNum = isGoodNumberInput("aptNum");
                aptNumIsBad = false;

            }

            boolean cityIsBad = true;
            while (cityIsBad) {
                System.out.println("Please enter the City they live in");
                city = isGoodInput(city);
                cityIsBad = false;

            }

            boolean stateIsBad = true;
            while (stateIsBad) {
                System.out.println("Please enter in the State they live in.");
                state = isGoodInput(state);
                stateIsBad = false;
            }
            boolean zipIsBad = true;
            while (zipIsBad) {
                System.out.println("Please enter the zip code");
                zip = isGoodNumberInput("zip");
                zipIsBad = false;
            }

            boolean emailIsBad = true;
            while (emailIsBad) {
                System.out.println("Please enter the email in of the person");
                email = goodEmail(email);
                emailIsBad = false;
            }
            people.add(new Person(firstName, middleName, lastName, phoneNumber, streetNumber, streetName, city, state, email, aptNum, zip));
            System.out.println("Is there a new person to add? (y/n)");
            newPerson = scanner.nextLine().equalsIgnoreCase("y");

        }
        System.out.println(toString());
    }


    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public String isGoodInput(String s) {
        boolean isBadInput = true;
        while (isBadInput) {
            s = scanner.nextLine();
            if (s.length() < 2) {
                System.out.println("You must enter a valid entry, more than 2 letters. Please try again. ");
            } else if (isNumeric(s)) { // checking to see if the name is numbers
                System.out.println("Numbers are not names, please enter a name.");
            } else {
                if (!Character.isUpperCase(s.charAt(0))) {
                    char a = Character.toUpperCase(s.charAt(0));
                    s = a + s.substring(1);
                    isBadInput = false;
                } else {
                    isBadInput = false;
                }
            }
        }
        return s;
    }

    public String isGoodNumberInput(String s) { // passing in the string "change phone" but not saving the new one.
        boolean isBadInput = true;
        while (isBadInput) {
            s = scanner.nextLine();
            if (s.toLowerCase().contains("phone")) {
                if (!isNumeric(s)) {
                    System.out.println("That is not a number, please enter a number");
                } else if (s.length() >= 11) {
                    System.out.println("I'm sorry that number is too large, place try again.");
                } else if (s.length() < 10) {
                    System.out.println("I'm sorry, that is too small please use 10 digits");
                } else {
                    isBadInput = false;
                }
            } else if (s.toLowerCase().contains("street")) {
                if (!isNumeric(s)) {
                    System.out.println("That is not a number, please enter a number");
                } else if (s.length() < 0) {
                    System.out.println("It seems you have not entered an address number. Please try again .");
                } else if (s.length() > 10) {
                    System.out.println("It seems like that is a little too long for an address number. Why don't you try again.");
                } else {
                    isBadInput = false;
                }
            } else if (s.toLowerCase().contains("apt")) {
                if (s.equalsIgnoreCase("n/a")) {
                    isBadInput = false;
                } else if (!isNumeric(s)) {
                    System.out.println("That is not a number, please try again");
                } else if (s.length() >= 6) {
                    System.out.println("It seems like that is a little too long for an apartment number. Why don't you try again.");
                } else {
                    isBadInput = false;
                }
            } else if (s.toLowerCase().contains("zip")) {
                if (!isNumeric(s)) {
                    System.out.println("That is not a number, please enter a number.");
                } else if (s.length() < 0) {
                    System.out.println("You have not entered a zip code, please try again.");
                } else if (s.length() > 6) {
                    System.out.println("That is too long for a zip code, please try again.");
                } else {
                    isBadInput = false;
                }

            } else if (s.toLowerCase().contains("sort")) {
                if (!isNumeric(s)) {
                    System.out.println("You've entered the option name, please enter the option number.");
                } else if (s.equalsIgnoreCase("1") || s.equalsIgnoreCase("2")) {
                    isBadInput = false;
                } else {
                    System.out.println("You must choose one of the numbers 1 or 2.");
                }

            } else {
                System.out.println("There is no option for that, please try again");
            }
            }

        return s;
    }

    public String goodEmail(String s) {
        boolean isBadInput = true;
        while (isBadInput) {
            s = scanner.nextLine();
            if (!EmailValidator.getInstance().isValid(s)) {
                System.out.println("I'm sorry, that is an invalid email address. Please enter a valid one:");
                System.out.println("ex: youremail@domain.com");
            } else {
                isBadInput = false;
            }
        }
        return s;
    }
    public String toString() {
        String str = "";
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            str = str + i + ": " + person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName() + " "
                    + person.getPhoneNumber() + " " + person.getEmail() + " " + person.getStreetNumber() + " " + person.getStreetName()
                    + " apt: " + person.getAptNum() + " " + person.getCity() + " " + person.getState() + " " + person.getZip() + "\n";
        }
        return str;
    }

    public String toString(Person o) {
        String str = "";
        str = str + o.getFirstName() + " " + o.getMiddleName() + " " + o.getLastName() + " "
                + o.getPhoneNumber() + " " + o.getEmail() + " " + o.getStreetNumber() + " " + o.getStreetName()
                + " apt: " + o.getAptNum() + " " + o.getCity() + " " + o.getState() + " " + o.getZip();
        return str;
    }


    public void removePerson() {
        boolean removeMore = true;
        while (removeMore) {
            if (people.size() == 0) {
                System.out.println("There is nothing in the address book");
                break;
            } else {
                try {
                    System.out.println("Who do you want to remove from the address book? Please use the number of the contact.");
                    System.out.println(toString());
                    System.out.println("Please enter the index number:");
                    int personToRemove = Integer.parseInt(scanner.nextLine());
                    people.remove(personToRemove);
                    System.out.println(toString());

                    System.out.println("Do you wish to remove another? (y/n)");
                    removeMore = scanner.nextLine().equalsIgnoreCase("y");

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("There is not a person in that number you have specified please try again.");
                } catch (NumberFormatException e) {
                    System.out.println("You have either entered in nothing or a letter instead of a number, please try again.");
                }
            }
        }
    }

    public void editAPerson() {
        createEditOptions();
        boolean moreToEdit = true;
        String changeName = null;
        String changeEmail = null;
        String changePhone = null;
        String changeStreetNum = null;
        String changeStreetName = null;
        String changeAptNum = null;
        String changeCity = null;
        String changeState = null;
        String changeZip = null;



        while (moreToEdit) {
            boolean personToEditIsGood = true;
            while (personToEditIsGood) {
                try {
                    System.out.println("Who would like you edit? Please use the contact number. ");
                    System.out.println(toString());
                    System.out.println("Please enter the index number:");
                    int personToEdit = Integer.parseInt(scanner.nextLine());
                    Person person = people.get(personToEdit);

                    boolean editSamePerson = true;
                    while (editSamePerson) {
                        System.out.println("What part do you want to edit?");
                        System.out.println(getOptions(EDITOPTION));
                        int partToEdit = Integer.parseInt(scanner.nextLine());
                        switch (editOptions.get(partToEdit)) {
                            case FIRSTNAME:
                                changeName = getNewInfo(changeName);
                                person.setFirstName(changeName);
                                personToEditIsGood = false;
                                break;
                            case MIDDLENAME:
                                changeName = getNewInfo(changeName);
                                person.setMiddleName(changeName);
                                personToEditIsGood = false;
                                break;
                            case LASTNAME:
                                changeName = getNewInfo(changeName);
                                person.setLastName(changeName);
                                personToEditIsGood = false;
                                break;
                            case PHONENUMBER:
                                System.out.println("What do you want to change it to?");
                                changePhone = isGoodNumberInput(changePhone);
                                person.setPhoneNumber(changePhone);
                                personToEditIsGood = false;
                                break;
                            case ADDRESS:
                                System.out.println("What do you want to change the street number to?");
                                changeStreetNum = isGoodNumberInput(changeStreetNum);
                                person.setStreetNumber(changeStreetNum);

                                System.out.println("What do you want to change the street name to?");
                                changeStreetName = isGoodInput(changeStreetName);
                                person.setStreetName(changeStreetName);

                                System.out.println("What do you want to change the apartment number to?");
                                changeAptNum = isGoodNumberInput(changeAptNum);
                                person.setAptNum(changeAptNum);

                                System.out.println("What do you want to change the city to?");
                                changeCity = isGoodInput(changeCity);
                                person.setCity(changeCity);

                                System.out.println("What do you want to change the state to?");
                                changeState = isGoodInput(changeState);
                                person.setState(changeState);

                                System.out.println("What do you want to change the zip code to?");
                                changeZip = isGoodNumberInput(changeZip);
                                person.setZip(changeZip);

                                personToEditIsGood = false;
                                break;
                            case EMAIL:
                                System.out.println("What do you want to change the email to?");
                                changeEmail = goodEmail(changeEmail);
                                person.setEmail(changeEmail);
                                personToEditIsGood = false;
                                break;
                            default:
                                break;
                        }
                        System.out.println(toString());
                        System.out.println("Do you want to edit more? (y/n)");
                        editSamePerson = scanner.nextLine().equalsIgnoreCase("y");

                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("That number is not apart of the list, please try again.");
                } catch (NumberFormatException e) {
                    System.out.println("You have entered the person's information, or nothing. Please try the number again.");
                }

            }
            System.out.println("Do you want to edit a new person? (y/n)");
            moreToEdit = scanner.nextLine().equalsIgnoreCase("y");
        }

    }

    public void createEditOptions() {
        editOptions.add(FIRSTNAME);
        editOptions.add(MIDDLENAME);
        editOptions.add(LASTNAME);
        editOptions.add(PHONENUMBER);
        editOptions.add(ADDRESS);
        editOptions.add(EMAIL);
    }

    public void createSortOptions() {
        sortOptions.add(SORTFIRSTNAME);
        sortOptions.add(SORTMIDDLENAME);
        sortOptions.add(SORTLASTNAME);
        sortOptions.add(SORTPHONENUM);
        sortOptions.add(SORTEMAIL);
        sortOptions.add(SORTSTREETNUM);
        sortOptions.add(SORTSTATENAME);
        sortOptions.add(SORTSTATENAME);
        sortOptions.add(SORTCITYNAME);
        sortOptions.add(SORTZIP);

    }


    public String getOptions(String s) {
        String optionName = "";
        try {

            if (s.equalsIgnoreCase(EDITOPTION)) {

                for (int i = 0; i < editOptions.size(); i++) {
                    optionName = optionName + i + " - " + editOptions.get(i) + "\n";
                }

            } else {
                for (int i = 0; i < sortOptions.size(); i++) {
                    optionName = optionName + i + " - " + sortOptions.get(i) + "\n";
                }

            }

        } catch (NullPointerException e) {
            System.out.println("This is the correct place because EDITOPTION is null");
        }
        return optionName;
    }




    public String getNewInfo(String s) {
        System.out.println("What do you want to change it to?");
        name = isGoodInput(s);
        return name;
    }

    public void searchPerson() {
        String searchForPerson;

        boolean moreToSearch = true;
        while (moreToSearch) {
            System.out.println("Who do you want to search for?");
            boolean searchIsGood = true;
            while (searchIsGood) {
                searchForPerson = scanner.nextLine();
                if (searchForPerson.length() == 0) {
                    System.out.println("You have entered nothing, please try again.");
                } else if (containsPerson(searchForPerson)) {
                    searchIsGood = false;
                } else {
                    boolean addContact = true;
                    while (addContact) {
                        System.out.println("No contacts found under: " + searchForPerson + ".  Add contact?(y/n)");
                        addContact = scanner.nextLine().equalsIgnoreCase("y");
                        if (addContact) {
                            addPerson();
                            addContact = false;
                        } else {
                            addContact = false;
                        }
                    }
                    searchIsGood = false;
                }
            }
            System.out.println("Exit search ? (y/n)");
            moreToSearch = scanner.nextLine().equalsIgnoreCase("n");
        }
    }

    public boolean containsPerson(String s) {
        boolean personFound = true;
        while (personFound) {
            for (Person person : people) {
                if (person.getFirstName().toLowerCase().contains(s.toLowerCase()) || person.getMiddleName().toLowerCase().contains(s.toLowerCase())
                        || person.getLastName().toLowerCase().contains(s.toLowerCase()) || person.getStreetNumber().toLowerCase().contains(s.toLowerCase())
                        || person.getStreetName().toLowerCase().contains(s.toLowerCase()) || person.getPhoneNumber().toLowerCase().contains(s.toLowerCase())
                        || person.getEmail().toLowerCase().contains(s.toLowerCase()) || person.getAptNum().toLowerCase().contains(s.toLowerCase())
                        || person.getCity().toLowerCase().contains(s.toLowerCase()) || person.getState().toLowerCase().contains(s.toLowerCase())
                        || person.getZip().toLowerCase().contains(s.toLowerCase())) {

                    System.out.println(toString(person));
                    personFound = false;
                }
            }
            if (personFound) {
                return false;
            }
        }
        return true;
    }


    public void sortAddressBook(String s, boolean ascending) {


        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                String a = "", b = "";
                switch (s) {
                    case SORTFIRSTNAME:
                        if (ascending) {
                            a = o1.getFirstName();
                            b = o2.getFirstName();
                        } else {
                            b = o1.getFirstName();
                            a = o2.getFirstName();
                        }
                        break;
                    case SORTMIDDLENAME:
                        if (ascending) {
                            a = o1.getMiddleName();
                            b = o2.getMiddleName();
                        } else {
                            b = o1.getMiddleName();
                            a = o2.getMiddleName();
                        }
                        break;

                    case SORTLASTNAME:
                        if (ascending) {
                            a = o1.getLastName();
                            b = o2.getLastName();
                        } else {
                            b = o1.getLastName();
                            a = o2.getLastName();

                        }
                        break;
                    case SORTEMAIL:
                        if (ascending) {
                            a = o1.getEmail();
                            b = o2.getEmail();
                        } else {
                            b = o1.getEmail();
                            a = o2.getEmail();
                        }
                        break;
                    case SORTPHONENUM:
                        if (ascending) {
                            a = o1.getPhoneNumber();
                            b = o2.getPhoneNumber();
                        } else {
                            b = o1.getPhoneNumber();
                            a = o2.getPhoneNumber();

                        }
                        break;
                    case SORTSTREETNUM:
                        if (ascending) {
                            a = o1.getStreetNumber();
                            b = o2.getStreetNumber();
                        } else {
                            b = o1.getStreetNumber();
                            a = o2.getStreetNumber();
                        }
                        break;
                    case SORTSTREETNAME:
                        if (ascending) {
                            a = o1.getStreetName();
                            b = o2.getStreetName();
                        } else {
                            b = o1.getStreetName();
                            a = o2.getStreetName();
                        }
                        break;
                    case SORTCITYNAME:
                        if (ascending) {
                            a = o1.getCity();
                            b = o2.getCity();
                        } else {
                            b = o1.getCity();
                            a = o2.getCity();
                        }
                        break;
                    case SORTSTATENAME:
                        if (ascending) {
                            a = o1.getState();
                            b = o2.getState();
                        } else {
                            b = o1.getState();
                            a = o2.getState();
                        }
                        break;
                    case SORTAPTNUM:
                        if (ascending) {
                            a = o1.getAptNum();
                            b = o2.getAptNum();
                        } else {
                            b = o1.getAptNum();
                            a = o2.getAptNum();
                        }
                        break;
                    case SORTZIP:
                        if (ascending) {
                            a = o1.getZip();
                            b = o2.getZip();
                        } else {
                            b = o1.getZip();
                            a = o2.getZip();
                        }
                        break;
                    default:
                        System.out.println("There was no match, no sorting done.");
                        break;
                }
                return a.compareToIgnoreCase(b);
            }

        });
    }

    public void printSorted() {
        String howToSort;
        String sortBy = "";
        boolean ascending = false;
        createSortOptions();
        System.out.println("How do you want to sort the address book?");
        System.out.println(getOptions(SORTOPTION));
        try {
                howToSort = scanner.nextLine();
                howToSort = sortOptions.get(Integer.parseInt(howToSort));
            System.out.print("How do you want to sort? Please chose a number:\n1 - ascending \n" +
                    "2 - descending\n");
            sortBy = isGoodNumberInput(sortBy);
            if (sortBy.equalsIgnoreCase("1")) {
                ascending = true;
            }

            sortAddressBook(howToSort, ascending);
            System.out.println(this.toString());

        } catch (IndexOutOfBoundsException e) {
            System.out.println("I'm sorry, the option you've chosen is not part of the list, please try again.");
        } catch (NumberFormatException e) {
            System.out.println("You've either tried to enter the option name or something other than a number, please try again.");
        }

    }
}



