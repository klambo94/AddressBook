package com.github.klambo94.AddressBook;

public class Main {

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        System.out.println("Welcome to the Address Book! Please enter your contacts here");
        addressBook.addPerson();
        System.out.print(addressBook.toString());

    }
}
