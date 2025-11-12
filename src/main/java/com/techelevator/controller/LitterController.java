package com.techelevator.controller;


import com.techelevator.dao.LitterDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Litter;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/litter")

public class LitterController {

    // Instance Variables -------------------------------------

    private LitterDao litterDao;



    // Constructor --------------------------------------------

    public LitterController (LitterDao litterDao) {
        this.litterDao=litterDao;
    }



    // CRUD Methods ------------------------------------------


    @PreAuthorize("permitAll()")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Litter> listLitters() {
        return litterDao.getLitters();
    }


    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Litter get(@PathVariable int id) {
        Litter litter =  litterDao.getLitterById(id);
        if (litter == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Litter matching that ID not found");
        } else {
            return litter;
        }

    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Litter add(@Valid @RequestBody Litter litter, Principal principal) {
        System.out.println(principal.getName());
        return litterDao.createLitter(litter);

    }


    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Litter update(@Valid @RequestBody Litter litter, @PathVariable int id) {

        litter.setLitterId(id);

        try {
            Litter updatedLitter = litterDao.updateLitter(litter);
            return updatedLitter;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Litter with matching ID not found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        litterDao.deleteLitter(id);
    }


}
