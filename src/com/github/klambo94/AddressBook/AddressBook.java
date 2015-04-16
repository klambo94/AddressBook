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
    Scanner scanner = new Scanner(System.in); //to get the user's input about a person
    String name = null;
    final String FIRSTNAME = "Change the first name";
    final String MIDDLENAME = "Change the middle name";
    final String LASTNAME = "Change the last name";
    final String PHONENUMBER = "Change the phone number";
    final String ADDRESS = "Change the address";
    final String EMAIL = "Change the email";
    final String FIRSTNAMEASCENDING = "Sort by first name, ascending.";
    final String FIRSTNAMEDESCENDING = "Sort by first name, descending.";
    final String MIDDLENAMEASCENDING = "Sort by middle name, ascending.";
    final String MIDDLENAMEDESCENDING = "Sort by middle name, descending.";
    final String LASTNAMEASCENDING = "Sort by last name, ascending";
    final String LASTNAMEDESCENDING = "Sort by last name, descending.";
    final String PHONENUMASCENDING = "Sort by phone number, ascending";
    final String PHONENUMDESCENDING = "Sort by phone number, descending";
    final String EMAILASENDING = "Sort by email, ascending";
    final String EMAILDESCENDING = "Sort by email, descending";
    final String STREETNUMASCENDING = "Sort by street number, ascending";
    final String STREETNUMDESCENDING = "Sort by street number, descending";
    final String STREETNAMEASCENDING = "Sort by street name ascending";
    final String STREETNAMEDESCENDING = "Sort by street name, descending";
    final String APTNUMASCENDING = "Sort by apartment number, ascending";
    final String APTNUMDESCENDING = "Sort by apartment number, descending";
    final String CITYNAMEASCENDING = "Sort by city name, ascending ";
    final String CITYNAMEDESCENDING = "Sort by city name, descending.";
    final String STATENAMEASCENDING = "Sort by State name, ascending";
    final String STATENAMEDESCCENDING = "Sort by State name, descending";
    final String ZIPASCENDING = "Sort by Zip code, ascending";
    final String ZIPDESCENDING = "Sort by Zip cide, descending";
    final String EDIT = null;
    final String SORT = null;

    public AddressBook() {
        Person person1 = new Person("Kendra", "Marie", "Lamb", "7202318807", "18104", "E Loyola Pl", "Aurora", "Co", "klambo94@gmail.com", "n/a", "80236");
        Person person2 = new Person("Adam", "Douglas", "Smith", "2029473613", "8060", "E Girard Ave", "Denver", "Co", "asmith0935@gmail.com", "701", "80013");
        Person person3 = new Person("Kendra", "Jane", "Workman", "3039473614", "4165", "S Gray St", "Wheat Ridge", "Co", "kjane2015@yahoo.com", "n/a", "80212");
        people.add(person1);
        people.add(person2);
        people.add(person3);
    }


    public void addPerson() {

        boolean newPerson = true;
        while (newPerson) {
            String firstName = null;
            String middleName = null;
            String lastName = null;
            String email = null;
            String streetNumber = null;
            String streetName = null;
            String city = null;
            String state = null;
            String phoneNumber = null;
            String aptNum = null;
            String zip = null;

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
                phoneNumber = isGoodNumberInput("phoneNumber", phoneNumber);
                phoneNumberIsBad = false;

            }

            boolean streetNumberIsBad = true;
            while (streetNumberIsBad) {
                System.out.println("Please enter the address number of the person");
                streetNumber = isGoodNumberInput("streetNumber", streetNumber);
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
                aptNum = isGoodNumberInput("aptNum", aptNum);
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
                zip = isGoodNumberInput("zip", zip);
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

    public String isGoodNumberInput(String s, String g) { // passing in the string "change phone" but not saving the new one.
        boolean isBadInput = true;
        while (isBadInput) {
            g = scanner.nextLine();
            if (s.equals("changePhone") || s.equals("phoneNumber")) {
                if (!isNumeric(g)) {
                    System.out.println("That is not a number, please enter a number");
                } else if (g.length() >= 11) {
                    System.out.println("I'm sorry that number is too large, place try again.");
                } else if (g.length() < 10) {
                    System.out.println("I'm sorry, that is too small please use 10 digits");
                } else {
                    isBadInput = false;
                }
            } else if (s.equals("changeStreet") || s.equals("streetNumber")) {
                if (!isNumeric(g)) {
                    System.out.println("That is not a number, please enter a number");
                } else if (g.length() < 0) {
                    System.out.println("It seems you have not entered an address number. Please try again .");
                } else if (g.length() > 10) {
                    System.out.println("It seems like that is a little too long for an address number. Why don't you try again.");
                } else {
                    isBadInput = false;
                }
            } else if (s.equals("changeAptNum") || s.equals("aptNum")) {
                if (g.equalsIgnoreCase("n/a")) {
                    isBadInput = false;
                } else if (!isNumeric(g)) {
                    System.out.println("That is not a number, please try again");
                } else if (g.length() >= 6) {
                    System.out.println("It seems like that is a little too long for an apartment number. Why don't you try again.");
                } else {
                    isBadInput = false;
                }
            } else if (s.equals("changeZip") || s.equals("zip")) {
                if (!isNumeric(g)) {
                    System.out.println("That is not a number, please enter a number.");
                } else if (g.length() < 0) {
                    System.out.println("You have not entered a zip code, please try again.");
                } else if (g.length() > 6) {
                    System.out.println("That is too long for a zip code, please try again.");
                } else {
                    isBadInput = false;
                }

            } else {
                System.out.println("There is no option for that, please try again");
            }
            }

        return g;
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
        String changeStreetName;
        String changeAptNum = null;
        String changeCity;
        String changeState;
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
                        System.out.println(getEditOptions());
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
                                changePhone = isGoodNumberInput("phoneNumber", changePhone);
                                person.setPhoneNumber(changePhone);
                                personToEditIsGood = false;
                                break;
                            case ADDRESS:
                                System.out.println("What do you want to change the street number to?");
                                changeStreetNum = isGoodNumberInput("changeStreet", changeStreetNum);
                                person.setStreetNumber(changeStreetNum);

                                System.out.println("What do you want to change the street name to?");
                                changeStreetName = isGoodInput("changeStreet");
                                person.setStreetName(changeStreetName);

                                System.out.println("What do you want to change the apartment number to?");
                                changeAptNum = isGoodNumberInput("changeAptNum", changeAptNum);
                                person.setAptNum(changeAptNum);

                                System.out.println("What do you want to change the city to?");
                                changeCity = isGoodInput("city");
                                person.setCity(changeCity);

                                System.out.println("What do you want to change the state to?");
                                changeState = isGoodInput("state");
                                person.setState(changeState);

                                System.out.println("What do you want to change the zip code to?");
                                changeZip = isGoodNumberInput("changeZip", changeZip);
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
        sortOptions.add(FIRSTNAMEDESCENDING);
        sortOptions.add(MIDDLENAMEASCENDING);
        sortOptions.add(MIDDLENAMEDESCENDING);
        sortOptions.add(LASTNAMEASCENDING);
        sortOptions.add(LASTNAMEDESCENDING);
        sortOptions.add(EMAILASENDING);
        sortOptions.add(EMAILDESCENDING);
        sortOptions.add(PHONENUMASCENDING);
        sortOptions.add(PHONENUMDESCENDING);
        sortOptions.add(STREETNUMASCENDING);
        sortOptions.add(STREETNAMEDESCENDING);
        sortOptions.add(STREETNAMEASCENDING);
        sortOptions.add(STREETNAMEDESCENDING);
        sortOptions.add(CITYNAMEASCENDING);
        sortOptions.add(CITYNAMEDESCENDING);
        sortOptions.add(STATENAMEASCENDING);
        sortOptions.add(STATENAMEDESCCENDING);
        sortOptions.add(ZIPASCENDING);
        sortOptions.add(ZIPDESCENDING);
    }

    public String getEditOptions() {
        String optionName = "";
        for (int i = 0; i < editOptions.size(); i++) {
            optionName = optionName + i + " - " + editOptions.get(i) + "\n";
        }
        return optionName;
    }

    public String getSortOptions() {
        String optionName = "";
        for (int i = 0; i < sortOptions.size(); i++) {
            optionName = optionName + i + " - " + sortOptions.get(i) + "\n";
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


    public String sortAddressBook(String s) {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                switch (s) {
                    case FIRSTNAMEASCENDING:
                        String name1 = o1.getFirstName();
                        String name2 = o2.getFirstName();
                        return name1.compareToIgnoreCase(name2);
                    case FIRSTNAMEDESCENDING:
                        name1 = o1.getFirstName();
                        name2 = o2.getFirstName();
                        return name2.compareToIgnoreCase(name1);
                    case MIDDLENAMEASCENDING:
                        name1 = o2.getMiddleName();
                        name2 = o2.getMiddleName();
                        return name1.compareToIgnoreCase(name2);
                    case MIDDLENAMEDESCENDING:
                        name1 = o1.getMiddleName();
                        name2 = o2.getMiddleName();
                        return name2.compareToIgnoreCase(name1);
                    case LASTNAMEASCENDING:
                        name1 = o1.getLastName();
                        name2 = o2.getLastName();
                        return name1.compareToIgnoreCase(name2);
                    case LASTNAMEDESCENDING:
                        name1 = o1.getLastName();
                        name2 = o2.getLastName();
                        return name2.compareToIgnoreCase(name1);
                    case EMAILASENDING:
                        String email1 = o1.getEmail();
                        String email2 = o2.getEmail();
                        return email1.compareToIgnoreCase(email2);
                    case EMAILDESCENDING:
                        email1 = o1.getEmail();
                        email2 = o2.getEmail();
                        return email2.compareToIgnoreCase(email1);
                    case PHONENUMASCENDING:
                        String phoneNum1 = o1.getPhoneNumber();
                        String phoneNum2 = o2.getPhoneNumber();
                        return phoneNum1.compareToIgnoreCase(phoneNum2);
                    case PHONENUMDESCENDING:
                        phoneNum1 = o1.getPhoneNumber();
                        phoneNum2 = o2.getPhoneNumber();
                        return phoneNum2.compareToIgnoreCase(phoneNum1);
                    case STREETNUMASCENDING:
                        String streetNum1 = o1.getStreetNumber();
                        String streetNum2 = o2.getStreetNumber();
                        return streetNum1.compareToIgnoreCase(streetNum2);
                    case STREETNUMDESCENDING:
                        streetNum1 = o1.getStreetNumber();
                        streetNum2 = o2.getStreetNumber();
                        return streetNum2.compareToIgnoreCase(streetNum1);
                    case STREETNAMEASCENDING:
                        String streetName1 = o1.getStreetName();
                        String streetName2 = o2.getStreetName();
                        return streetName1.compareToIgnoreCase(streetName2);
                    case STREETNAMEDESCENDING:
                        streetName1 = o1.getStreetName();
                        streetName2 = o2.getStreetName();
                        return streetName2.compareToIgnoreCase(streetName1);
                    case CITYNAMEASCENDING:
                        String cityName1 = o1.getCity();
                        String cityName2 = o2.getCity();
                        return cityName1.compareToIgnoreCase(cityName2);
                    case CITYNAMEDESCENDING:
                        cityName1 = o1.getCity();
                        cityName2 = o2.getCity();
                        return cityName2.compareToIgnoreCase(cityName1);
                    case STATENAMEASCENDING:
                        String stateName1 = o1.getState();
                        String stateName2 = o2.getState();
                        return stateName1.compareToIgnoreCase(stateName2);
                    case STATENAMEDESCCENDING:
                        stateName1 = o1.getState();
                        stateName2 = o2.getState();
                        return stateName2.compareToIgnoreCase(stateName1);
                    case APTNUMASCENDING:
                        String aptNum1 = o1.getAptNum();
                        String aptNum2 = o2.getAptNum();
                        return aptNum1.compareToIgnoreCase(aptNum2);
                    case APTNUMDESCENDING:
                        aptNum1 = o1.getAptNum();
                        aptNum2 = o2.getAptNum();
                        return aptNum2.compareToIgnoreCase(aptNum1);
                    case ZIPASCENDING:
                        String zip1 = o1.getZip();
                        String zip2 = o2.getZip();
                        return zip1.compareToIgnoreCase(zip2);
                    case ZIPDESCENDING:
                        zip1 = o1.getZip();
                        zip2 = o2.getZip();
                        return zip2.compareToIgnoreCase(zip1);
                    default:
                        System.out.println("There was no match, no sorting done.");
                        break;
                }
                return -1;
            }

        });
        return "String";
    }

    public void printSorted() {
        String howToSort;
        String sortBy = null;

        createSortOptions();
        System.out.println("How do you want to sort the address book?");
        System.out.println(getSortOptions());
        try {
            boolean sortIsGood = true;
            while (sortIsGood) {
                howToSort = scanner.nextLine();
                //use string tokenizer and if/else statement to compare what the string name is against the index number to throw into switch statement.
                howToSort = sortOptions.get(Integer.parseInt(howToSort));
                System.out.println(howToSort);
                System.out.println(sortAddressBook(howToSort));

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("I'm sorry, the option you've chosen is not part of the list, please try again.");
        } catch (NumberFormatException e) {
            System.out.println("You've either tried to enter the option name or something other than a number, please try again.");
        }

    }
}



