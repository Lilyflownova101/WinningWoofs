package com.techelevator.dao;

import com.techelevator.model.Litter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcLitterDao implements LitterDao{


    private final JdbcTemplate jdbcTemplate;

    //Constructor --------------------------------------------

    public JdbcLitterDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //Methods--------------------------------------------------

    public Litter createLitter(Litter litter) {
        String sql = " INSERT INTO litter_table (litter_id, date_of_birth, sire_id, dam_id, number_of_puppies) VALUES (?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql, litter.getLitterId(), litter.getDateOfBirth(), litter.getSireId(), litter.getDamId(), litter.getNumberOfPuppies());

        return litter;
    }

    public Litter updateLitter(Litter litter) {
        String sql = "UPDATE litter_table SET date_of_birth = ?, sire_id = ?, dam_id = ?, number_of_puppies = ? WHERE litter_id = ?;";

        int rowsAffected = jdbcTemplate.update(sql, litter.getDateOfBirth(), litter.getSireId(), litter.getDamId(), litter.getNumberOfPuppies(), litter.getLitterId());


        return litter;
    }

    public boolean deleteLitter(int litterId) {
        String sql = "DELETE FROM litter_table WHERE litter_id =?;";

        int rowsAffected = jdbcTemplate.update(sql, litterId);

        return (rowsAffected >0 );
    }


    @Override
    public List<Litter> getLitters() {
        List<Litter> litters = new ArrayList<>();


        String sql = "SELECT * FROM litter_table ORDER BY litter_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);


        while (results.next()) {
            Litter litter = mapRowToLitter(results);
            litters.add(litter);

        }

        return litters;
    }

    @Override
    public Litter getLitterById(int id) {
        Litter litter = null;

        String sql = "SELECT * FROM litter_table WHERE litter_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);


        if (results.next()) {
            litter = mapRowToLitter(results);
        }

        return litter;
    }

    @Override
    public List<Litter> getLitterBySireId(int id) {
        List<Litter> litters = new ArrayList<>();

        String sql = "SELECT * FROM litter_table WHERE sire_id = ?  ORDER BY litter_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);


        while (results.next()) {
            Litter litter = mapRowToLitter(results);
            litters.add(litter);

        }

        return litters;
    }

    @Override
    public List<Litter> getLitterByDamId(int id) {
        List<Litter> litters = new ArrayList<>();

        String sql = "SELECT * FROM litter_table WHERE dam_id = ? ORDER BY litter_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        while (results.next()) {
            Litter litter = mapRowToLitter(results);
            litters.add(litter);

        }

        return litters;
    }




    public List<Litter> getLittersByBirthDate(LocalDate startDate, LocalDate endDate) {
        List<Litter> litters = new ArrayList<>();

        String sql = "SELECT * FROM litter_table WHERE date_of_birth BETWEEN ? AND ? ORDER BY litter_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, startDate, endDate);

        while (results.next()) {
            Litter litter = mapRowToLitter(results);
            litters.add(litter);

        }

        return litters;
    }


    private Litter mapRowToLitter(SqlRowSet rowSet) {
        Litter litter = new Litter();

        litter.setLitterId(rowSet.getInt("litter_id"));

        if (rowSet.getDate("date_of_birth") != null) {
            litter.setDateOfBirth(rowSet.getDate("date_of_birth").toLocalDate());
        } else {
            litter.setDateOfBirth(null);
        }

        litter.setSireId(rowSet.getInt("sire_id"));
        litter.setDamId(rowSet.getInt("dam_id"));
        litter.setNumberOfPuppies(rowSet.getInt("number_of_puppies"));


        return litter;
    }


}
