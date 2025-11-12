package com.techelevator.controller;


import com.techelevator.dao.AwardDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Award;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/award")
@PreAuthorize("isAuthenticated()")
public class AwardController {



    // Instance Variables --------------------------------------

    private AwardDao awardDao;

    // Constructor ---------------------------------------------


    public AwardController (AwardDao awardDao) {
        this.awardDao=awardDao;
    }

    // CRUD Methods ------------------------------------------------


    @PreAuthorize("permitAll()")
    @GetMapping
    public List<Award> listAwards () {
        return awardDao.getAwards();
    }



    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Award get(@PathVariable int id ) {
        Award award = awardDao.getAwardById(id);
        if (award == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Award matching that ID not found");
        } else {
            return award;
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Award add(@Valid @RequestBody Award award, Principal principal) {

        System.out.println(principal.getName());
            Award updatedAward = awardDao.updateAward(award);
            return updatedAward;

    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable int id ) {
        awardDao.deleteAward(id);
    }



}
