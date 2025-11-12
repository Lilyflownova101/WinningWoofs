package com.techelevator.controller;

import com.techelevator.dao.DogDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/dog")
@PreAuthorize("isAuthenticated()")
public class DogController {

    // Instance Variables ---------------------------------

    private DogDao dogDao;
    private UserDao userDao;


    // Constructor ----------------------------------------

    public DogController (DogDao dogDao, UserDao userDao) {
        this.dogDao=dogDao;
        this.userDao=userDao;

    }

    // Methods --------------------------------------------



    @PreAuthorize("permitAll()")
    @GetMapping("")
    public List<Dog> listAvailableDogs() {
        return dogDao.getAvailableDogs();
    }

    @RequestMapping(path = "/myDogs", method = RequestMethod.GET)
    public List<Dog> getAllDogsByUserId (Principal principal){

    String username = principal.getName();

    try {
        User user = userDao.getUserByUsername(username);
    } catch (Exception e) {
    System.out.println("Object does not populate. DAO Search method does not correctly return full object. ");
    }


     User user = userDao.getUserByUsername(username);
    int userId = user.getId();

    return dogDao.getDogsbyUserID(userId);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/gender", method = RequestMethod.GET)
    public List<Dog> listAvailableDogsByGender(@RequestParam String gender) {
        return dogDao.getAvailableDogsByGender(gender);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/breed", method = RequestMethod.GET)
    public List<Dog> listAvailableDogsByBreed(@RequestParam String breed) {
        return dogDao.getAvailableDogsByBreed(breed);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/genderAndBreed", method = RequestMethod.GET)
    public List<Dog> listAvailableDogsByGenderAndBreed(@RequestParam String gender, @RequestParam String breed) {
        return dogDao.getAvailableDogsByGenderAndBreed(gender,breed);
    }


    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Dog get(@PathVariable int id ) {
        Dog dog = dogDao.getDogById(id);
        if (dog == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog matching that ID not found");
        } else {
            return dog;
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "", method = RequestMethod.POST)
    public Dog add(@Valid @RequestBody Dog dog, Principal principal) {
        System.out.println(principal.getName());
        return dogDao.createDog(dog);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Dog update(@Valid @RequestBody Dog dog, @PathVariable int id) {

        dog.setDogId(id);
        try {
            Dog updatedDog = dogDao.updateDog(dog);

            

            return updatedDog;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog with matching ID not found");
        }
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        dogDao.deleteDog(id);

    }

    private Dog mapRowToDog(Dog dog) {

        Dog tempDog= null;

        String dogType = dog.getDogType();

        switch (dogType){

            case "puppy":
                Puppy puppy = new Puppy();


                tempDog=puppy;
                break;

            case "sire":
                Sire sire = new Sire();

                tempDog=sire;
                break;

            case "dam":
                Dam dam = new Dam();
                tempDog=dam;
                break;

        }


        return tempDog;
    }


}
