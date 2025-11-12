package com.techelevator.model;

public class Farm {

    //Instance Variables _____________________________________________________________________________________

    private int farmId;

    private String farmName;

    private String farmLocation;

    private String owner;

    private String phone;



// Getters______________________________________________________________________________________________

    public int getFarmId() {
        return farmId;
    }


    public String getFarmName() {
        return farmName;
    }


    public String getFarmLocation() {
        return farmLocation;
    }


    public String getOwner() {
        return owner;
    }


    public String getPhone() {
        return phone;
    }




// Setters ______________________________________________________________________________________________

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public void setFarmLocation(String farmLocation) {
        this.farmLocation = farmLocation;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

// Constructors _________________________________________________________________________________________

    public Farm(){

    }

    public Farm(int farmId, String farmName, String farmLocation, String owner, String phone) {
        this.farmId = farmId;
        this.farmName = farmName;
        this.farmLocation = farmLocation;
        this.owner = owner;
        this.phone = phone;
    }


// Methods ____________________________________________________________________________________________






}
