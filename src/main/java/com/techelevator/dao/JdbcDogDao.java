package com.techelevator.dao;

import com.techelevator.model.Dam;
import com.techelevator.model.Dog;
import com.techelevator.model.Puppy;
import com.techelevator.model.Sire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcDogDao implements DogDao{

    private final JdbcTemplate jdbcTemplate;


    // Constructor------------------------------------------------
    public JdbcDogDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Methods -----------------------------------------------------




    public Dog createDog(Dog dog ) {
        String sql = "INSERT INTO dog_table ( dog_id, dog_type, dog_name, breed, gender, farm_id, litter_id, age, available) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?);";

        jdbcTemplate.update(sql, dog.getDogId(),dog.getDogType(), dog.getDogName(), dog.getBreed(), dog.getGender(), dog.getFarmId(), dog.getLitterId(), dog.getAge(), dog.getAvailable());


        return dog;
    }


    public Dog updateDog(Dog dog) {
        String sql = "UPDATE dog_table SET dog_type = ?, dog_name = ?, breed = ?, gender = ?, farm_id = ?, litter_id = ?, age = ?, available = ? WHERE  dog_id = ? ;";

        int rowsImpacted = jdbcTemplate.update(sql, dog.getDogType(), dog.getDogName(), dog.getBreed(), dog.getGender(), dog.getFarmId(), dog.getLitterId(), dog.getAge(), dog.getAvailable(), dog.getDogId());

        return dog;

    }

    public boolean deleteDog(int dogId) {
        String sql = "DELETE FROM dog_table WHERE dog_id =?;";

        int rowsAffected = jdbcTemplate.update(sql, dogId);

        return (rowsAffected >0);

    }

    @Override
    public List<Dog> getDogsbyUserID(int userID) {
        List<Dog> dogs = new ArrayList<>();

        String sql = "SELECT dog_table.dog_id, dog_table.dog_name, dog_table.dog_type, dog_table.breed, dog_table.gender, dog_table.farm_id, dog_table.litter_id, dog_table.age, dog_table.available FROM dog_table JOIN farm_table ON dog_table.farm_id = farm_table.farm_id JOIN owner_user ON farm_table.owner_id = owner_user.owner_id JOIN users ON owner_user.user_id = users.user_id WHERE users.user_id = ? ORDER BY dog_table.dog_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userID);

        while (results.next()) {
            Dog dog = mapRowToDog(results);
            dogs.add(dog);

        }

    return dogs;
    }



    @Override
    public List<Dog> getDogs() {

        List<Dog> dogs = new ArrayList<>();

        String sql = "SELECT * FROM dog_table ORDER BY dog_name, gender;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Dog dog = mapRowToDog(results);
            dogs.add(dog);
        }

        return dogs;
    }

    @Override
    public List<Dog> getAvailableDogs() {
        List<Dog> dogs = new ArrayList<>();

        String sql = "SELECT dog_id, dog_type, dog_name, breed, gender, farm_id, age, litter_id, available FROM dog_table WHERE available = TRUE ORDER BY dog_name, gender;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){
            Dog dog = mapRowToDog(results);
            dogs.add(dog);

        }

        return dogs;
    }

    @Override
    public Dog getDogById(int id) {
        Dog dog = null;

        String sql = " SELECT * FROM dog_table WHERE dog_id =? ;";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            dog = mapRowToDog(results);
        }


        return dog;
    }



    @Override
    public List<Dog> getAvailableDogsByGender(String gender) {
        List <Dog> dogs = new ArrayList<>();

        String genderToLower = gender.toLowerCase();


        String sql = "SELECT * FROM dog_table WHERE available = TRUE AND LOWER(gender) = ? ORDER BY dog_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genderToLower);

        while(results.next()) {
            dogs.add(mapRowToDog(results));
        }

        return dogs;
    }

    @Override
    public List<Dog> getAvailableDogsByBreed(String breed) {
        List<Dog> dogs = new ArrayList<>();

        String breedToLower = breed.toLowerCase();

        String sql = "SELECT * FROM dog_table WHERE available = TRUE AND LOWER(breed) = ? ORDER BY dog_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql , breedToLower);

        while(results.next()) {
            dogs.add(mapRowToDog(results));
        }
         return dogs;

    }

    @Override
    public List<Dog> getAvailableDogsByGenderAndBreed(String gender, String breed) {
        List<Dog> dogs = new ArrayList<>();

        String genderToLower = gender.toLowerCase();
        String breedToLower = breed.toLowerCase();

        String sql = "SELECT * FROM dog_table WHERE available = TRUE AND LOWER(gender) = ? AND LOWER(breed) = ? ORDER BY dog_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genderToLower, breedToLower);

        while(results.next()) {
            dogs.add(mapRowToDog(results));
        }
        return dogs;
    }


    @Override
    public List<Dog> getDogsByParentID(int dogId) {
        List <Dog> dogs = new ArrayList<>();

        String sql = "SELECT * FROM dog_table WHERE sire_id = ? OR dam_id = ? ORDER BY dog_name, gender;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, dogId, dogId);

        while(results.next()) {
            dogs.add(mapRowToDog(results));
        }



        return dogs;
    }



    @Override
    public List<Dog> getDogsByLitterId(int litterId) {
        List <Dog> dogs = new ArrayList<>();

        String sql = "SELECT * FROM dog_table WHERE litter_id = ? ORDER BY dog_name, gender;;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, litterId);

        while(results.next()) {
            dogs.add(mapRowToDog(results));
        }


        return dogs;
    }

//    @Override
//    public List<Dog> getAvailableDogsWhereParentsHaveWonAwards() {
//        List <Dog> dogs = new ArrayList<>();
//
//        String sql = "SELECT * FROM dog_table JOIN litter_table ON  WHERE available = TRUE AND ";
//
//        return dogs;
//    }


    private void mapCommonDogFields(Dog dog, SqlRowSet rowSet){
        dog.setDogId(rowSet.getInt("dog_id"));
        dog.setDogType(rowSet.getString("dog_type"));
        dog.setDogName(rowSet.getString("dog_name"));
        dog.setBreed(rowSet.getString("breed"));
        dog.setGender(rowSet.getString("gender"));
        dog.setFarmId(rowSet.getInt("farm_id"));
        dog.setLitterId(rowSet.getInt("litter_id"));
        dog.setAge(rowSet.getDouble("age"));
        dog.setAvailable(rowSet.getBoolean("available"));


    }


    private Dog mapRowToDog(SqlRowSet rowSet) {

        Dog dog= null;

        String dogType = rowSet.getString("dog_type").toLowerCase();

        switch (dogType){

            case "puppy":
                Puppy puppy = new Puppy();
                mapCommonDogFields(puppy, rowSet);
                puppy.setPrice(puppy.getAge());
                dog=puppy;
                break;

            case "sire":
                Sire sire = new Sire();
                mapCommonDogFields(sire, rowSet);
                dog=sire;
                break;

            case "dam":
                Dam dam = new Dam();
                mapCommonDogFields(dam, rowSet);
                dog=dam;
                break;

        }


     return dog;
    }

}
