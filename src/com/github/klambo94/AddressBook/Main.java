package com.github.klambo94.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> options = new ArrayList();
    private static Scanner scanner = new Scanner(System.in);
    private static final String VIEW = "View the Address Book";
    private static final String ADD = "Add a person";
    private static final String REMOVE = "Remove a person";
    private static final String EDIT = "Edit a person";
    private static final String SEARCH = "Search for a person";
    private static final String SORT = "Sort through the Address Book";
    private static final String EXIT = "Exit the Address Book";

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        boolean moreToDo = true;
        createOptions();
        System.out.println("Welcome to the Address Book!");
        while (moreToDo) {
            System.out.println("What do you wish to do?");
            boolean userChoiceIsBad = true;
            while (userChoiceIsBad) {
                try {
                    System.out.println(getUserOptions());
                    int userInput = Integer.parseInt(scanner.nextLine());
                    switch (options.get(userInput)) {
                        case VIEW:
                            System.out.println(addressBook.toString());
                            userChoiceIsBad = false;
                            break;
                        case ADD:
                            addressBook.addPerson();
                            userChoiceIsBad = false;
                            break;
                        case REMOVE:
                            addressBook.removePerson();
                            userChoiceIsBad = false;
                            break;
                        case EDIT:
                            addressBook.editAPerson();
                            userChoiceIsBad = false;
                            break;
                        case SEARCH:
                            addressBook.searchPerson();
                            userChoiceIsBad = false;
                            break;
                        case SORT:
                            addressBook.printSorted();
                            userChoiceIsBad = false;
                            break;
                        case EXIT:
                            userChoiceIsBad = false;
                            break;
                        default:
                            System.out.println("You have not entered a right choice. Please try again.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("I'm sorry, that is not an option. Please chose a number in front of the option.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You've chosen a number that is not part of the option numbers. Try again please.");
                } catch (NullPointerException e) {
                    System.out.println("This is an error.");
                }

            }
            moreToDo = false;
        }
        System.out.println("Have a good day, hope to see you soon!");


    }

    public static void createOptions() {
        options.add(VIEW);
        options.add(ADD);
        options.add(REMOVE);
        options.add(EDIT);
        options.add(SEARCH);
        options.add(SORT);
        options.add(EXIT);
    }

    public static String getUserOptions() {
        String userChoices = "";
        for (int i = 0; i < options.size(); i++) {
            userChoices = userChoices + i + " - " + options.get(i) + "\n";
        }
        return userChoices;
    }

}
