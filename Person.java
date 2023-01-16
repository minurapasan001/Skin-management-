package com.company;

public class Person {
    private String name;
    private String surName;
    private String dob;
    private String mblNumber;

    public Person(String name, String surName, String dob, String mblNumber) {
        this.name = name;
        this.surName = surName;
        this.dob = dob;
        this.mblNumber = mblNumber;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = String.valueOf(dob);
    }

    public String getMblNumber() {
        return mblNumber;
    }

    public void setMblNumber(String mblNumber) {
        this.mblNumber = mblNumber;
    }


}
