package com.github.klambo94.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Kendra Lamb on 3/14/2015.
 */
public class AddresssBook {
    ArrayList<Person> people = new ArrayList();

    Scanner scanner = new Scanner(System.in); //to get the user's input about a person

    public String addPerson() {
        System.out.println("What is the first name of the person?");
        String userInput = scanner.nextLine();
        if (userInput.length() <= 2) {
            System.out.println("You must enter a vaild name, more than 2 letters. Please try again. ");
            userInput = scanner.nextLine();
        }

    }



}
