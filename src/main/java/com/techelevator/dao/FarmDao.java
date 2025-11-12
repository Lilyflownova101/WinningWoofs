package com.techelevator.dao;

import com.techelevator.model.Dog;
import com.techelevator.model.Farm;

import java.util.List;

public interface FarmDao {

    // CRUD Methods -----------------------

    Farm createFarm(Farm farm);
    // Create a new Farm Object in the SQL Database. This function should be security locked for breeders(Admin Accounts) only.

    Farm updateFarm(Farm farm);
    // Update a Farm object in the SQL Database. This function should be security locked for breeders(Admin Accounts) only.

    boolean deleteFarm(int farmId);
    // Delete a Farm object in the SQL Database. This function should be security locked for breeders(Admin Accounts) only.


    // Search Return Methods -------------


    List<Farm> getFarms();

    // Return all farms.

    Farm getFarmById(int id);

    // Return a specific farm with a known ID number.


    List<Farm> getFarmByOwnerName(String name, boolean useWildCard);

    // Return farm by searching with a name or a set of letters with wildcard search.

    // List<Farm> getFarmByState() ;
    // Return all Farms in a specified state


}
