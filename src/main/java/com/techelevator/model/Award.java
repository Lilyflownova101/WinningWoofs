package com.techelevator.model;

import java.time.LocalDate;

public class Award {



//Instance Variables _____________________________________________________________________________________

        private int awardId;

        private int dogId;

        private String awardName;

        private String sport;

        private LocalDate competitionDate;

        private String competitionLocation;

        private String place;

// Getters______________________________________________________________________________________________

        public int getAwardId() {
            return awardId;
        }

        public int getDogId() {
            return dogId;
        }

        public String getAwardName() {
            return awardName;
        }

        public String getSport() {
            return sport;
        }

        public LocalDate getCompetitionDate() {
            return competitionDate;
        }

        public String getCompetitionLocation() {
            return competitionLocation;
        }

        public String getPlace() {
            return place;
        }


// Setters ______________________________________________________________________________________________

        public void setAwardId(int awardId) {
            this.awardId = awardId;
        }

        public void setDogId(int dogId) {
            this.dogId = dogId;
        }

        public void setAwardName(String awardName) {
            this.awardName = awardName;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }

        public void setCompetitionDate(LocalDate competitionDate) {
            this.competitionDate = competitionDate;
        }

        public void setCompetitionLocation(String competitionLocation) {
            this.competitionLocation = competitionLocation;
        }

        public void setPlace(String place) {
            this.place = place;
        }


// Constructors _________________________________________________________________________________________

        public Award () {

        }

        public Award(int awardId, int dogId, String awardName, String sport, LocalDate competitionDate, String competitionLocation, String place) {
            this.awardId = awardId;
            this.dogId = dogId;
            this.awardName = awardName;
            this.sport = sport;
            this.competitionDate = competitionDate;
            this.competitionLocation = competitionLocation;
            this.place = place;
        }


// Methods ____________________________________________________________________________________________


    }


