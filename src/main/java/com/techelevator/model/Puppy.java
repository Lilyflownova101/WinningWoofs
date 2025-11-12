package com.techelevator.model;

public class Puppy extends Dog{

    // Instance Variables ---------------------------------------------------

    private double price;

    protected String dogType = "puppy";

    private final double AGE_AT_8_WEEKS = 8.0;
    private final double WEEKS_IN_A_YEAR = 52.0;

    private final double PRICE_AT_8_WEEKS = 800.00;
    private final double PRICE_AT_1_YEAR = 100.00;


     private final double WEEKS_FOR_PRICE_DECREASE = 44;

    private final double WEEKLY_DECREMENT = (PRICE_AT_8_WEEKS - PRICE_AT_1_YEAR) / WEEKS_FOR_PRICE_DECREASE;





    // Methods -------------------------------------------------------------
    public void setPrice(double age) {

        double finalPrice = 0;
        double ageInWeeks = age*WEEKS_IN_A_YEAR;

        if (available) {

            if (ageInWeeks > WEEKS_IN_A_YEAR) {
                finalPrice = PRICE_AT_1_YEAR;
            } else {

                if (ageInWeeks >= AGE_AT_8_WEEKS ) {

                double weeksPast8Weeks = ageInWeeks -AGE_AT_8_WEEKS;

                    double totalDrop = weeksPast8Weeks * WEEKLY_DECREMENT;

                    finalPrice = PRICE_AT_8_WEEKS - totalDrop;

                     if (finalPrice < PRICE_AT_1_YEAR) {
                         finalPrice = PRICE_AT_1_YEAR;
                     }

            } else if (ageInWeeks<AGE_AT_8_WEEKS) {
                    available =false;
                }
            }




        } else {
            System.out.println("Dog is not Available. Please select another.  ");
        }

        this.price = finalPrice;

    }


}
