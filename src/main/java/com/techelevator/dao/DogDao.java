package com.techelevator.dao;

import com.techelevator.model.Dog;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public interface DogDao {


    // CRUD methods ------------

    Dog createDog(Dog dog);
    // Create a new Dog Object in the SQL Database. This Function should be security locked for breeders(Admin Accounts) only.

    Dog updateDog(Dog dog);
    // Update an existing Dog object in the SQL database using a known ID number. This function should be security locked for breeders(Admin Accounts) only.

    boolean deleteDog(int dogID);
    // Delete an existing Dog object in the SQL Database using a known ID number. This function should be security locked for breeders(Admin accounts) ony.




    // Search Return Methods ---------




    List<Dog> getDogs();
    // Return all Dog Objects

    List<Dog> getAvailableDogs();
    // Return all available dogs.


    Dog getDogById(int id);
    // Return a specific dog using a known ID.

    public List<Dog> getDogsbyUserID(int userID);
    // List ALL dogs associated with a user id.

    List<Dog> getAvailableDogsByGender(String gender);
    // Return all available dogs by Gender.

    public List<Dog> getAvailableDogsByBreed(String breed);
    // Return all available dogs by Breed


    public List<Dog> getAvailableDogsByGenderAndBreed(String gender, String breed);
    // Return dogs matching a specified Gender and Breed

    List<Dog> getDogsByParentID(int dogId);

    // Return available dogs using a known parent ID.

    List<Dog> getDogsByLitterId( int litterId);
    // Return dogs by searching with a known litter ID.

//  List<Dog> getAvailableDogsWhereParentsHaveWonAwards();

    // Return all available dogs where the parents have won an award


}
