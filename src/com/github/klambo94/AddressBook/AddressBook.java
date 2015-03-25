package com.github.klambo94.AddressBook;

import org.apache.commons.validator.EmailValidator;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Kendra Lamb on 3/14/2015.
 */
public class AddressBook {
    ArrayList<Person> people = new ArrayList();
    Scanner scanner = new Scanner(System.in); //to get the user's input about a person
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
    boolean newPerson = true;


    public AddressBook() {
        Person person1 = new Person("Kendra", "Marie", "Lamb", "7202318807", "18104", "E Loyola Pl", "Aurora", "Co", "klambo94@gmail.com", "n/a");
        Person person2 = new Person("Adam", "Douglas", "Smith", "2029473613", "8060", "E Girard Ave", "Denver", "Co", "asmith0935@gmail.com", "701");
        people.add(person1);
        people.add(person2);
    }


    public void addPerson() {

        while (newPerson) {


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
                phoneNumber = scanner.nextLine();
                if (!isNumeric(phoneNumber)) {
                    System.out.println("That is not a number, please enter a number");
                } else if (phoneNumber.length() >= 11) {
                    System.out.println("I'm sorry that number is too large, place try again.");
                } else if (phoneNumber.length() < 10) {
                    System.out.println("I'm sorry, that is too small please use 10 digits");
                } else {
                    phoneNumberIsBad = false;
                }
            }

            boolean streetNumberIsBad = true;
            while (streetNumberIsBad) {
                    System.out.println("Please enter the address number of the person");
                    streetNumber = scanner.nextLine();
                    if (!isNumeric(streetNumber)) {
                        System.out.println("That is not a number, please enter a number");
                    } else if (phoneNumber.length() < 0) {
                        System.out.println("It seems you have not entered an address number. Please try again .");
                    } else if (phoneNumber.length() < 6) {
                        System.out.println("It seems like that is a little too long for an address number. Why don't you try again.");
                    } else {
                        streetNumberIsBad = false;
                    }
            }

            boolean streetNameIsBad = true;
            while (streetNameIsBad) {
                System.out.println("Please enter the street name they live on");
                streetName = isGoodInput(streetName);
                streetNameIsBad = false;

            }

            boolean aptNumIsBad = true;
            while (aptNumIsBad) {
                    System.out.println("Please enter the apartment number, put n/a leave blank");
                    aptNum = scanner.nextLine();
                    if (aptNum.equalsIgnoreCase("n/a")) {
                        break;
                    } else if (!isNumeric(aptNum)) {
                        System.out.println("That is not a number, please try again");
                    } else if (aptNum.length() >= 6) {
                        System.out.println("It seems like that is a little too long for an apartment number. Why don't you try again.");
                    } else {
                        aptNumIsBad = false;
                    }

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

            boolean emailIsBad = true;
            while (emailIsBad) {
                System.out.println("Please enter the email in of the person");
                email = scanner.nextLine();
                if (!EmailValidator.getInstance().isValid(email)) {
                    System.out.println("I'm sorry, that is an invalid email address. Please enter a valid one:");
                    System.out.println("ex: youremail@domain.com");
                } else {
                    emailIsBad = false;
                }
            }
            people.add(new Person(firstName, middleName, lastName, phoneNumber, streetNumber, streetName, city, state, email, aptNum));
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
                System.out.println("You must enter a valid entry, more than 21 letters. Please try again. ");
            } else if (isNumeric(s)) { // checking to see if the name is numbers
                System.out.println("Numbers are not names, please enter a name.");
            } else {
                if (!Character.isUpperCase(s.charAt(0))) {
                    char a = Character.toUpperCase(s.charAt(0));
                    s = a + s.substring(1);
                    isBadInput = false;
                }
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
                    + " apt: " + person.getAptNum() + " " + person.getCity() + " " + person.getState() + "\n";
        }
        return str;
    }

    public void removePerson() {
        boolean removeMore = true;

        while (removeMore) {
            try {
                System.out.println("Who do you want to remove from the address book?");
                System.out.println(toString());
                System.out.println("Please enter the index number:");
                boolean personToRemoveIsBad = true;
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



