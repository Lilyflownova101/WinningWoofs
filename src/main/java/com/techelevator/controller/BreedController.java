package com.techelevator.controller;

import com.techelevator.RestServiceLayer.RestBreedService;
import com.techelevator.model.Breed;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/breedDetails")
public class BreedController {

    // Instance Variables -------------------------------------------------------

    private RestBreedService restBreedService;


    // Constructor --------------------------------------------------------------



    public BreedController(RestBreedService restBreedService){
        this.restBreedService= restBreedService;
    }










    // Methods ------------------------------------------------------------------


    @GetMapping("")
    public List<Breed> returnBreedDetails( @RequestParam String breedName) {
         List<Breed> listOfBreeds = new ArrayList<>();
       try {
           Breed breed = restBreedService.getBreedDetails(breedName);
           listOfBreeds.add(breed);
           return listOfBreeds;

       } catch (RestClientException e) {
           System.out.println(e);
           return null;

       }


    }









}
