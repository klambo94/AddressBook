package com.github.klambo94.AddressBook;

import org.apache.commons.validator.EmailValidator;

import java.util.ArrayList;
import java.util.Iterator;
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
    String removeFirstName = null;
    String removeMiddleName = null;
    String removeLastName = null;
    String removePhoneNumber = null;
    boolean newPerson = true;


    public void addPerson() {

        while (newPerson) {


            boolean firstIsBad = true;
            while (firstIsBad) {
                System.out.println("What is the first name of the person?");
                firstName = scanner.nextLine();
                if (firstName == null || firstName == "") {
                    System.out.println("You seem to have not entered a value, please enter a name.");
                } else if (firstName.length() <= 2) {
                    System.out.println("You must enter a valid name, more than 2 letters. Please try again. ");
                } else if (isNumeric(firstName)) { // checking to see if the name is numbers
                    System.out.println("Numbers are not names, please enter a name.");
                } else if (!Character.isUpperCase(firstName.charAt(0))) {
                    System.out.println("I'm sorry, the first letter need to be Uppercase. Please try again.");
                } else {
                    firstIsBad = false;
                }
            }

            boolean middleIsBad = true;
            while (middleIsBad) {
                System.out.println("What is the middle name of the person?");
                middleName = scanner.nextLine();
                if (middleName == null || middleName == "") {
                    System.out.println("You seem to have not entered a value, please enter a name.");
                } else if (isNumeric(middleName)) { // checking to see if the name is numbers
                    System.out.println("Numbers are not names, please enter a name.");
                } else if (middleName.length() <= 2) {
                    System.out.println("You must enter a valid name, more than 2 letters. Please try again. ");
                } else if (!Character.isUpperCase(middleName.charAt(0))) {
                    System.out.println("I'm sorry, the first letter need to be Uppercase. Please try again.");
                } else {
                    middleIsBad = false;
                }
            }

            boolean lastIsBad = true;
            while (lastIsBad) {
                System.out.println("What is the last name of the person?");
                lastName = scanner.nextLine();
                if (lastName == null || lastName == "") {
                    System.out.println("You seem to have not entered a value, please enter a name.");
                } else if (isNumeric(lastName)) {// checking to see if the name is numbers
                    System.out.println("Numbers are not names, please enter a name.");
                } else if (lastName.length() <= 2) {
                    System.out.println("You must enter a valid name, more than 2 letters. Please try again. ");
                } else if (!Character.isUpperCase(lastName.charAt(0))) {
                    System.out.println("I'm sorry, the first letter need to be Uppercase. Please try again.");
                } else {
                    lastIsBad = false;
                }
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
                try {
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
                } catch (NumberFormatException e) {
                    System.out.println("You either did not enter any number, or have entered the whole address. Please just use the number address.");
                }

            }

            boolean streetNameIsBad = true;
            while (streetNameIsBad) {
                System.out.println("Please enter the street name they live on");
                streetName = scanner.nextLine();
                if (streetName == null || streetName == "") {
                    System.out.println("It seems you have not entered an address. Please enter one.");
                } else if (streetName.length() <= 1) {
                    System.out.println("That address is not long enough, please enter in a longer address");
                } else if (isNumeric(streetName)) {
                    System.out.println("Please do not include the numbers, you have already saved those.");
                    System.out.println("One more time, but just the name of the streetName.");
                } else if (!Character.isUpperCase(streetName.charAt(0))) {
                    System.out.println("I'm sorry, the first letter need to be Uppercase. Please try again.");
                } else {
                    streetNameIsBad = false;
                }
            }

            boolean aptNumIsBad = true;
            while (aptNumIsBad) {
                try {
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
                } catch (NumberFormatException e) {
                    System.out.println("error?");
                }

            }

            boolean cityIsBad = true;
            while (cityIsBad) {
                System.out.println("Please enter the City they live in");
                city = scanner.nextLine();
                if (city == null || city == "") {
                    System.out.println("It seems you have not entered in a city. Please enter one.");
                    ;
                } else if (city.length() <= 2) {
                    System.out.println("I'm sorry, that seems the number of characters you've entered does not match the smallest city name length. Try again");
                } else if (isNumeric(city)) {
                    System.out.println("The name of a city does not have numbers in it. Please enter the name of a city.");
                } else if (!Character.isUpperCase(city.charAt(0))) {
                    System.out.println("I'm sorry, the first letter need to be Uppercase. Please try again.");
                } else {
                    cityIsBad = false;
                }
            }

            boolean stateIsBad = true;
            while (stateIsBad) {
                System.out.println("Please enter in the State they live in.");
                state = scanner.nextLine();
                if (state.length() <= 0) {
                    System.out.println("It seems you have not entered a State name. Please enter one.");
                } else if (state.length() == 1) {
                    System.out.println("What you have entered is too small to be an abbreviation or the name of a State. Please try again.");
                } else if (isNumeric(state)) {
                    System.out.print("Numbers are not apart of State names. Please enter a State name");
                } else if (!Character.isUpperCase(state.charAt(0))) {
                    System.out.println("I'm sorry, the first letter need to be Uppercase. Please try again.");
                } else {
                    stateIsBad = false;
                }
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

        //when print method is set up call it here
        people.toString();
    }


    public static boolean isNumeric(String str) {
        try {
            double numeric = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public String toString() {
        String str = "";
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            str = str + person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName() + " " + person.getPhoneNumber()
                    + " " + person.getEmail() + " " + person.getStreetNumber() + " " + person.getStreetName() + " apt: " + person.getAptNum()
                    + " " + person.getCity() + " " + person.getState() + "\n";
        }
        return str;
    }

    public void removePerson() {
        boolean removeFirstNameIsBad = true;
        boolean removeMiddleNameIsBad = true;
        boolean removeLastNameIsBad = true;
        boolean removePhoneNumberIsBad = true;
        while (removeFirstNameIsBad) {
            System.out.println("Please enter the first name of the person you want to remove.");
            removeFirstName = scanner.nextLine();
            if (removeFirstName == null) {
                System.out.println("You have not entered a person. Please try again.");
            } else if (removeFirstName.length() <= 2) {
                System.out.println("You must enter a valid name, more than 2 letters. Please try again. ");
            } else if (isNumeric(removeFirstName)) { // checking to see if the name is numbers
                System.out.println("Numbers are not names, please enter a name.");
            } else if (!Character.isUpperCase(removeFirstName.charAt(0))) {
                System.out.println("I'm sorry, the first letter need to be Uppercase. Please try again.");
            } else {
                removeFirstNameIsBad = false;
            }
        }
        while (removeMiddleNameIsBad) {
            System.out.println("Please enter the middle Name of the person");
            removeMiddleName = scanner.nextLine();
            if (removeMiddleName == null) {
                System.out.println("You have not entered a person. Please try again.");
            } else if (removeMiddleName.length() <= 2) {
                System.out.println("You must enter a valid name, more than 2 letters. Please try again. ");
            } else if (isNumeric(removeMiddleName)) { // checking to see if the name is numbers
                System.out.println("Numbers are not names, please enter a name.");
            } else if (!Character.isUpperCase(removeMiddleName.charAt(0))) {
                System.out.println("I'm sorry, the first letter need to be Uppercase. Please try again.");
            } else {
                removeMiddleNameIsBad = false;
            }
        }
        while (removeLastNameIsBad) {
            System.out.println("Please enter the last name of the person");
            removeLastName = scanner.nextLine();
            if (removeLastName == null) {
                System.out.println("You have not entered a person. Please try again.");
            } else if (removeLastName.length() <= 2) {
                System.out.println("You must enter a valid name, more than 2 letters. Please try again. ");
            } else if (isNumeric(removeLastName)) { // checking to see if the name is numbers
                System.out.println("Numbers are not names, please enter a name.");
            } else if (!Character.isUpperCase(removeLastName.charAt(0))) {
                System.out.println("I'm sorry, the first letter need to be Uppercase. Please try again.");
            } else {
                removeLastNameIsBad = false;
            }
        }
        while (removePhoneNumberIsBad) {
            System.out.println("Please enter phone number of the person.");
            removePhoneNumber = scanner.nextLine();
            if (!isNumeric(removePhoneNumber)) {
                System.out.println("That is not a number, please enter a number");
            } else if (removePhoneNumber.length() >= 11) {
                System.out.println("I'm sorry that number is too large, place try again.");
            } else if (removePhoneNumber.length() < 10) {
                System.out.println("I'm sorry, that is too small please use 10 digits");
            } else {
                removePhoneNumberIsBad = false;
            }
        }
        Iterator<Person> it = people.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            if (person.getFirstName().equals(removeFirstName) && person.getMiddleName().equals(removeMiddleName) && person.getLastName().equals(removeLastName) && person.getPhoneNumber().equals(removePhoneNumber)) {
                people.remove(it);
            } else {
                System.out.println("Did not remove");
            }
        }
    }
}



