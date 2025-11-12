package com.techelevator.controller;


import com.techelevator.dao.FarmDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Farm;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/farm")
@PreAuthorize("isAuthenticated()")
public class FarmController {

    // Instance Variables --------------------------------------------

    private FarmDao farmDao;


    // Constructor ---------------------------------------------------

    public FarmController(FarmDao farmDao) {
        this.farmDao = farmDao;
    }


    // CRUD Methods --------------------------------------------------



    @PreAuthorize("permitAll()")
    @GetMapping("")
    public List<Farm> listFarms() {
        return farmDao.getFarms();
    }



    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Farm get(@PathVariable int id) {
        Farm farm = farmDao.getFarmById(id);
        if (farm == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Farm matching that ID not found");
        } else {
            return farm;
        }

    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Farm add(@Valid @RequestBody Farm farm, Principal principal) {
        System.out.println(principal.getName());
        return farmDao.createFarm(farm);

    }


    @RequestMapping( path = "/{id}", method = RequestMethod.PUT)
    public Farm update (@Valid @RequestBody Farm farm, @PathVariable int id ) {

        farm.setFarmId(id);
        try {
            Farm updatedFarm = farmDao.updateFarm(farm);
            return updatedFarm;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Farm with matching ID not found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping( path = "/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable int id ) {
        farmDao.deleteFarm(id);
    }



    // Search Methods ------------------------------------------------


}
