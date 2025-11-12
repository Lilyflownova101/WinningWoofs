package com.techelevator.RestServiceLayer;

import com.techelevator.model.Breed;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestBreedService implements BreedService{

    // Instance Variables ----------------------------------------------------------

    private static final String API_URL = "https://api.api-ninjas.com/v1/dogs";


    private RestClient restClient = RestClient.create(API_URL);


    // Constructor ---------------------------------------------------------------





    // Methods ---------------------------------------------------------------------

    private String getAPISearchName(String breedName){

        String preformattedSearchName = breedName.trim().toLowerCase();

        switch (preformattedSearchName) {

            case "australian shepherd":
                return "?name=australian shepherd";
            case "border collie":
                return "?name=border collie";
            case "collie":
                return "?name=collie";
            default:
                throw new IllegalArgumentException("Unsupported Breed/ Breed Name Not Recognized: " + breedName);

        }

    }


    @Override
    public Breed getBreedDetails(String breedName) throws RestClientException {

        String apiSearchName = getAPISearchName(breedName);


        

             Breed[] breed = restClient.get()
                     .uri(apiSearchName)
                     .header("x-api-key", "Your API Key Here! (API Ninjas- Dog API)")
                     .retrieve()
                     .body(Breed[].class);








        return breed[0];
    }



}
