package com.techelevator.model;

import java.time.LocalDate;

public class Litter {

    //Instance Variables _____________________________________________________________________________________

    private int litterId;

    private LocalDate dateOfBirth;

    private int sireId;

    private int damId;

    private int numberOfPuppies;

// Getters______________________________________________________________________________________________

    public int getLitterId() {
        return litterId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getSireId() {
        return sireId;
    }

    public int getDamId() {
        return damId;
    }

    public int getNumberOfPuppies() {
        return numberOfPuppies;
    }


// Setters ______________________________________________________________________________________________

    public void setLitterId(int litterId) {
        this.litterId = litterId;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSireId(int sireId) {
        this.sireId = sireId;
    }

    public void setDamId(int damId) {
        this.damId = damId;
    }

    public void setNumberOfPuppies(int numberOfPuppies) {
        this.numberOfPuppies = numberOfPuppies;
    }


// Constructors _________________________________________________________________________________________

    public Litter () {

    }

    public Litter(int litterId, LocalDate dateOfBirth, int sireId, int damId, int numberOfPuppies) {
        this.litterId = litterId;
        this.dateOfBirth = dateOfBirth;
        this.sireId = sireId;
        this.damId = damId;
        this.numberOfPuppies = numberOfPuppies;
    }


// Methods ____________________________________________________________________________________________




}
