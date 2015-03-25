package com.github.klambo94.AddressBook;

/**
 * Created by Kendra Lamb on 3/14/2015.
 */
public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private String streetNumber;
    private String streetName;
    private String city;
    private String state;
    private String email;
    private String phoneNumber;
    private String aptNum;


    public Person(String firstName, String middleName, String lastName, String phoneNumber, String streetNumber, String streetName, String city, String state, String email, String aptNum) {
        this.setAptNum(aptNum);
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.setStreetNumber(streetNumber);
        this.setStreetName(streetName);
        this.setCity(city);
        this.setState(state);
        this.setEmail(email);

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getAptNum() {
        return aptNum;
    }

    public void setAptNum(String aptNum) {
        this.aptNum = aptNum;
    }
}
