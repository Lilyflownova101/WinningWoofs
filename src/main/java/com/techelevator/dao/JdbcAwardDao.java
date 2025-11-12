package com.techelevator.dao;

import com.techelevator.model.Award;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcAwardDao implements AwardDao{

    private final JdbcTemplate jdbcTemplate;
    // Constructor -----------------------------------------------------------------------
    public JdbcAwardDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    // Methods -----------------------------------------------------------------------------



    public Award createAward(Award award) {
        String sql = "INSERT INTO award_table (award_id, dog_id, award_name, sport, competition_date, competition_location, place) VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, award.getAwardId(), award.getDogId(), award.getAwardName(), award.getSport(), award.getCompetitionDate(), award.getCompetitionLocation(), award.getPlace());

        return award;

    }



    public Award updateAward (Award award) {
        String sql = " UPDATE award_table SET dog_id = ?, award_name = ?, sport = ?, competition_date = ?, competition_location= ?, place = ? WHERE award_id = ?  ;";

        int rowsAffected = jdbcTemplate.update(sql, award.getDogId(), award.getAwardName(), award.getSport(), award.getCompetitionDate(), award.getCompetitionLocation(), award.getPlace(), award.getAwardId());

        return award;
    }


    public boolean deleteAward(int awardId){

        String sql = "DELETE FROM award_table WHERE award_id = ?";

        int rowsImpacted = jdbcTemplate.update(sql, awardId);

        return (rowsImpacted >0 );
    }




    @Override
    public List<Award> getAwards() {
        List<Award> awards = new ArrayList<>();

        String sql = "SELECT * FROM award_table ORDER BY award_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Award award  = mapRowToAward(results);
            awards.add(award);
        }



        return awards;
    }

    @Override
    public Award getAwardById(int id) {
        Award award = new Award();

        String sql = " SELECT * FROM award_table WHERE award_id =? ;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            award = mapRowToAward(results);
        }


        return award;
    }

    @Override
    public List<Award> getAwardBySport(String sport) {
        List<Award> awards = new ArrayList<>();


        String sql = "SELECT * FROM award_table WHERE sport LIKE ? ORDER BY award_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, sport);

        while (results.next()) {
            Award award  = mapRowToAward(results);
            awards.add(award);
        }

        return awards;
    }


    public Award mapRowToAward (SqlRowSet rowSet) {
        Award award = new Award();


        award.setAwardId(rowSet.getInt("award_id"));
        award.setDogId(rowSet.getInt("dog_id"));
        award.setAwardName(rowSet.getString("award_name"));
        award.setSport(rowSet.getString("sport"));

        if (rowSet.getDate("competition_date") != null) {
            award.setCompetitionDate(rowSet.getDate("competition_date").toLocalDate());
        } else {
            award.setCompetitionDate(null);
        }

        award.setCompetitionLocation(rowSet.getString("competition_location"));
        award.setPlace(rowSet.getString("place"));



        return award;

    }
}
