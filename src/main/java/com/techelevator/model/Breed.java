package com.techelevator.model;

public class Breed {

    // Instance Variables -------------------------------------------------

    private String name;


    private int goodWithChildren;

    private int goodWithOtherDogs;

    private int shedding;

    private int grooming;

    private int coatLength;

    private int playfulness;

    private int goodWithStrangers;

    private int drooling;

    private int protectiveness;

    private int trainability;

    private int energy;

    private int barking;

    private double minLifeExpectancy;

    private double maxLifeExpectancy;

    private double maxHeightMale;

    private double maxHeightFemale;

    private double maxWeightMale;

    private double maxWeightFemale;

    private double minHeightMale;

    private double minHeightFemale;

    private double minWeightMale;

    private double minWeightFemale;

    private String imageLink;







    // Getters ------------------------------------------------------------

    public String getName() {
        return name;
    }

    public int getGoodWithChildren() {
        return goodWithChildren;
    }

    public int getGoodWithOtherDogs() {
        return goodWithOtherDogs;
    }

    public int getShedding() {
        return shedding;
    }

    public int getGrooming() {
        return grooming;
    }

    public int getCoatLength() {
        return coatLength;
    }

    public int getPlayfulness() {
        return playfulness;
    }

    public int getGoodWithStrangers() {
        return goodWithStrangers;
    }

    public int getDrooling() {
        return drooling;
    }

    public int getProtectiveness() {
        return protectiveness;
    }

    public int getTrainability() {
        return trainability;
    }

    public int getEnergy() {
        return energy;
    }

    public int getBarking() {
        return barking;
    }

    public double getMinLifeExpectancy() {
        return minLifeExpectancy;
    }

    public double getMaxLifeExpectancy() {
        return maxLifeExpectancy;
    }

    public double getMaxHeightMale() {
        return maxHeightMale;
    }

    public double getMaxHeightFemale() {
        return maxHeightFemale;
    }

    public double getMaxWeightMale() {
        return maxWeightMale;
    }

    public double getMaxWeightFemale() {
        return maxWeightFemale;
    }

    public double getMinHeightMale() {
        return minHeightMale;
    }

    public double getMinHeightFemale() {
        return minHeightFemale;
    }

    public double getMinWeightMale() {
        return minWeightMale;
    }

    public double getMinWeightFemale() {
        return minWeightFemale;
    }

    public String getImageLink() {
        return imageLink;
    }


    // Setters ------------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setGoodWithChildren(int goodWithChildren) {
        this.goodWithChildren = goodWithChildren;
    }

    public void setGoodWithOtherDogs(int goodWithOtherDogs) {
        this.goodWithOtherDogs = goodWithOtherDogs;
    }

    public void setShedding(int shedding) {
        this.shedding = shedding;
    }

    public void setGrooming(int grooming) {
        this.grooming = grooming;
    }

    public void setCoatLength(int coatLength) {
        this.coatLength = coatLength;
    }

    public void setPlayfulness(int playfulness) {
        this.playfulness = playfulness;
    }

    public void setGoodWithStrangers(int goodWithStrangers) {
        this.goodWithStrangers = goodWithStrangers;
    }

    public void setDrooling(int drooling) {
        this.drooling = drooling;
    }

    public void setProtectiveness(int protectiveness) {
        this.protectiveness = protectiveness;
    }

    public void setTrainability(int trainability) {
        this.trainability = trainability;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setBarking(int barking) {
        this.barking = barking;
    }

    public void setMinLifeExpectancy(double minLifeExpectancy) {
        this.minLifeExpectancy = minLifeExpectancy;
    }

    public void setMaxLifeExpectancy(double maxLifeExpectancy) {
        this.maxLifeExpectancy = maxLifeExpectancy;
    }

    public void setMaxHeightMale(double maxHeightMale) {
        this.maxHeightMale = maxHeightMale;
    }

    public void setMaxHeightFemale(double maxHeightFemale) {
        this.maxHeightFemale = maxHeightFemale;
    }

    public void setMaxWeightMale(double maxWeightMale) {
        this.maxWeightMale = maxWeightMale;
    }

    public void setMaxWeightFemale(double maxWeightFemale) {
        this.maxWeightFemale = maxWeightFemale;
    }

    public void setMinHeightMale(double minHeightMale) {
        this.minHeightMale = minHeightMale;
    }

    public void setMinHeightFemale(double minHeightFemale) {
        this.minHeightFemale = minHeightFemale;
    }

    public void setMinWeightMale(double minWeightMale) {
        this.minWeightMale = minWeightMale;
    }

    public void setMinWeightFemale(double minWeightFemale) {
        this.minWeightFemale = minWeightFemale;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }


    // Constructor --------------------------------------------------------

//    public Breed(String name, int goodWithChildren, int goodWithOtherDogs, int shedding, int grooming, int coatLength, int playfulness, int goodWithStrangers, int drooling, int protectiveness, int trainability, int energy, int barking, double minLifeExpectancy, double maxLifeExpectancy, double maxHeightMale, double maxHeightFemale, double maxWeightMale, double maxWeightFemale, double minHeightMale, double minHeightFemale, double minWeightMale, double minWeightFemale, String imageLink) {
//        this.name = name;
//        this.goodWithChildren = goodWithChildren;
//        this.goodWithOtherDogs = goodWithOtherDogs;
//        this.shedding = shedding;
//        this.grooming = grooming;
//        this.coatLength = coatLength;
//        this.playfulness = playfulness;
//        this.goodWithStrangers = goodWithStrangers;
//        this.drooling = drooling;
//        this.protectiveness = protectiveness;
//        this.trainability = trainability;
//        this.energy = energy;
//        this.barking = barking;
//        this.minLifeExpectancy = minLifeExpectancy;
//        this.maxLifeExpectancy = maxLifeExpectancy;
//        this.maxHeightMale = maxHeightMale;
//        this.maxHeightFemale = maxHeightFemale;
//        this.maxWeightMale = maxWeightMale;
//        this.maxWeightFemale = maxWeightFemale;
//        this.minHeightMale = minHeightMale;
//        this.minHeightFemale = minHeightFemale;
//        this.minWeightMale = minWeightMale;
//        this.minWeightFemale = minWeightFemale;
//        this.imageLink = imageLink;
//    }

    public Breed () {}


    public Breed (String name, int goodWithChildren, int shedding, int grooming, int coatLength, int playfulness, int trainability, double maxLifeExpectancy, double minLifeExpectancy) {
       this.name=name;
       this.goodWithChildren= goodWithChildren;
       this.shedding=shedding;
       this.grooming=grooming;
       this.coatLength=coatLength;
       this.playfulness=playfulness;
       this.trainability=trainability;
       this.maxLifeExpectancy=maxLifeExpectancy;
       this.minLifeExpectancy=minLifeExpectancy;

    }


    // Methods -----------------------------------------------------------

}
