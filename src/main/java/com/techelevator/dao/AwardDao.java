package com.techelevator.dao;

import com.techelevator.model.Award;

import java.util.List;

public interface AwardDao {

    // CRUD Methods ------------------------

    Award createAward(Award award);
    // Create a new Award object in the SQL Database. This function should be security locked for breeders(Admin Accounts) only.

    Award updateAward(Award award);
    // Updates an Award Object using a known ID number. This function should be security locked for breeders(Admin Accounts) only.

    boolean deleteAward(int awardId);

    // Deleted an Award Object using a known ID number. This function should be security locked for breeders(Admin Accounts) only.



    // Search Methods -----------------------

    List<Award> getAwards();

    // Return all awards.

    Award getAwardById(int id);

    // Return a specific award with a known ID value.

    List<Award> getAwardBySport(String sport);

    // Return a list of awards by sport.


}
