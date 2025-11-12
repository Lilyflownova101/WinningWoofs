package com.techelevator.dao;

import com.techelevator.model.Farm;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcFarmDao implements FarmDao{


    private final JdbcTemplate jdbcTemplate;

    // Constructor --------------------------------------------------------------------------------------------

    public JdbcFarmDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //Method ---------------------------------------------------------------------------------------------------


    public Farm createFarm (Farm farm) {

        String sql = " INSERT INTO farm_table (farm_id, farm_name, farm_location, owner_name, phone) VALUES (?,?,?,?,?);";

        jdbcTemplate.update(sql, farm.getFarmId(), farm.getFarmName(), farm.getFarmLocation(), farm.getOwner(), farm.getPhone());

        return farm;

    }


    public Farm updateFarm(Farm farm) {
        String sql = "UPDATE farm_table SET farm_name = ?, farm_location = ?, owner_name = ?, phone = ? WHERE farm_id = ?;";

        int rowsAffected = jdbcTemplate.update(sql, farm.getFarmName(), farm.getFarmLocation(), farm.getOwner(), farm.getPhone(), farm.getFarmId());
        return farm;
    }

    public boolean deleteFarm(int farmId) {
        String sql = " DELETE FROM farm_table WHERE farm_id =?;";

        int rowsAffected = jdbcTemplate.update(sql, farmId);

        return (rowsAffected >0);
    }






    @Override
    public List<Farm> getFarms() {
        List<Farm> farms = new ArrayList<>();

        String sql = " SELECT * FROM farm_table ORDER BY farm_name ;";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Farm farm = (mapRowToFarm(results));
            farms.add(farm);
        }

        return farms;
    }

    @Override
    public Farm getFarmById(int id) {
        Farm farm = null;

        String sql = "SELECT * FROM farm_table WHERE farm_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            farm = mapRowToFarm(results);
        }

        return farm;
    }

    @Override
    public List<Farm> getFarmByOwnerName(String name, boolean useWildCard) {
        List<Farm> farms = new ArrayList<>();

        if (useWildCard) {
            name = "%" + name + "%";
        }

        String sql = "SELECT * FROM farm_table WHERE LOWER(owner_name) LIKE ? ORDER by farm_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name.toLowerCase());

        while (results.next()){
            farms.add(mapRowToFarm(results));
        }



        return farms;
    }




    private Farm mapRowToFarm(SqlRowSet rowSet) {
        Farm farm = new Farm();

        farm.setFarmId(rowSet.getInt("farm_id"));
        farm.setFarmName(rowSet.getString("farm_name"));
        farm.setFarmLocation(rowSet.getString("farm_location"));
        farm.setOwner(rowSet.getString("owner_name"));
        farm.setPhone(rowSet.getString("phone"));

        return farm;
    }



}
