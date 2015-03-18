package com.github.klambo94.AddressBook;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kendra Lamb on 3/14/2015.
 */
public class AddresssBook {
    ArrayList<Person> people = new ArrayList();
    Scanner scanner = new Scanner(System.in); //to get the user's input about a person
    String firstName;
    String middleName;
    String lastName;
    String email;
    String street;
    String city;
    String state;
    String phoneNumber;

    public void addPerson() {
        System.out.println("What is the first name of the person?");
        firstName = scanner.nextLine();
        if (firstName.length() <= 2) {
            System.out.println("You must enter a valid name, more than 2 letters. Please try again. ");
            firstName = scanner.nextLine();
        } else if (isNumeric(firstName)) { // checking to see if the name is numbers
            System.out.println("Numbers are not names, please enter a name");
            firstName = scanner.nextLine();
        } else if (firstName == null || firstName == "") {
            System.out.println("You seem to have not entered a value, please enter a name.");
            firstName = scanner.nextLine();
        }

        System.out.println("What is the middle name of the person?");
        middleName = scanner.nextLine();
        if (middleName.length() <= 2) {
            System.out.println("You must enter a valid name, more than 2 letters. Please try again. ");
            middleName = scanner.nextLine();
        } else if (isNumeric(middleName)) { // checking to see if the name is numbers
            System.out.println("Numbers are not names, please enter a name");
            middleName = scanner.nextLine();
        } else if (middleName == null || middleName == "") {
            System.out.println("You seem to have not entered a value, please enter a name.");
            middleName = scanner.nextLine();
        }

        System.out.println("What is the last name of the person?");
        lastName = scanner.nextLine();
        if (lastName.length() <= 2) {
            System.out.println("You must enter a valid name, more than 2 letters. Please try again. ");
            lastName = scanner.nextLine();
        } else if (isNumeric(lastName)) { // checking to see if the name is numbers
            System.out.println("Numbers are not names, please enter a name");
            lastName = scanner.nextLine();
        } else if (lastName == null || lastName == "") {
            System.out.println("You seem to have not entered a value, please enter a name.");
            lastName = scanner.nextLine();
        }


        System.out.println("Please enter the phone number of the person");
        phoneNumber = scanner.nextLine();
        if (phoneNumber.length() <= 10) {
            System.out.println("I'm sorry, that is too small please use 10 digits");
            phoneNumber = scanner.nextLine();
        } else if (phoneNumber.length() >= 11) {
            System.out.println("I'm sorry that number is too large, place try again.");
        } else if (!isNumeric(phoneNumber)) {
            System.out.println("That is not a number, please enter a number");
        }


        System.out.println("Please enter the street address of where they live");
        street = scanner.nextLine();
        if (street == null || street == "") {
            System.out.println("It seems you have not entered an address. Please enter one.");
            street = scanner.nextLine();
        } else if (street.length() <= 1) {
            System.out.println("That address is not long enough, please enter in a longer address");
        }


        System.out.println("Please enter the City they live in");
        city = scanner.nextLine();
        if (city == null || city == "") {
            System.out.println("It seems you have not entered in a city. Please enter one.");
            city = scanner.nextLine();
        } else if (city.length() <= 2) {
            System.out.println("I'm sorry, that seems the number of characters you've entered does not match the smallest city name length. Try again");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("Please enter in the State they live in.");
        state = scanner.nextLine();
        if (state == null || state == "") {
            System.out.println("It seems you have not entered an address. Please enter one.");
            state = scanner.nextLine();
        }

        System.out.println("Please enter the email in of the person");
        email = scanner.nextLine();
        if (!email.contains("@")) {
            System.out.println("That is an invalid email address please enter: youremail@email.com");
            email = scanner.nextLine();
        } else if (!email.contains(".com") || !email.contains(".net") || !email.contains(".edu") || !email.contains(".gov")) {
            System.out.println("Almost there... but it needs to have a .com, .edu, .net, .gov, etc.");
            email = scanner.nextLine();
        } else if (email.contains("=") || email.contains("{") || email.contains("}") || email.contains("/") || email.contains("?")) {
            System.out.println("The email address you have entered has invalid characters: {} ? / = ");
            System.out.println("Please try again");
            email = scanner.nextLine();
        } else if (email.contains(";") || email.contains(":") || email.contains("[") || email.contains("]") || email.contains("+")) {
            System.out.println("The email address you have entered has invalid characters: : ; [] + ");
            System.out.println("Please try again");
            email = scanner.nextLine();
        }

        people.add(new Person(firstName, middleName, lastName, phoneNumber, street, city, state, email));
        //when print method is set up call it here
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
                    + " " + person.getEmail() + " " + person.getStreet() + " " + person.getCity() + " " + person.getState() + "\n";
        }
        return str;
    }

}
