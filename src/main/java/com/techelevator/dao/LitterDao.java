package com.techelevator.dao;

import com.techelevator.model.Litter;

import java.util.List;

public interface LitterDao {

    // CRUD Methods ------------------------------

    Litter createLitter(Litter litter);
    // Create a new Litter Object in the SQL Database. This function should be security locked for breeders(Admin Accounts) only.

    Litter updateLitter(Litter litter);
    // Update a Litter Object using a known ID number. This function should be security locked for breeders(Admin Accounts) only.

    boolean deleteLitter(int literId);
    // Deletes a Litter object using a known ID number. This function should be security locked for breeders(Admin Accounts) only.




    // Search methods -----------------------------

    List<Litter> getLitters();

    // Return all litters.

    Litter getLitterById(int id);

    // Return a litter by a specific known ID value.

    List<Litter> getLitterBySireId(int id);

    // Return litters using specific known sire ID value.

    List<Litter> getLitterByDamId(int id);

    // Return litters using specific known dam ID value.
}
