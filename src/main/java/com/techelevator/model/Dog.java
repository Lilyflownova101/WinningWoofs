package com.techelevator.model;

public class Dog {

    // Instance Variables ------------------------------------------------------------

    protected int dogId;

    protected String dogType;

    protected  String dogName;

    protected String breed;

    protected String gender;

    protected int farmId;

    protected int litterId;

    protected double age;

    protected Boolean available;

    // Getters -------------------------------------------------------------------------


    public int getDogId() {
        return dogId;
    }

    public String getDogType() {
        return dogType;
    }

    public String getDogName() {
        return dogName;
    }

    public String getBreed() {
        return breed;
    }

    public String getGender() {
        return gender;
    }

    public int getFarmId() {
        return farmId;
    }

    public int getLitterId() {
        return litterId;
    }

    public double getAge() {
        return age;
    }

    public Boolean getAvailable() {
        return available;
    }

    // Setters ----------------------------------------------------------------------------


    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public void setDogType(String dogType) {
        this.dogType=dogType;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public void setLitterId(int litterId) {
        this.litterId = litterId;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    // Constructor -----------------------------------------------------------------------

    public Dog () {

    }

    public Dog(int dogId, String dogType, String dogName, String breed, String gender, int farmId, int litterId, int age, Boolean available) {
        this.dogId = dogId;
        this.dogType=dogType;
        this.dogName = dogName;
        this.breed = breed;
        this.gender = gender;
        this.farmId = farmId;
        this.litterId = litterId;
        this.age = age;
        this.available = available;
    }


    //Methods ---------------------------------------------------------------------------}




}
